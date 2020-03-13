package com.web_server;

import java.net.ServerSocket;
import java.net.Socket;

//https is connectionless
//https is media independent
//https is stateless



//Https Request
//GET /home.html
//HOst:ip_address
//COnnection:keep-alive
//user-agent-browser_name
//Content-type=text/html
//Accept:Encoding:gzip ,*/
//accept-Language:en-US

//Httpsresponse
//http response status
//date:
//	serverjava tiny web server
//	content-length
//	content-type:text/html
//	body
public class Web_server {
	public static void main(String[] args) {
		
		
		try {
			ServerSocket serverSocket=new ServerSocket(80);
			boolean flag=false;
			while(!flag) {
				Socket client_socket=serverSocket.accept();
				System.out.println("User"+client_socket.getInetAddress().getHostAddress());
				Client_Thread t=new Client_Thread(client_socket);
				t.start();
				
			}
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
}
