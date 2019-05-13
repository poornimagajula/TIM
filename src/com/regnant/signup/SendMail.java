package com.regnant.signup;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

	public void Mailsend(String tomail) {

		final String senderEmail = "trustinme.tim@gmail.com";
		final String password = "trust@123";

		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");

		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderEmail, password);
			}
		});
		Message message = new MimeMessage(session);

		try {
			message.setFrom(new InternetAddress("poornima.thota87@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(tomail));
			message.setSubject("Greetings from Trust In Me");
			String name=getname();
			message.setText(" Mr/Ms."+name+"\n Thanks for Registering with Trust In Me. \n\n\n\n\n Thanks&Regards \n Trust In Me(TIM) Team.");

			Transport.send(message);
			System.out.println("Message sent Succesfully");
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}
	String ename;
	public void setname(String name) {
		this.ename=name;
	}
	public String getname() {
		return ename;
	}
//	public static void main(String[] args) {
//		SendMail sm=new SendMail();
//		sm.Mailsend("poornima.thota31@gmail.com");
//	
//	}
}