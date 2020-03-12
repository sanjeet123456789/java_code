package com.java_socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class RemoteHost_Port_Scanner {
	public static void main(String[] args) {
		
		//creating a buffer reader to read user input
		InputStreamReader input_stream=new InputStreamReader(System.in);
		BufferedReader reader=new BufferedReader(input_stream);
		
		String serverIp="";
		int Start_Port=0;
		int End_Port=0;
		System.out.println("please Enter the serverIP/targetIp adredd");
		try {
			serverIp=reader.readLine();
		}catch(Exception e) {
			System.out.println("Invalid ip"+e.toString());
		}
		
		//valid to controll the validation process
		boolean isValid=false;
		while(!isValid) {
			//to obtain valid port number
			try{
				System.out.println("Please enter strating port number:");
				String portString=reader.readLine();
				Start_Port=Integer.parseInt(portString);
				if(Start_Port>=0 && Start_Port<=65536) {
					isValid=true;
				}else {
					System.out.println("Invalid port number :please enter start port number:");
				}
				
			}catch(NumberFormatException e) {
				//if user doesnot enter number
				System.out.println("please enter a valid number");
			}catch(IOException e) {
				//any error caused during readLine exceution
				e.printStackTrace();
			}catch(Exception e) {
				//for other exception
				e.printStackTrace();
			}
			
			
			
		}
		isValid=false;
		while(!isValid) {
			//to obtain valid port number
			try{
				System.out.println("Please enter ending port number:");
				String portString=reader.readLine();
				End_Port=Integer.parseInt(portString);
				if(End_Port>=0 && End_Port<=65536) {
					if(End_Port>=Start_Port) {
						isValid=true;
					}
					
				}else {
					System.out.println("Invalid port number :please enter ending port number:");
				}
				
			}catch(NumberFormatException e) {
				//if user doesnot enter number
				System.out.println("please enter a valid number");
			}catch(IOException e) {
				//any error caused during readLine exceution
				e.printStackTrace();
			}catch(Exception e) {
				//for other exception
				e.printStackTrace();
			}

		}
		
		int port=Start_Port;
		while(port>=Start_Port && port<=End_Port) {
			try {
				System.out.println(serverIp+""+port);
				Socket socket=new Socket(serverIp,port);
				System.out.println(port+"is in listining state:");
				socket.close();
			}catch (UnknownHostException e) {
				//is exceuterd if serverIp is doesnot exist
				System.out.println(e.toString());
				
			}catch (IOException e) {
				//executed when port is already opened
				System.out.println(e.toString());
			}catch (Exception e) {
				//other exception occur
				System.out.println(e.toString());
			}
			port++;

		}

		
		
	}
}
