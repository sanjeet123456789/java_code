package com.pal_developer.decoder;

import java.util.Base64;

public class Base64Decode {
	public static void main(String[] args) {
		String Base64encodedvalue="cGFsLWRldmVsb3Blcg==";
		System.out.println("value in base64 format \t"+Base64encodedvalue);
		String pal= new String(Base64.getDecoder().decode(Base64encodedvalue));
		System.out.println("value in String format\t"+pal);
		
	}
}
