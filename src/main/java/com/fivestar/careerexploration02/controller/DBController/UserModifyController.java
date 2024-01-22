package com.fivestar.careerexploration02.controller.DBController;

import com.fivestar.careerexploration02.model.userModel.UserModifyModel;
import com.fivestar.careerexploration02.service.UserModifyService;
import jakarta.servlet.http.HttpServletRequest;
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
    private HttpServletRequest request;

    Logger logger = LoggerFactory.getLogger(UserModifyController.class);  //SpringBoot除錯訊息註解


    @GetMapping("/Modify")
    public String modifyForm(HttpServletRequest servletRequest, HttpSession session, Model model, String accountnum)
    {
        UserModifyModel userModifyModel = new UserModifyModel();    //從ModifyModel實現取得所有會員資料

        //LoginController的登入後設定帳號於session屬性之中，取得帳號
        session.getAttribute("SetAccountNum");
        HttpSession sessionGet = servletRequest.getSession();  //測試session並印出
        Boolean sessionBoolean = (Boolean) session.getAttribute("logInAcc");
        logger.warn("執行後可以先看到會員帳號+是否登入的布林值"+accountnum + sessionBoolean +sessionGet);   //SpringBoot除錯訊息註解

//        String referrer001 = request.getHeader("Referer");  // 獲取Referrer，用以回去來源頁面
//        session.setAttribute("whereComeFrom",referrer001);  // 設定Referrer在Session中

        if (sessionBoolean)   //看session屬性
        {
            // 使用 loggedInAccountId 從資料庫中檢索該帳號的會員資料
            String loggedInAccountId = (String) session.getAttribute("SetAccountNum");
            UserModifyModel showMemberAll = userModifyService.getAllByAccount03(loggedInAccountId);  //使用try catch的Service第二次方法
            logger.warn("執行後可在if看到會員帳號="+ loggedInAccountId);

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
            model.addAttribute("searchID", showMemberAll.getMemberid());
            return "member/ModifyInfo";
        }
        else   // 如果找不到該會員，可以重回到登入頁面，二重保護 if-else看session
        {
            logger.warn("測試會員session失敗");
            return "member/login";
        }
    }

//    @PostMapping("/Modify-success")    //會員修改頁面按下Confirm modify後觸發Post
//    public String modifyUserData(HttpSession session, String accountnum,
//                                 @RequestParam ("username") String username,
//                                 @RequestParam ("passwd") String passwd,
//                                 @RequestParam ("address") String address,
//                                 @RequestParam ("email")  String email,
//                                 @RequestParam ("mobile") String mobile,
//                                 @RequestParam ("landline") String landline)  //接收從input輸入的資料
//    {
//        // 使用 loggedInAccountId 改用帳號作為判斷的依據值
//        String loggedInAccountId = (String) session.getAttribute("SetAccountNum");  //取得於session屬性之帳號
//        logger.warn("執行後可在POST看到會員帳號="+ loggedInAccountId);
//
//        try
//        {
////          UserModifyModel userModifyModel = new UserModifyModel();  // 創建一個 UserModifyModel 對象，並設置表單數據
//            UserModifyModel updateProfile = userModifyService.updateMember02(loggedInAccountId);  //往modifyService送
//            updateProfile.setUsername(username);
//            updateProfile.setPasswd(passwd);
//            updateProfile.setAddress(address);
//            updateProfile.setEmail(email);
//            updateProfile.setMobile(mobile);
//            updateProfile.setLandline(landline);
//            updateProfile.setAccountnum(loggedInAccountId);
//            return "member/ModifyInfo" ;
//        }
//        catch (Exception e)
//        {
//            System.out.println(e);
//        }
//        return "member/ModifyInfo" ;
//    }
@PostMapping("/Modify-success")
public String modifyUserData(HttpSession session, Model model, @ModelAttribute UserModifyModel request)
{
    UserModifyModel userModifyModel =new UserModifyModel();
    String loggedInAccountId = (String) session.getAttribute("SetAccountNum");
    UserModifyModel updateProfile = userModifyService.updateMember03(loggedInAccountId);

    try {
        updateProfile.setUsername(request.getUsername());
        updateProfile.setPasswd(request.getPasswd());
        updateProfile.setAddress(request.getAddress());
        updateProfile.setEmail(request.getEmail());
        updateProfile.setMobile(request.getMobile());
        updateProfile.setLandline(request.getLandline());

        userModifyService.updateMember03(accountnum);
        return "member/ModifyInfo";
    }
    catch (Exception e)
    {
        System.out.println(e);
    }

    return "member/ModifyInfo";
}


}
