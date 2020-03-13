package com.smtp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Stmp_email_socket 
{
	//make sure to run locahost stmp server on your pc
	//enable less secure app :: https://myaccount.google.com/lesssecureapps
    private static Socket s_socket;
    private static PrintWriter output;
    private static BufferedReader buffer;
    public static void main(String [] args)
    {
       
        try {
            s_socket = new Socket("localhost", 25);
            buffer = new BufferedReader(new InputStreamReader(s_socket.getInputStream()));
            output = new PrintWriter(s_socket.getOutputStream(), true);
        } catch (UnknownHostException e) {
           System.out.println(e.toString());
        } catch (IOException e) {
            System.out.println(e.toString());
        }
      
        if (s_socket != null && output != null && buffer != null) {
            try {
             
                String responseLine;
                while ((responseLine = buffer.readLine()) != null) {
                    System.out.println("Server: " + responseLine);
                    if (responseLine.indexOf("220") != -1) {
                        break;
                    }
                }
                
               
                
                output.println("HELO " + InetAddress.getLocalHost().getHostAddress());
                System.out.println("HELO " + InetAddress.getLocalHost().getHostAddress());
                while ((responseLine = buffer.readLine()) != null) {
                    System.out.println("Server: " + responseLine);
                    if (responseLine.indexOf("250") != -1) {
                        break;
                    }
                }
                
             
                output.println("MAIL From: sanjeet@pal.com");
                while ((responseLine = buffer.readLine()) != null) {
                    System.out.println("Server: " + responseLine);
                    if (responseLine.indexOf("250") != -1) {
                        break;
                    }
                }
                
           
                output.println("RCPT TO: sanjeetpal123456789@gmail.com");
                while ((responseLine = buffer.readLine()) != null) {
                    System.out.println("Server: " + responseLine);
                    if (responseLine.indexOf("250") != -1) {
                        break;
                    }
                }
                
            
                
                output.println("DATA");
                while ((responseLine = buffer.readLine()) != null) {
                    System.out.println("Server: " + responseLine);
                    if (responseLine.indexOf("354") != -1) {
                        break;
                    }
                }
                
           
                output.println("From: sanjeet@pal.com");
                output.println("To: snajeetpal123456789@gmail.com");
                output.println("Subject: TEST EMAIL");
                output.println();
                output.println("Subject: TEST EMAIL"); 
                output.println("This is a test message"); 
                output.println("Thanks,"); 
                output.println("Java Network Programming course"); 
                output.println();
                output.println(".");

                
                while ((responseLine = buffer.readLine()) != null) {
                    System.out.println("Server: " + responseLine);
                    if (responseLine.indexOf("250") != -1) {
                      break;
                    }
                }
                
                output.println("QUIT");
                                
                while ((responseLine = buffer.readLine()) != null) {
                    System.out.println("Server: " + responseLine);
                    if (responseLine.indexOf("221") != -1) {
                      break;
                    }
                }
                
                System.out.println("Email successfully sent!");
                
                output.close();
                buffer.close();
                s_socket.close(); 
               
            }
            catch(Exception e)
            {
                System.out.println(e.toString());
            }
        }
    }
}
