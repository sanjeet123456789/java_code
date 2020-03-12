package com.java_socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;

public class Ping_ {
	public static void main(String[] args) {
		try {
			String host_add="goosefile.com";
			InetAddress host=InetAddress.getByName(host_add);
			System.out.println(host.isReachable(3000));
			
			
			//The process class allows you to execute operating system command as a subprocess  as if we are running it in a command line
			Process p=Runtime.getRuntime().exec("ping "+host_add);
			BufferedReader inputStream =new BufferedReader(new InputStreamReader(p.getInputStream()));
			
			String commandOutput="";
			boolean isReachable=true;
			while((commandOutput = inputStream.readLine())!=null ) {
				System.out.println(commandOutput);
				if(commandOutput.contains("Destination host unreachable")) {
					break;
				}
			
			}
			if(isReachable) {
				System.out.println("Host is reachable");
			}else {
				System.out.println("host is unreachable..");
			}
			
			
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
}
