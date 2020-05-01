package com.pal_developer.encryption;

import java.nio.charset.StandardCharsets;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class BCrypt_Encrypt {
	public static void main(String[] args) {
		String password="pal-developer";
		String bcrypt_password=BCrypt.withDefaults().hashToString(12, password.toCharArray());
		
		BCrypt.Result result=BCrypt.verifyer().verify(password.toCharArray(),bcrypt_password);
		System.out.println(bcrypt_password);
		System.out.println(result.verified);
		/* strict validation */
		/*
		byte[] hash_pass=BCrypt.with(BCrypt.Version.VERSION_2Y).hash(12, password.toCharArray());
		BCrypt.Result strict_result=BCrypt.verifyer(BCrypt.Version.VERSION_2Y).verifyStrict(password.getBytes(StandardCharsets.UTF_8),hash_pass);
		
		//System.out.println(hash_pass.toString());
		System.out.println(strict_result.verified);
		*/
	}
}
