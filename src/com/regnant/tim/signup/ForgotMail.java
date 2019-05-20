package com.regnant.tim.signup;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ForgotMail {

	public void Mailsend(String name,String tomail, String otp) {

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
			message.setFrom(new InternetAddress(senderEmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(tomail));
			message.setSubject("Reset Your TIM Account Password");
			message.setText(" Dear "+name+"\n\n\n Your Otp: "+otp+"\n\n\nIf you don't want to change your password or didn't request this, please ignore and delete this message. \n\n\n\n\n Thanks&Regards \n Trust In Me(TIM) Team.");
			Transport.send(message);
			System.out.println("Message sent Succesfully");
		} catch (AddressException e) {
			System.out.println("Exception in Forgot Mail");
			e.printStackTrace();
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}
	
}