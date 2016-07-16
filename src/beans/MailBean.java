package beans;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailBean {

	private String to, from, subject, body;

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public void send() throws Exception {

		Properties props = System.getProperties();
		props.put("mail.smtp.auth", "true");
		
		Session session = Session.getDefaultInstance(props,
   		   new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication
             getPasswordAuthentication() {
                 return new PasswordAuthentication
                                ("scott@mail.st.com", "s");
             }
         });


		// construct the message
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(from));
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
		msg.setDataHandler(new DataHandler(body, "text/html"));
		msg.setSubject(subject);
		msg.setSentDate(new Date());
		Transport.send(msg); // send message

	}

}
