package com.fivestar.careerexploration02.controller.DBController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController
{
    @Autowired
    private HttpServletRequest request;

    @GetMapping("/logout")      //登出功能
    public String logout(HttpSession session)
    {
        String referrer = request.getHeader("Referer"); // 獲取Referrer
        session.invalidate();  // 清除Session

        // 如果有Referrer，則重定向到Referrer；否則重定向到首頁
        return "redirect:" + (referrer != null ? referrer : "EnglishProject20240110");
    }
}
