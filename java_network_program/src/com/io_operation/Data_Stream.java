package com.io_operation;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Data_Stream {
	public static void main(String[] args) {
		//create a file in java 
		//File class represent a path
		File file=new File("fun.txt");
		if(file.exists()) {
			System.out.println("file already exist");
		}else {
			try {
				if(file.createNewFile()) {
					System.out.println("file is create"+file.getAbsolutePath());
					
				}else {
					System.out.println("file not created");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			DataOutputStream output=new DataOutputStream(new FileOutputStream(file));
			
			output.write(72);
			output.writeDouble(10.2);
			output.close();
			DataInputStream inputstrem=new DataInputStream(new FileInputStream(file));
			int val1=inputstrem.read();
			double val2=inputstrem.readDouble();
			System.out.println(val1+" "+val2);
			inputstrem.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
