package jim.charles.stock.alert;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email 
{
	private static String myEmail = "stockalert101@yahoo.com";
	private static String password = "Jim101Charles";
	static String subject = "Stock Alert";
	static String host = "smtp.mail.yahoo.com";
	//    static String jim = "jimzqw@gmail.com";
	//    static String charles = "charles_loper2001@yahoo.com";
	//    static String claire = "clairemason@ymail.com";

	/**
	 * 
	 * @param email takes a String the will be 
	 * used as the email recipient
	 */
	public static void sendEmail(String email, String body)
	{
		// Get system properties
		Properties prop = System.getProperties();
		// Setup mail server
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", host);
		prop.put("mail.smtp.user", myEmail);
		prop.put("mail.smtp.password", password);
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");

		// Get the default Session object.
		Session session = Session.getDefaultInstance(prop);

		try
		{
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(myEmail));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

			// Set Subject: header field
			message.setSubject(subject);

			// Now set the actual message
			message.setText(body);

			// Send message
			Transport transport = session.getTransport("smtp");
			transport.connect(host, myEmail, password);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			System.out.println("Sent message successfully....");
		}
		catch (MessagingException mex) 
		{
			mex.printStackTrace();
		}
	}
}