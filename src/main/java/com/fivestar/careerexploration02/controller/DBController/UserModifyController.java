package com.fivestar.careerexploration02.controller.DBController;

import com.fivestar.careerexploration02.model.userModel.UserModifyModel;
import com.fivestar.careerexploration02.service.UserModifyService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class UserModifyController
{
    @Autowired
    UserModifyService userModifyService;  // 從UserModifyService拿方法過來

    Logger logger = LoggerFactory.getLogger(UserModifyController.class);  //SpringBoot除錯訊息註解


    @GetMapping("/Modify")
    public String modifyForm(HttpSession session, Model model, String accountnum, String passwd, String username, String email,
                             String mobile, String address, String landline, String paymentStatus, Date paymentDate)
    {
        UserModifyModel userModifyModel = new UserModifyModel();    //從ModifyModel實現取得所有會員資料

        //LoginController的登入後設定帳號於session屬性之中
        session.getAttribute("accountnum");
        logger.warn("執行後可以先看到會員帳號"+accountnum);   //SpringBoot除錯訊息註解
//        if (logInAcc)  //看session屬性
        {
            // 使用 loggedInAccountId 從資料庫中檢索該帳號的會員資料
            String loggedInAccountId = (String) session.getAttribute("accountnum");
            UserModifyModel showMemberAll = userModifyService.getMemberAll02(accountnum,passwd,username,email,mobile,address,landline,paymentStatus,paymentDate);

            //把會員資料裝進model傳給ModifyInfo頁面使用th:text
            model.addAttribute("showUsername", showMemberAll.getUsername());
            model.addAttribute("showAccountnum", showMemberAll.getAccountnum());
            model.addAttribute("showPasswd", showMemberAll.getPasswd());
            model.addAttribute("showAddress", showMemberAll.getAddress());
            model.addAttribute("showEmail", showMemberAll.getEmail());
            model.addAttribute("showMobile", showMemberAll.getMobile());
            model.addAttribute("showLandline", showMemberAll.getLandline());
            model.addAttribute("showPaymentStatus", showMemberAll.getPaymentStatus());
            model.addAttribute("showPaymentDate", showMemberAll.getPaymentDate());

            logger.warn("執行後可以先看到目前session狀態"+accountnum+","+passwd+","+address);
            return "/member/ModifyInfo";
        }
//        else   // 如果找不到該會員，可以重回到登入頁面
//        {
//            logger.warn("測試會員session失敗");
//            return "/member/login";
//        }
    }

//    @PostMapping("/Modify-success")    //做Modify的會員修改頁面
//    public String modifyUserData(@ModelAttribute UserModifyModel userModifyModel)
//    {
//        modifySer.updateMember(userModifyModel);
//        return "redirect:/member/Modify?memberid=" + userModifyModel.getMemberid();
//    }

    @GetMapping("/Member-Profile")    //測試ModifyInfo頁面正常
    public String ShowMemberAll(HttpSession session,Model model)
    {
        //已抓到session上的帳號
        model.addAttribute("showAccountnum",session.getAttribute("SetAccountNum"));
        model.addAttribute("showPasswd",session.getAttribute("SetPasswd"));
        model.addAttribute("showUsername",session.getAttribute("SetUserName123"));
        model.addAttribute("showEmail",session.getAttribute("SetEmail"));
        model.addAttribute("showMobile",session.getAttribute("SetMobile"));
        model.addAttribute("showAddress",session.getAttribute("SetAddress"));
        model.addAttribute("showLandline",session.getAttribute("SetLandline"));
        model.addAttribute("showPaymentStatus",session.getAttribute("SetpaymentStatus"));
        model.addAttribute("showPaymentDate",session.getAttribute("SetpaymentDate"));

        logger.warn("執行後可以先看到會員帳號"+session.getAttribute("SetAccountNum"));   //SpringBoot除錯訊息註解
        logger.warn("執行後可以先看到會員密碼"+session.getAttribute("SetPasswd"));
        logger.warn("執行後可以先看到會員名字"+session.getAttribute("SetUsername"));
        logger.warn("執行後可以先看到會員電子郵件"+session.getAttribute("SetEmail"));
        logger.warn("執行後可以先看到會員手機"+session.getAttribute("SetMobile"));
        logger.warn("執行後可以先看到會員地址"+session.getAttribute("SetAddress"));
        logger.warn("執行後可以先看到會員室話"+session.getAttribute("SetLandline"));
        logger.warn("執行後可以先看到會員付費狀態"+session.getAttribute("SetpaymentStatus"));
        logger.warn("執行後可以先看到會員付費日期"+session.getAttribute("SetpaymentDate"));
            //把已抓到session上的帳號放到model
            // 如果showMemberAll為null，可以設置一個默認值或者不設置，根據需求

            //把剩下會員資料裝進model傳給ModifyInfo頁面使用th:text
            return "/member/ModifyInfo";
//        }
//        catch (Exception e)
//        {
//            System.out.println(e);
//            return "/member/login";
//        }
    }

}
