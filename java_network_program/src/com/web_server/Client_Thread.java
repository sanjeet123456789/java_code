package com.web_server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class Client_Thread extends Thread{

	private Socket socket;
	private boolean flag;
	private BufferedReader buffer_read;
	private PrintWriter output;
	private File file;
	final static String CRLF="\r\n";
	public Client_Thread(Socket client_socket) {
		// TODO Auto-generated constructor stub
		this.socket=client_socket;
		this.flag=false;
	}
	
	public void run() {
		try {
			while(!flag) {
				buffer_read=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				output=new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
				String line;
				//for html header
				String HTTP_Header="";
				//to store the required html file
				String htmlFile="";
				while(true) {
					line=buffer_read.readLine();
					if(line.equals(CRLF)||line.equals("")) {
						//if end of header is reached break the loop
						
						break;
					}
					HTTP_Header=HTTP_Header+line+"\n";
					if(line.contains("GET")){
						
						//to extract the html file
						int begin_Index=line.indexOf("/");
						int end_Index=line.indexOf("HTTP");
						htmlFile=line.substring(begin_Index+1,end_Index);
						
					}
				}
//				System.out.println(HTTP_Header);;
				processRequest(htmlFile);
				close_connection();
			
			}
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}

	private void processRequest(String htmlFile) throws Exception {
		File file=new File(htmlFile);
		if(file.exists()) {
			
			//creating a bufferedreader to read the html file content
			BufferedReader reader=new BufferedReader(new FileReader(file));
			
			
			//send the HTTP head
			  output.print("HTTP/1.0 200 OK" + CRLF);
             Date date = new Date();
			 output.print("Date: " + date.toString() + CRLF);
			 output.print("Server: java tiny web server" + CRLF);
			 output.print("Content-Type: text/html" + CRLF);
			 output.print("Content-Length: " + file.length() + CRLF);
			 output.println("Content-Type: text/html; charset=iso-8859-1" + CRLF);
	
			 	String line="";
			 	while((line=reader.readLine())!=null) {//reading the line from httmp file
			 		output.println(line);//write the line tot the socekt connection
			 	}
			 	
		
		}else {//if file didnot exist
			output.print("HTTP/1.1 404 Not Found" + CRLF);
            Date date = new Date();
            output.print("Date: " + date.toString() + CRLF);
            output.print("Server: java tiny web server" + CRLF);
            output.print("Connection: close" + CRLF);
            output.println("Content-Type: text/html; charset=iso-8859-1" + CRLF);
			
            
            //sending file not found message
            output.println("<html><head>");
            output.println("<title>404 Not Found</title>");
            output.println("</head><body>");
            output.println("<h1>Not Found</h1>");
            output.println("<p>The requested URL /" + htmlFile + " was not found on this server.</p>");
            output.println("</body></html>");
            output.println(CRLF);
		}
		
	}
	private void close_connection() {
		try
        {
            output.close(); 
            buffer_read.close();
            socket.close(); 
            flag = true; 
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
	}
	
}
