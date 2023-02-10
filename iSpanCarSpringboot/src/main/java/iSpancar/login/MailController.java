package iSpancar.login;

import java.util.Random;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import iSpancar.member.service.EmailSenderService;

@Controller
public class MailController {

	@Autowired
	private EmailSenderService emailSenderService;
	
	//寄送信件
	@PostMapping("/sendmailforverify.controller")
	@ResponseBody
	public String processSendMail(@RequestParam("email")String email) throws MessagingException {
		String randomCode = randomCode();
		String htmltext = "<body>\r\n"
				+ "    <div class=\"card\" style=\"width: 25rem;position: relative;\r\n"
//				+ "    display: flex;\r\n"
				+ "    flex-direction: column;\r\n"
				+ "    min-width: 0;\r\n"
				+ "    word-wrap: break-word;\r\n"
				+ "    background-color: #fff;\r\n"
				+ "    background-clip: border-box;\r\n"
				+ "    border: 1px solid rgba(0,0,0,.125);\r\n"
				+ "    border-radius: 0.25rem;\">\r\n"
				+ "        <img src=\"https://i0.wp.com/techsaydigi.com/wp-content/uploads/2022/10/8a9dd110b406bdbc9280f9b6d712ada4.jpg\"\r\n"
				+ "            class=\"card-img-top\" alt=\"...\" width=\"100%\">\r\n"
				+ "        <div class=\"card-body\" style=\"margin-bottom: 0.5rem;\">\r\n"
				+ "            <h2 class=\"card-title\" style=\"text-align: center;\">資車會驗證碼</h2>\r\n"
				+ "            <h1 class=\"card-text\"  style=\"text-align: center;\">"+randomCode+"\r\n"
				+ "                </h1>\r\n"
				+ "        </div>\r\n"
				+ "    </div>\r\n"
				+ "</body>";
		emailSenderService.sendEmail(email, "資車會驗證信件", htmltext);
		return randomCode;
	}
	
	 public String randomCode(){
	        StringBuilder str = new StringBuilder();
	        Random random = new Random();
	        for (int i = 0; i < 6; i++) {
	            str.append(random.nextInt(10));
	        }
	        return str.toString();
	    }
}
