package Email_app;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	 public static void main(String[] args) {

		 	System.out.println("Sending...");
		 	String to = "btdhumal333@gmail.com";
		 	String from = "btdhumal333@gmail.com";
	        final String username = "btdhumal333@gmail.com";
	        final String password = "xyysstluqvzzxrbr";

	        Properties properties = new Properties();
	        properties.setProperty("mail.smtp.auth", "true");
	        properties.setProperty("mail.smtp.starttls.enable", "true");
	        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
	        properties.setProperty("mail.smtp.port", "587");

	        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(username, password);
	            }
	          });

	        try {

	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(from));
	            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
	            message.setSubject("Mail Confirmation");
	            message.setText("Hello Mam,"+"\n \n This messeage is just for testing an Email Application using Java.");

	            Transport.send(message);

	            System.out.println("Email sent successfully...");

	        } catch (MessagingException e) {
	            throw new RuntimeException(e);
	        }
	    }
}
