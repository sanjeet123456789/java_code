package com.io_operation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class Buffer_Stream {
	public static void main(String[] args) {
		try {
			//Buffer help to send a block of data not a single char over a TTP Connection
			//BufferInput and BuffedOutput Stream create BUffrered BytesStream
			//BufferReader and BufferedWriter Stream crete Buffered charsStream
			//Filereader and FileWriter is user to read upon char not bytes
			BufferedReader read_buffer=new BufferedReader(new FileReader("buffer_Stream.txt"),1024);
			BufferedWriter write_buffer=new BufferedWriter(new FileWriter("buffer_Stream2.txt"));
			
//			write_buffer.write("THi si dsfi asdjkf \n akdsjfkljadslj \n fjadskljf");
//			
//			write_buffer.flush();
//			write_buffer.close();
			
			String line=null;
			while((line=read_buffer.readLine())!=null) {
				write_buffer.write(line);
				write_buffer.newLine();
			}
			write_buffer.close();
			read_buffer.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
