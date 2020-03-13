package com.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Udp_server {
	public static void main(String[] args) {
		
		try {
			DatagramSocket socket=new DatagramSocket(9090);
			byte[] receive_data=new byte[1024];
			byte[] send_data=new byte[1024];
			while(true) {
				DatagramPacket receivePacket=new DatagramPacket(receive_data,receive_data.length);
				socket.receive(receivePacket);
				String receiving_data =new String(receivePacket.getData());
				System.out.println("Received data at server"+receiving_data);
				String data="hello client this message is from server";
				//TCP server create threate different thread for different client 
				//udp server didnot create multiple thread for different client and accept data multiple users
				//udp connection doesnot create a connection between source and destination
				send_data=data.getBytes();
				InetAddress clientIpAddress=receivePacket.getAddress();
				int clientPort=receivePacket.getPort();
				DatagramPacket send_data_to_client=new DatagramPacket(send_data,send_data.length,clientIpAddress,clientPort);
				socket.send(send_data_to_client);
				
				
				
				
			}
			
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		
	}
}
