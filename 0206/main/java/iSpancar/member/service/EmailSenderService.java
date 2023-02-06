package iSpancar.member.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

	@Autowired
	private JavaMailSender mailSender;
	
	public void sendEmail(String toEmail,String subject,String body) throws MessagingException {
		
//		SimpleMailMessage message = new SimpleMailMessage();
//		message.setFrom("ericz1451450@gmail.com");
//		message.setTo(toEmail);
//		message.setText(body);
//		message.setSubject(subject);
//		
//		mailSender.send(message);
		
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		
		helper.setFrom("ericz1451450@gmail.com");
		helper.setTo(toEmail);
		helper.setText(body,true);
		helper.setSubject(subject);
		
		mailSender.send(message);	
		
		System.out.println("mail send!!");
		
	}
	
}
