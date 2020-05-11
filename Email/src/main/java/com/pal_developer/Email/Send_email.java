package com.pal_developer.Email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Send_email {
	public static void main(String[] args) {
		//receiver info
		String to="sitesking2@gmail.com";
		//make sure to make sending email address less secure by going to https://myaccount.google.com/lesssecureapps
		//sender info
		String from="sanjeetpal007@gmail.com";
		final String username="sanjeetpal007@gmail.com";
		final String pass="**";
		String host="smtp.gmail.com";
		
		
		Properties prop=new Properties();
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.starttls.enable",true);
		prop.put("mail.smtp.host", host);
		prop.put("mail.smtp.port", 587);
		
		
		//getting session object
		Session session=Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, pass);
			}
			
		});
		System.out.println("message sending.."+session);
		try {
			//creating message object
			MimeMessage message=new MimeMessage(session);
			
			message.setFrom(new InternetAddress(from));
			//message.setFrom(new InternetAddress("me", "SPecial message"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject("This  is email subject header");
			message.setText("this is email message boody <h2>Html form</h2> ");
		
			
			Transport.send(message);
			System.out.println("message send successfully..<h2>This is header</h2>");
			
			
		}catch(MessagingException e) {
			e.getMessage();
		}
		System.out.println("message sending..");
	}
}
