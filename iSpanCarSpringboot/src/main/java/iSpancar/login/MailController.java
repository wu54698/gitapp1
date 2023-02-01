package iSpancar.login;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import iSpancar.member.service.EmailSenderService;

@Controller
public class MailController {

	@Autowired
	private EmailSenderService emailSenderService;
	
	//寄送信件
	@PostMapping("/sendmail.controller")
	public void processSendMail() throws MessagingException {
		String verifyLink = "xx";
		String htmltext = "<html><body>" +
				"<p class='text-primary'>請點擊以下連結進行驗證：<br>" +
				"<a class='btn btn-primary' href='" + verifyLink + "'>" + verifyLink + "</a></p>" +
				"</body></html>";
		emailSenderService.sendEmail("ericz1451450@gmail.com", "Title", htmltext);
	}
}
