package com.java_socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_socket {
	public static void main(String[] args) throws Exception{
		ServerSocket server_socket=new ServerSocket(9090);
		Socket socket=server_socket.accept();
		//accept method return socket object object to do input outputstream
		//use telnet ot  send data in clear text you cannot use backspace or nay other special character
		PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
		out.println("hello from server");
		BufferedReader input=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String clientInput=input.readLine();
		System.out.println("please enter from server(cmd)");
		System.out.println(clientInput);
		
		input.close();
		out.close();
		socket.close();
		//open telnet client in your pc from uninstall program page click install feature program
		//open cmd and type >telnet localhost 9090
		//server_socket.close();
	}
}
