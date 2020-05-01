package com.pal_developer.encryption;

import java.io.ObjectInputStream.GetField;
import java.security.GeneralSecurityException;

import com.lambdaworks.crypto.SCrypt;
import com.lambdaworks.crypto.SCryptUtil;

public class SCrypt_Encrypt {
	public static void main(String[] args) throws GeneralSecurityException {
		
		//scrypt format
		/*
		 * $s0$params$salt$key
		 * s0 -version0 of the format with 128-bit salt and 256-bitderived key
		 * params -32-bit hex integer container log2(N)(16bits),r(8bits) and p(8bits)
		 * salt-base64-encoded salt
		 * key-bse64-encoded derived key
		 * 
		 * 
		 * * @param passwd    Password.
		 * @param salt      Salt.
		 * @param N         CPU cost parameter.
		 * @param r         Memory cost parameter.
		 * @param p         Parallelization parameter.
		 * @param dkLen     Intended length of the derived key.
		 * 
		 * 
		 * 
		 * 
		 */
		String password="pal-developer";
		int N=16384;
		String salt="pal";
		int r=8;
		int p=1;
		int dkLen=256;
		String hash_pass=SCryptUtil.scrypt(password, dkLen, r, p);
		boolean	result = SCryptUtil.check("pal-developer", hash_pass);
		System.out.println(hash_pass);
		System.out.println(result);		
		         
	}
}
