package com.pal_developer.Email;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

public class Receive_email {
	
	public static void main(String[] args) throws MessagingException, IOException {
		
		
		/*Properties props=new Properties();
		props.load(new FileInputStream(new File("/home/sanjeet/Documents/java-code/java_code/Email/smtp.properties")));
		*/
		
		Properties props=new Properties();
		props.put("mail.smtp.host", "smtp.gamil.com");
		props.put("mail.smtp.socketFactory.port",465);
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.port", 465);
		
		Session session=Session.getDefaultInstance(props,null);
		
		Store store=session.getStore("imaps");
		store.connect("smtp.gmail.com","sanjeetpal007@gmail.com","***");
		
		
		/*
		private String getTextFromMimeMultipart(
        MimeMultipart mimeMultipart)  throws MessagingException, IOException{
    String result = "";
    int count = mimeMultipart.getCount();
    for (int i = 0; i < count; i++) {
        BodyPart bodyPart = mimeMultipart.getBodyPart(i);
        if (bodyPart.isMimeType("text/plain")) {
            result = result + "\n" + bodyPart.getContent();
            break; // without break same text appears twice in my tests
        } else if (bodyPart.isMimeType("text/html")) {
            String html = (String) bodyPart.getContent();
            result = result + "\n" + org.jsoup.Jsoup.parse(html).text();
        } else if (bodyPart.getContent() instanceof MimeMultipart){
            result = result + getTextFromMimeMultipart((MimeMultipart)bodyPart.getContent());
        }
    }
    return result;*/
		
		
		
		
		
		
		
		
		
		
		Folder inbox=store.getFolder("inbox");
		inbox.open(Folder.READ_ONLY);
		int messageCount=inbox.getMessageCount();
		System.out.println("total messages..\t"+messageCount);
		
		Message[] messages=inbox.getMessages();
		//first 10 email
		for(int x=messageCount-1;x>messageCount-10;x--) {
			System.out.println("Mail header..\t"+messages[x].getSubject());
			System.out.println("Mail body..\t"+messages[x].getContentType());
		}
		inbox.close(true);
		store.close();
		
	
	
	
	}
	
	
}
