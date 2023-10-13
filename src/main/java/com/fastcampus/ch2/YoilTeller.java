package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Calendar;

@Controller
public class YoilTeller {
    @RequestMapping("/getYoil")
    public String main(@ModelAttribute MyDate myDate, Model model) throws Exception {
        // 1. 입력
//        String year = request.getParameter("year");
//        String month = request.getParameter("month");
//        String day = request.getParameter("day");

//        int yyyy = Integer.parseInt(year);
//        int mm = Integer.parseInt(month);
//        int dd = Integer.parseInt(day);

        //2 . 작업 - 요일을 계산

//        char yoil = getYoil(myDate);


        return "yoil";
//        response.setCharacterEncoding("ms949");
//        PrintWriter out = response.getWriter();
//
//        out.println("<html>");
//        out.println("<head>");
//        out.println("</head>");
//        out.println("<body>");
//        out.println("year = " + year);
//        out.println("month = " + month);
//        out.println("day = " + day);
//        out.println("yoil = " + yoil);
//        out.println("</body>");
//        out.println("</html>");

    }

    private static @ModelAttribute("yoil") char getYoil(MyDate myDate) {
        Calendar cal = Calendar.getInstance(); // 현재 날짜와 시간을 갖는 cal
        cal.clear(); // cal의 모든 필드를 초기화
        cal.set(myDate.getYear(), myDate.getMonth() -1, myDate.getDay()); //월은 0부터 11이기때문에 1을 빼줘야함

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1~7을 반환. 1: 일요일, 2.월요일
        char yoil = "일월화수목금토".charAt(dayOfWeek-1); //1~7 -> 0~6
        return yoil;
    }


}
