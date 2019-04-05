package com.sample.readdata;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.Authenticator;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.activation.*;
import javax.mail.Message.RecipientType;

public class SendingMsgPart2 {

   public static void main(String [] args) {    
      // Recipient's email ID needs to be mentioned.
      String to = "aashitagupta92@gmail.com";

      // Sender's email ID needs to be mentioned
      String from = "dagli.khushbu@gmail.com";

      // Assuming you are sending email from localhost
      //String host = "localhost";
      // Get system properties
      //Properties properties = System.getProperties();
      Properties properties =  new Properties();
      // Setup mail server
      properties.put("mail.transport.protocol", "smtp");
      properties.put("mail.smtp.auth", "true");
      properties.put("mail.smtp.starttls.enable", "true");
      properties.put("mail.smtp.host", "smtp.gmail.com");
      properties.put("mail.smtp.port", "465");
      // Get the default Session object.
      Session session = Session.getInstance(properties, new javax.mail.Authenticator()
      {
    	  @Override
    	  protected PasswordAuthentication getPasswordAuthentication()
    	  {
    		  return new PasswordAuthentication("dagli.khushbu@gmail.com", "kerela2406");
    	  }
      });

      try {
         // Create a default MimeMessage object.
         Message message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));
         System.out.println(from);

         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
         System.out.println(to);
         // Set Subject: header field
         message.setSubject("This is the Subject Line!");

         // Now set the actual message
         message.setText("This is actual message");
         System.out.println("Final");

         // Send message
         Transport transport = session.getTransport("smtp");
         transport.connect();
        Transport.send(message);
         System.out.println("jghj");
         System.out.println("Sent message successfully....");
      } catch (MessagingException mex) {
         mex.printStackTrace();
         
      }
   }
}