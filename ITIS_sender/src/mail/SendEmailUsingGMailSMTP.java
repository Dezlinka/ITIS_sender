package mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmailUsingGMailSMTP {
   public void Sender(String recipient,String recruitname,String arms) {

      String to = recipient;

      String from = "ruslanasuspad@gmail.com";
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
//        

          Message message = new MimeMessage(session);


	   message.setFrom(new InternetAddress(from));


	   message.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse(to));


	   message.setSubject("University");


	   message.setContent(recruitname + "<h1> Please take your homework from library : </h1>"+arms,
	             "text/html");


	   Transport.send(message);

	   System.out.println("Sent message successfully.");

      } catch (MessagingException e) {
            throw new RuntimeException(e);
      }
   }
}