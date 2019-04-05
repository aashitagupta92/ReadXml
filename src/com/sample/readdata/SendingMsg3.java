package com.sample.readdata;
import java.util.Properties;

	import javax.mail.Message;
	import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
	import javax.mail.Transport;
	import javax.mail.Message.RecipientType;
	import javax.mail.internet.InternetAddress;
	import javax.mail.internet.MimeMessage;

	//first from, to, subject, & text values are set

	public class SendingMsg3 {
		public static void main(String [] args) throws MessagingException{
		 String from="dagli.khushbu@gmail.com";
	     String to="aashitagupta92@gmail.com";
	     String subject="This is subject line!!";
	     String text="This is actual message!!";
	 // send method is called in the end
	 

	        Properties props = new Properties();
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.host", "localhost");
	    props.put("mail.smtp.auth", "true");// set to false for no username
	    //props.put("mail.debug", "false");
	    props.put("mail.smtp.port", "465");

	    Session session = Session.getDefaultInstance(props);

	    InternetAddress fromAddress = null;
	    InternetAddress toAddress = null;
	    Transport transport = session.getTransport("smtp");
	    transport.connect();
	    try {
	        Message simpleMessage = new MimeMessage(session);
	        fromAddress = new InternetAddress(from);
	        toAddress = new InternetAddress(to);
	        simpleMessage.setFrom(fromAddress);
	        simpleMessage.setRecipient(RecipientType.TO, toAddress);
	        simpleMessage.setSubject(subject);
	        simpleMessage.setText(text);
	        transport.sendMessage(simpleMessage,
	                simpleMessage.getAllRecipients());
	    } catch (MessagingException e) {
	        e.printStackTrace();
	    } finally {
	        transport.close();
	    }
	     }
	 }
