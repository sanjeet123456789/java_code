package com.java_socket;

import java.io.IOException;
import java.net.ServerSocket;

public class Local_Port_Scanner {
	public static void main(String[] args) {
		
		 /* checking listining port 
		int port=1;
		while(port<=65535) {
			try {
				ServerSocket server=new ServerSocket(port);
				//we cannot pass listining port number as an argument to the ServerSocket //cmd> netstat -a
				//server.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//	e.printStackTrace();
				System.out.println(port);
			}
			port++;
		}
		*/
		
		
		
		try {
			ServerSocket server=new ServerSocket(9090);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
}
