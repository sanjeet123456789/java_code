package com.pal_developer.encryption;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PBKDF2_with_SHA1 {
	//slow down brute force attack
	//it is based on work factor-(security factor)/iteration count
	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
		String password="pal-developer";
		String hashpassword=null;
		int iterations=1520;
		char[] chars=password.toCharArray();
		byte[] salt=getsalt();
		
		PBEKeySpec pbekey=new PBEKeySpec(chars,salt,iterations,64*8);
		SecretKeyFactory secretkey=SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		byte[] hashbytearray=secretkey.generateSecret(pbekey).getEncoded();
		
		/*StringBuffer stringbuffer=new StringBuffer();
		for(int x=0;x<hashbytearray.length;x++) {
			stringbuffer.append(Integer.toString(hashbytearray[x]));
		}
		System.out.println(stringbuffer);*/
		System.out.println(hashbytearray.length);
		hashpassword=iterations+":"+toHex(salt)+":"+toHex(hashbytearray);
		System.out.println(hashpassword);
		
	}
	//generate salt
	private static byte[] getsalt() throws NoSuchAlgorithmException {
		SecureRandom secureRandom=SecureRandom.getInstance("SHA1PRNG");
		byte[] salt=new byte[16];
		secureRandom.nextBytes(salt);
		return salt;
		
	}
	//converting to Hex
	private static String toHex(byte[] hashbytearray ) {
		BigInteger bigInteger=new BigInteger(1,hashbytearray);
		String hexstring=bigInteger.toString(16);
		int hexstringLength=(hashbytearray.length*2)-hexstring.length();
		System.out.println(hexstring.length());
		//System.out.println(hexstringLength);
		if(hexstringLength>0) {
			return String.format("%0"+hexstringLength+"d",0)+hexstring;
		}else {
			return hexstring;
		}
	}
	
}
