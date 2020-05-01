package com.pal_developer.encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class SHA256 {
	
	//simple hash Algorithm
	//cryptographic hash functions
	//not always unique
	//different types of hashing
	//SHA-1(160 bit Hash)
	//SHA-256(256 bit Hash)
	//SHA-384(384 bit Hash)
	//SHA-512(512 bit Hash)
	public static void main(String[] args) throws NoSuchAlgorithmException {
		String password="pal-developer";
		String hashpassword=null;
		byte[] salt=getsalt();
		MessageDigest messageDigest=MessageDigest.getInstance("SHA-512");
		messageDigest.update(salt);
		byte[] bytes=messageDigest.digest(password.getBytes());
		StringBuilder stringbuilder=new StringBuilder();
		for(int x=0;x<bytes.length;x++) {
			stringbuilder.append(Integer.toString((bytes[x]&0xff)+0x100,16).substring(1));
		}
		hashpassword=stringbuilder.toString();
		System.out.println(password);
		System.out.println(hashpassword);
	
	}
	//creating a slat
	private static byte[] getsalt() throws NoSuchAlgorithmException {
		SecureRandom secureRandom=SecureRandom.getInstance("SHA1PRNG");
		byte[] salt=new byte[20];//bytes can be 16,18,22
		secureRandom.nextBytes(salt);
		return salt;
		
	}
}
