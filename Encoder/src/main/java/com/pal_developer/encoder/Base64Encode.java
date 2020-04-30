package com.pal_developer.encoder;

import java.util.Base64;

public class Base64Encode {
	public static void main(String[] args) {
		String pal="pal-developer";
		System.out.println("value in String format \t"+pal);
		String Base64encodedvalue=Base64.getEncoder().encodeToString(pal.getBytes());
		System.out.println("value in base64 format\t"+Base64encodedvalue);
		
	}
}
