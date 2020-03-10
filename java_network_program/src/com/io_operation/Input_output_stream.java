package com.io_operation;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Input_output_stream {
	public static void main(String[] args) {
		
		
		try {
			FileInputStream inputStream=new FileInputStream("sanjeet.txt");
			int data=inputStream.read();
			while(data!=-1) {
				System.out.println(data);
				data=inputStream.read();
			}
			inputStream.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			FileOutputStream fileOutputStream=new FileOutputStream("sanjeet.txt");
			char c='s';
			fileOutputStream.write(c);
			String p="This is working..";
			fileOutputStream.write(p.getBytes());
			fileOutputStream.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
