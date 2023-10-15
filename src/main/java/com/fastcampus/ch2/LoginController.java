package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController {

//    @RequestMapping("/login/login")
    @GetMapping("/login")
    public String login() {
        return "login";
    }


//    @RequestMapping(value = "/login/login",  method = RequestMethod.POST)
    @PostMapping("/login")
    public String login(String id, String pwd) {
        // 1. id, pwd를 확인
        if(loginCheck(id, pwd)) {
            // 2. 일치하면, userInfo.html
            return "userInfo";
        } else {
            // 일치하지 않으면, login.html로 이동
            return "redirect:/login/login";
        }


    }

    private boolean loginCheck(String id, String pwd) {
        return id.equals("asdf") && pwd.equals("1234");
    }


}
