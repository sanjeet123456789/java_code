package com.java_socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
	private Socket socket=null;
	public ClientThread(Socket socket ) {
		this.socket=socket;
	}
	
	public void run() {
		
		try {
			
			PrintWriter writer=new PrintWriter(socket.getOutputStream(),true);
			writer.println("Hello client please say something..");
			BufferedReader buffer=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String client_input=buffer.readLine();
			
			System.out.println(client_input);
			buffer.close();
			writer.close();
			socket.close();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
