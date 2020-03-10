package com.io_operation;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Print_Stream {
	public static void main(String[] args) {
		
		try {
			PrintStream output=new PrintStream("print_stream.txt");
			int val=10;
			//printstream is similar to systemout.println
			
			
			System.out.println("The val is: " + val);
            
            output.println("The val is: " + val);
            output.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
