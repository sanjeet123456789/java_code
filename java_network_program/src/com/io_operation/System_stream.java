package com.io_operation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//system stream is used to take keyboard value
public class System_stream {
	public static void main(String[] args) {
		System.out.print("Please enter the port number: ");
        
        InputStreamReader in = new InputStreamReader(System.in);
        
        BufferedReader reader  = new BufferedReader(in);
        
        boolean isValid = false;
        int port = 0;
        
        while(!isValid)
        {
            try
            {
                String portString = reader.readLine();
                port = Integer.parseInt(portString);
                isValid = true;
            }
            catch(Exception e)
            {
                System.out.printf("Please enter the port number: ");
            }
        }
        
        System.out.print("Please enter Server IP address: ");
        
        String ipAddress = "";
        
        try
        {
            ipAddress = reader.readLine();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        System.out.println(" connected to IP: " + ipAddress+ ":" + port + "...");
        
	}
}
