package com.ftp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class C_Thread extends Thread{

	
	private Socket socket;
	private BufferedReader buffer_read;
	private BufferedOutputStream output;
	private BufferedInputStream fileReader;
	
	public C_Thread(Socket client_socket) {
		// TODO Auto-generated constructor stub
		this.socket=client_socket;
	}
	
	public void run() {
		try {
			buffer_read=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//buffered id efficient for file transfer
			
			
			output=new BufferedOutputStream(socket.getOutputStream());
			
			String file_name=buffer_read.readLine();
			
			System.out.println("file_name: "+file_name+"request from "+socket.getInetAddress().getHostAddress());
			File file=new File(file_name);
			
			if(!file.exists()) {
				byte code=(byte)0;
				output.write(code);
				close_all_connection();
			}else {
				output.write((byte)1);
				fileReader=new BufferedInputStream(new FileInputStream(file));
				byte[] buffer=new byte[1024];
				int bytesRead=0;
				while((bytesRead=fileReader.read(buffer))!= -1) {
					output.write(buffer,0,bytesRead);
					output.flush();
					//flush to send a content of bytes array to the socket
				}
				close_all_connection();
				
			}
			
			
			
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}

	private void close_all_connection() {
		try {
			if(output!=null) {
				output.close();
			}if(buffer_read!=null) {
				buffer_read.close();
			}if(fileReader!=null) {
				fileReader.close();
			}if(output!=null) {
				socket.close();
			}
			
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		
	}

}
