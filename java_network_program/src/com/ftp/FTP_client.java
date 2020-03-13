package com.ftp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import org.apache.commons.validator.routines.InetAddressValidator;

public class FTP_client {
	public static void main(String[] args) {
		try {
			
			InputStreamReader input_stream=new InputStreamReader(System.in);
			BufferedReader buffer_read=new BufferedReader(input_stream);
		
			String ip_address="";
			String file_Name="";
			boolean flag=false;
			while(!flag) {
				System.out.println("please enter a server Address::");
				ip_address=buffer_read.readLine();
				InetAddressValidator  ip_validator=new InetAddressValidator();
				flag=ip_validator.isValid(ip_address);
				
				
				
			}
			
			System.out.println("please a file name:");
			file_Name=buffer_read.readLine();
			Socket socket=new Socket(ip_address,2601);
			InputStream inputByte=socket.getInputStream();
			BufferedInputStream buffer_input=new BufferedInputStream(inputByte);
			PrintWriter print_out=new PrintWriter(socket.getOutputStream(),true);
			
			
			print_out.println(file_Name);
			int code=buffer_input.read();
			if(code==1) {
				BufferedOutputStream output_file=new BufferedOutputStream(new FileOutputStream("c:\\Users\\"+file_Name));
				//bufferedoutputstream to write file to this computer
				byte[] buffer=new byte[1024];
				int bytesRead=0;
//				byte size=-127 to 128
				while((bytesRead=buffer_input.read(buffer))!=-1) {
					//read read some byte from input stream
					System.out.println(".");
					output_file.write(buffer,0,bytesRead);
					//write byte size to socket connetcion over tcp connection
					//
					output_file.flush();
				}
				
				System.out.println();
				System.out.println("File:"+file_Name+"downloaded");
			
			}else {
				System.out.println("File not found..on server");
			}
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		
		
	}
}
