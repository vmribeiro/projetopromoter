package apd3.negocios.mgtAfiliado;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailUtil {

    public static boolean sendEmail(String to,String subject,String msg) {

        final String username = "apd3Project@gmail.com";
        final String password = "(aPd03123456)";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            
            message.setFrom(new InternetAddress("apd3Project@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject(subject);
            message.setContent(msg, "text/html; charset=utf-8");
//            message.setText(msg);
            Transport.send(message);
            return true;

        } catch (MessagingException e) {
            System.out.println("Email error: "+e);
            return false;
        }
    }

}
