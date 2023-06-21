package Email_app;

import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;

public class ReceiveEmail {

	public static void main(String[] args) {
		System.out.println("Reading...");
		
		final String username = "btdhumal333@gmail.com";
		final String password = "xyysstluqvzzxrbr";
	   
	    Properties properties = new Properties();
	    properties.setProperty("mail.imap.host", "imap.gmail.com");
	    properties.setProperty("mail.imap.port", "993");
	    properties.setProperty("mail.imap.ssl.enable", "true");
	   
	      try {
	         Session session = Session.getDefaultInstance(properties);
	         Store store = session.getStore("imaps");
	         store.connect("imap.gmail.com", username, password);
	   
	         Folder inbox = store.getFolder("INBOX");
	         inbox.open(Folder.READ_ONLY);
	   
	         Message[] messages = inbox.getMessages();
	         for (int i = 0; i < messages.length; i++) {
	        	 System.out.println("From: " + messages[i].getFrom()[0]);
	        	 System.out.println("Subject: " + messages[i].getSubject());
	        	 System.out.println("Text: " + messages[i].getContent().toString());
	        	 System.out.println("\n");
	         }
	   
	         inbox.close(false);
	         store.close();
	      } catch (Exception ex) {
	         ex.printStackTrace();
	      }

	}

}
