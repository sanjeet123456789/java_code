package com.java_socket;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.List;

public class NetworkInterface_ {
	public static void main(String[] args) {
		try {
			//Network interface class are static and there fore we cannot initiateit
			//network interface provide method to enumerate all the local address regardless of interface and to create inetaddress 
			//inetaddress can be used to create socket
			
			
			InetAddress address=InetAddress.getByName("192.168.43.8");
//			NetworkInterface networkInterface= NetworkInterface.getByInetAddress(address);
//			NetworkInterface networkInterface=NetworkInterface.getByName("wlan1");
			Enumeration<NetworkInterface> networkInterfaces=NetworkInterface.getNetworkInterfaces();
			
			while(networkInterfaces.hasMoreElements()) {
				NetworkInterface networkInterface=networkInterfaces.nextElement();
			
			
				if(networkInterface!=null) {
					System.out.println("NIC name: "+networkInterface.getName());
					System.out.println("NIC display Name: "+networkInterface.getDisplayName());
					System.out.println("NIC get hardware address(MAC)"+convertByteToString(networkInterface.getHardwareAddress()));
	
					System.out.println("MTU: "+networkInterface.getMTU());
					System.out.println("index:"+networkInterface.getIndex());
					NetworkInterface parentINterface=networkInterface.getParent();
					if(parentINterface!=null) {
						System.out.println("Parent interface: "+parentINterface.getDisplayName());
					}else {
						System.out.println("NO parent interface");
					}
					System.out.println("Is loopback?"+networkInterface.isLoopback());
					System.out.println("is up"+networkInterface.isUp());
					System.out.println("is virtual "+networkInterface.isVirtual());
					System.out.println("Support mulicast: "+networkInterface.supportsMulticast());
					List<InterfaceAddress> list =networkInterface.getInterfaceAddresses();
					for(int i=0;i<list.size();i++) {
						System.out.println("Ip Address: "+(list.get(i).getAddress().getHostAddress()));
					}
				}else {
					System.out.println("networkInterface Found");
				}
				System.out.println("------------------------------------------------------------------");
			
			}
			
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		
	}
	public static String convertByteToString(byte []mac) {
		
		if(mac==null)
			return null;
		
		StringBuilder sb=new StringBuilder(18);
		for(byte b:mac) {
			if(sb.length()>0)
				sb.append(':');
			
			sb.append(String.format("%02x", b));
			 
		}
		return sb.toString();
		
		
	}
}
