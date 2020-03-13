package com.ftp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FTP_Server {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket=new ServerSocket(2601);
			boolean flag=false;
			while(!flag){
				Socket client_socket=serverSocket.accept();
				C_Thread c_thread=new C_Thread(client_socket);
				c_thread.start();
			}
			
			
		}catch(IOException e) {
			//if port is already listening
			System.out.println(e.toString());
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
}
