package com.io_operation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Character_Stream {
	public static void main(String[] args) {
		try {
			OutputStreamWriter output=new OutputStreamWriter(new FileOutputStream("character_stream.txt"),"ASCII");
			InputStreamReader input=new InputStreamReader(new FileInputStream("character_stream.txt"),"ASCII");
			//ASCII is a character you want to set for the file example:=utf8,ASCII,Cp1252
			 //ASCII doesnot know how to represent languages characters
			System.out.println(output.getEncoding());
			output.write("This is good");
			//output.flush();
			//close method call the flush method
			//flush let the buffered data to be written in file while not closing the file means we call write method after flush method call
			output.flush();
			int data=input.read();
			while(data!=-1) {
				System.out.print((char)data);
				data=input.read();
			}
			output.close();
			input.close();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
