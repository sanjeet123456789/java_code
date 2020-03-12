package com.java_socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.sun.corba.se.spi.activation.Server;

public class MultiHost_server {
	public static void main(String[] args) {
		try {
			ServerSocket server=new ServerSocket(9090);
			boolean stop=false;
			while(!stop) {
				Socket socket=server.accept();
				
				PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
				out.println("This is from server please say something");
				BufferedReader buffer_reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
				//we cannot accept request from multiple client at the same time for this we have to implement multithreading
				
				String buffer_chache=buffer_reader.readLine();
				System.out.println(buffer_chache);
				
				buffer_reader.close();
				out.close();
				socket.close();
			}
			server.close();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
