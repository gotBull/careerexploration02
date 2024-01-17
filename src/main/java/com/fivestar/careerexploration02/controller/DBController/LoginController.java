package com.fivestar.careerexploration02.controller.DBController;

import com.fivestar.careerexploration02.model.userModel.UserLogModel02;
import com.fivestar.careerexploration02.model.userModel.UserModifyModel;
import com.fivestar.careerexploration02.service.UserLoginService;
import com.fivestar.careerexploration02.service.UserModifyService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller

public class LoginController
{
    @Autowired
    UserLoginService userLoginService;
    UserModifyService userModifyService;

    private HttpServletRequest request;

    Logger logger = LoggerFactory.getLogger(LoginController.class);  //SpringBoot除錯訊息註解

    @GetMapping("/login")   //GET進入登入頁面
    public String loginPage( /* HttpServletRequest request */)
    {
//        UserLogModel02 loggedUser = new UserLogModel02(); //防止重複登入功能(改用th:if)
//        boolean loginResult = userLoginService.loginTest(loggedUser);
//        if (loginResult != false)
//        {
//            String referrer = request.getHeader("Referer"); // 獲取Referrer
//            // 如果有Referrer，則重定向到Referrer；否則重定向到首頁
//            return "redirect:" + referrer;
//        }
//        else
//        {
            return "/member/login";
//        }
    }

    @PostMapping("/login")  //POST登入頁面中按下submit觸發
    public String loginsussPage(@RequestParam("accountnum") String accountnum,
                                @RequestParam("passwd") String passwd,
                                HttpSession session, Model model,
                                HttpServletRequest request01,
                                String username, String email,
                                String mobile, String address,
                                String landline, String paymentStatus, Date paymentDate)
    {
        UserLogModel02 model01 = new UserLogModel02();
        UserLogModel02 showUserName = userLoginService.transUserName(accountnum);   //從DAO簡單寫從帳號對應的使用者名稱，給Service傳

        model01.setAccountnum(accountnum);
        model01.setPasswd(passwd);
        model01.setUsername(username);
        model01.setEmail(email);
        model01.setMobile(mobile);
        model01.setAddress(address);
        model01.setLandline(landline);
        model01.setPaymentStatus(paymentStatus);
        model01.setPaymentDate(paymentDate);

        boolean loginResult = userLoginService.loginTest(model01);
        if(loginResult)
        {
            session.setAttribute("logInAcc",true);  // 登入成功，設定session屬性是true

            session.setAttribute("SetAccountNum", accountnum); // 儲存帳號設定在session
            session.setAttribute("SetPasswd", passwd);  // 儲存密碼設定在session
            session.setAttribute("SetUserName123", username);
            session.setAttribute("SetEmail", email);
            session.setAttribute("SetMobile", mobile);
            session.setAttribute("SetAddress",address);
            session.setAttribute("SetLandline",landline);
            session.setAttribute("SetpaymentStatus",paymentStatus);
            session.setAttribute("SetpaymentDate",paymentDate);

            model.addAttribute("logSuess","Logged in success!");
            model.addAttribute("showUserName", showUserName.getUsername()); //先判別帳密一致後，印出與帳號對應的使用者名稱
            logger.warn("Login執行後可以看到帳號內容"+accountnum);   //SpringBoot除錯訊息註解

            String referrer = request01.getHeader("Referer"); // 獲取Referrer
            session.setAttribute("comeFrom", request01.getHeader("Referer"));
//            return "redirect:" + session.getAttribute("comeFrom");  // 如果有Referrer，則重定向到Referrer；否則重定向到首頁
            return "/member/login";
        }
        else
        {
            //帳號或密碼輸入錯誤，三秒後返回登入頁面
            model.addAttribute("logFail","Incorrect username or password. " +
                    "Returning to the login page in three seconds.");
            return "/member/loginFail";
        }
    }

    @GetMapping("/restricted-api")   //沒有登入與否，做出顯示訊息的測試API
    @ResponseBody
    public String restrictedApi(HttpSession session)
    {
        // 檢查是否有登入
        if (session.getAttribute("logInAcc") == null)
        {
            return "You are not logged in. Access denied.";
        }
        // 如果已經登入，顯示此句話 + session 中的 Account
        else
        {
            return "This is a restricted API endpoint. You have access!"
                    + session.getAttribute("accountnum")+ session.getAttribute("comeFrom");
        }
    }
}
