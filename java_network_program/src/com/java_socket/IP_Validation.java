package com.java_socket;

import org.apache.commons.validator.routines.InetAddressValidator;

//import org.apache.commons.validator.routines.InetAddressValidatorTest;

public class IP_Validation {
	public static void main(String[] args) {
	InetAddressValidator validator=new InetAddressValidator();
	String ipAddress="192.168.0.100";
	boolean isValid=validator.isValid(ipAddress);
	if(isValid) {
		System.out.println(ipAddress+"isvalid");
	}else {
		System.out.println(ipAddress+"is not Valid");
	}
		 
		 
		 
	}
//	 public boolean validateIpAddress(String ipAddress) {
//		 
//		 String[] numbers=ipAddress.split("\\.");
//		 
//		 if(numbers.length!=4) {
//			 return false;
//		 }for(String str:numbers) {
//			 int i=Integer.parseInt(str);
//			 if((i<0)  || (i>255)) {
//				 return false;
//			 }
//		 }
//		 
//		 return true;
//	 }
}
