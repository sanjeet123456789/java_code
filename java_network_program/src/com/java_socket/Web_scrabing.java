package com.java_socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Web_scrabing {
	public static void main(String[] args) throws IOException {
		//we can read data on url or urlconnection using inputstreamsreader of bufferreader
		//creating url object
		
		URL url=new URL("https://goosefile.com/");
		URLConnection url_conn=url.openConnection();
		BufferedReader reader=new BufferedReader(new InputStreamReader(url_conn.getInputStream()));
		String x;
		while((x=reader.readLine())!=null){
			System.out.println(x);
			
			
		}
		
	}
}
