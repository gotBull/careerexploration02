package com.fivestar.careerexploration02.controller.DBController;

import com.fivestar.careerexploration02.service.ForgotPasswordService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class ForgetPasswdController
{
    @Autowired
    ForgotPasswordService forgotPasswordService;

    Logger logger = LoggerFactory.getLogger(ForgetPasswdController.class);  //SpringBoot除錯訊息註解

    @GetMapping("/forget_password")
    public String ForgetPasswd()
    {
        return "member/ForgetPasswd";
    }

    @PostMapping("/forgot-password")  //讀取在忘記密碼中輸入的帳號
    public String processForgotPassword(@RequestParam("accountnum") String accountnum, Model model)
    {
//        try {
            // 根據帳號從資料庫中獲取電子郵件
        String email = forgotPasswordService.getEmailByAccount(accountnum);
            if (email != null)
            {
//                forgotPasswordService.AccOnlyOneAndSaveCode(accountnum);
                // 發送包含隨機碼的郵件
                //sendEmail(email, randomCode);
                model.addAttribute("email",email);

                // 生成隨機碼
                String randomCode01 = generateRandomCode();
                // 存儲忘記密碼信息到資料庫

                model.addAttribute("RandomCode", randomCode01);

                return "member/ForgetPasswd";
            }
            else
            {
                // 帳號不存在，請重新註冊
                return "member/Register2";
            }
//        } catch (Exception e) {
//            // 處理異常情況
//            return "redirect:/forgot-password?error=unknownError";
//        }
    }




    private String generateRandomCode()
    {
        // 生成6位數的隨機碼（示例）
        Random random = new Random();
        int randomInt = 100000 + random.nextInt(900000);
        return String.valueOf(randomInt);
    }

//    private void sendEmail(String email, String randomCode) {
//        // 實現郵件發送的邏輯，可以使用JavaMail或其他郵件發送庫
//        // 在這裡，我們只是簡單地輸出到控制台
//        System.out.println("Sending email to " + email + " with random code: " + randomCode);
//    }
}

