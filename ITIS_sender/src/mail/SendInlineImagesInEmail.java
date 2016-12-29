package mail;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendInlineImagesInEmail {
   public static void main(String[] args) {

	      String to = "dezl9873@gmail.com";


	      String from = "dezl9873@gmail.com";
	      final String username = "login";
	      final String password = "pass";


	      String host = "smtp.gmail.com";

	      Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", "587");


	      Session session = Session.getInstance(props,
	      new javax.mail.Authenticator() {
	         protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(username, password);
	         }
	      });

      try {


         Message message = new MimeMessage(session);

         message.setFrom(new InternetAddress(from));

         message.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse(to));

         message.setSubject("Testing Subject");


         MimeMultipart multipart = new MimeMultipart("related");


         BodyPart messageBodyPart = new MimeBodyPart();
         String htmlText = "<H1>Hello</H1><img src=\"cid:image\">";
         messageBodyPart.setContent(htmlText, "text/html");

         multipart.addBodyPart(messageBodyPart);


         messageBodyPart = new MimeBodyPart();
         DataSource fds = new FileDataSource(
            "/students.jpg");

         messageBodyPart.setDataHandler(new DataHandler(fds));
         messageBodyPart.setHeader("Content-ID", "<image>");


         multipart.addBodyPart(messageBodyPart);


         message.setContent(multipart);

         Transport.send(message);

         System.out.println("Sent message successfully.");

      } catch (MessagingException e) {
         throw new RuntimeException(e);
      }
   }
}