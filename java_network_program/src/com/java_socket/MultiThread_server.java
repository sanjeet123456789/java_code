package com.java_socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThread_server {
	public static void main(String[] args) {
		try {
			ServerSocket server=new ServerSocket(9090);
			boolean flag=false;
			while(!flag) {
				System.out.println("waiting for client");
				Socket socket=server.accept();
				System.out.println("client connected.");
				ClientThread  clientthread=new ClientThread(socket);
				
				clientthread.start();
				
			}
			server.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
