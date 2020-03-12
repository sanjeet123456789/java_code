package com.java_socket;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Internet_Address {
	public static void main(String[] args) {
		
		try {
			InetAddress inetaddress=InetAddress.getLocalHost();
			System.out.println(inetaddress.getHostName());
			System.out.println(inetaddress.getHostAddress());
			System.out.println(inetaddress);
			
			InetAddress address=InetAddress.getByName("google.com");

			System.out.println(address);
			
			
			
			InetAddress address2=InetAddress.getByName("192.227.113.84");
			System.out.println(address2);
			

			InetAddress address3=InetAddress.getByName("sitesking.info");
			System.out.println(address3);
			
			Socket socket=new Socket(address2,9090);
			
			
			socket.close();
		
		}catch(Exception e) {
			
		}
	}
}
