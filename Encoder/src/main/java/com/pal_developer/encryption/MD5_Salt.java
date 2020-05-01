package com.pal_developer.encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

public class MD5_Salt {
	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException {
	
	String password="pal-developer";
	byte[] salt = getsalt();
		
	MessageDigest messagedigest=MessageDigest.getInstance("MD5");
	//adding password bytes to digest
	
	
	/*
	messagedigest.update(password.getBytes());
	byte[] bytes=messagedigest.digest();
	*/
	
	
	
	// uncomment below line to use md5 with salt
	messagedigest.update(salt);
	byte[] bytes=messagedigest.digest(password.getBytes());
	
	
	//converting bytes01010110 into hexadecimal0a45f5cd8e format
	StringBuilder stringbuilder=new StringBuilder();
	for(int x=0;x<bytes.length;x++) {
		//stringbuilder.append(Integer.toString((bytes[x])));	
		//for salt generated
		
		stringbuilder.append(Integer.toString((bytes[x]&0xff)+0x100,1).substring(1));
		
	}
	
	
	
	//getting compiled hashed password
	String Md5password=stringbuilder.toString();
	
	
	/* generate salt  for md5 hash*/
	System.out.println(password);
	System.out.println(Md5password);

	
	
	}
	/* generate salt  for md5 hash
	 * 
	 * -- use as cryptographically strong psedo-random */
	private static byte[] getsalt() throws NoSuchAlgorithmException, NoSuchProviderException{
		
		SecureRandom secureRandom=SecureRandom.getInstance("SHA1PRNG","SUN");
		//byte array for salt
		byte[] salt=new byte[20];
		//generate random salt
		secureRandom.nextBytes(salt);
		return salt;
		
	}
	
}
//Note:-This is not a example of crazy hashing and salting
