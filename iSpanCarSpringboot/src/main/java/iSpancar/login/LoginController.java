package iSpancar.login;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import iSpancar.member.model.MemberBean;
import iSpancar.member.service.MemberService;

@Controller
@SessionAttributes("LoginOK")
public class LoginController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/login.controller")
    public String processAction(@RequestParam("accountnumber") String accountnumber, @RequestParam("memberpassword") String memberpassword, Model model, HttpServletRequest request) {
        try {
            String check = memberService.checkaccountnumberpassword(accountnumber, memberpassword);
            List<MemberBean> list = memberService.findbyaccountnumber(accountnumber);

            if (list.size() > 0) {
                HttpSession session = request.getSession();
                session.setAttribute("loginUser", list.get(0));
                for (MemberBean mb : list) {
                    if (check.equals("資料正確")) {
                        model.addAttribute("LoginOK", mb);

                        return "redirect:memberselectall.controller";
                    } else {
                        return "login/login";
                    }
                }
            } else {
                return "login/login";
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "login/login";
    }

}
