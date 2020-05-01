package com.pal_developer.encryption;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PBKDF2_with_SHA1_Validation {
	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
		String password="pal-developer";
		String hashcode_validate="1520:6e64060d1722227d4d9e87eb1188ded9:dbabff460caf74f6b3f71f645feff5645a36174d2591ea0b2524192f66eafa0496a0a16e36f1f9c36d5e54c713d0d9a035cc04f0c0da904d151408de36bbe135";
		boolean match=false;
		String[] splithash=hashcode_validate.split(":");
		int iterators=Integer.parseInt(splithash[0]);
		byte[] salt=fromHex(splithash[1]);
		byte[] hash=fromHex(splithash[2]);
		PBEKeySpec PBEkey = new PBEKeySpec(password.toCharArray(), salt, iterators, hash.length * 8);
	    SecretKeyFactory specialkey = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
	    byte[] testHash = specialkey.generateSecret(PBEkey).getEncoded();
		
	    int diff = hash.length ^ testHash.length;
        for(int i = 0; i < hash.length && i < testHash.length; i++)
        {
            diff |= hash[i] ^ testHash[i];
        }
        
		match=(diff==0);
		if (match==true) {
			System.out.println("pass");
		}else {
			System.out.println("fail");
		}
		
		
	}
	//check hex
	private static byte[] fromHex(String hex) {
		byte[] hexbytes=new byte[hex.length()/2];
		for(int i=0;i<hexbytes.length;i++) {
			hexbytes[i]=(byte)Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
			
		}
		return hexbytes;
	}
}
