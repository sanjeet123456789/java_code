package com.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Udp_client {
	public static void main(String[] args) {
		try {
			DatagramSocket clientSocket=new DatagramSocket(0);
			//udp header size=65508 
			//udp data 65535
			byte[] send_data=new byte[1024];
			byte[] receive_data=new byte[1024];
			
			
			String sending_data="hello server";
			send_data=sending_data.getBytes();
			InetAddress server_address=InetAddress.getByName("localhost");
			DatagramPacket sendpacket=new DatagramPacket(send_data,send_data.length,server_address,9090);
			clientSocket.setSoTimeout(5000);
			clientSocket.send(sendpacket);
			DatagramPacket receievPacket=new DatagramPacket(receive_data,receive_data.length);
			clientSocket.receive(receievPacket);
			receive_data =receievPacket.getData();
			String reveicing_data=new String(receive_data);
			System.out.println(reveicing_data);
			clientSocket.close();
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
}
