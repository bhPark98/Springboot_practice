package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.URLEncoder;


@Controller
@RequestMapping("/login")
public class LoginController {
    @RequestMapping("/login")
    public String showLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request, String id, String pwd, RedirectAttributes model) throws Exception {
        //1. id, pwd를 확인
        if(loginCheck(id, pwd)) {
            //2. 일치하면, userInfo.html
            model.addAttribute("id", id);
            model.addAttribute("pwd", pwd);

            return "userInfo";
        } else {
            //3. 일치하지 않으면, login.html로 이동
            String msg = "id 또는 pwd가 일치하지 않습니다.";
            model.addAttribute("msg", msg);
            model.addFlashAttribute("msg", "일회용 메시지");
            request.setAttribute("msg", "request에 저장된 msg");

            return "redirect:/";
//            return "redirect:/login/login?msg="+msg;
        }


    }

    private boolean loginCheck(String id, String pwd) {
        return id.equals("asdf") && pwd.equals("1234");
    }

}
