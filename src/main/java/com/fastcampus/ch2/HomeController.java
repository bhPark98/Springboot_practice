package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String main() {

        return "index";
    }

    @GetMapping("/test")
    public String test(Model model, HttpServletRequest request) {
        request.setAttribute("year", 2022); // request 객체에 저장

        HttpSession session = request.getSession(); // 요청으로 부터 session객체를 얻어온다.
        session.setAttribute("id", "asdf"); // session 객체에 id를 저장

        ServletContext application = session.getServletContext();
        application.setAttribute("email", "");

        model.addAttribute("lastName", "beongho");
        model.addAttribute("firstName", "Park");
        model.addAttribute("list", Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee"));
        model.addAttribute("bno", 123);
        model.addAttribute("user", new User("aaa", 20));

        return "test";
    }
}
