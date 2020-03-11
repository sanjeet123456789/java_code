package com.java_socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client_socket {
	public static void main(String[] args) {
		try {
			InetAddress server_address=InetAddress.getByName("localhost");
			
			Socket socket=new Socket(server_address,9090);
			//give Connection refuse because no server running on given port
			PrintWriter writer=new PrintWriter(socket.getOutputStream(),true);
			BufferedReader buffer=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			String x=buffer.readLine();
			System.out.println(x);
			writer.write(x);
			writer.close();
			buffer.close();
			socket.close();
			
			System.out.println("done");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
