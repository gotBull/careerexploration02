package com.fivestar.careerexploration02.controller.DBController;

import com.fivestar.careerexploration02.model.userModel.UserModifyModel;
import com.fivestar.careerexploration02.service.UserModifyService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class UserModiifyController
{
    @Autowired
    private UserModifyService modifySer;

    @GetMapping("/Modify")
    public String modifyForm( /*@RequestParam("memberid") */ Integer memberid,HttpSession session, Model model)
    {
//        UserModifyModel userModifyModel= new UserModifyModel();
//        userModifyModel.setMemberid(memberid);
//        UserModifyModel showUserData = modifySer.getMemberById(memberid);
//        memberid = (Integer) session.getAttribute("memberid");   // 從 Session 中獲取 memberid
//
//        System.out.println(memberid);  //Test
//
//        if (memberid != null)
//        {
//            model.addAttribute("userModifyModel", userModifyModel);
//            System.out.println("測試會員session成功"+memberid);
            return "/member/ModifyInfo";
//        }
//        else
//        {
//            System.out.println("測試會員session失敗");
//            return "/member/login";
//            // 如果找不到該會員，可以重定向到登入頁面
//        }
    }

    @PostMapping("/Modify-success")
    public String modifyUserData(@ModelAttribute UserModifyModel userModifyModel)
    {
        modifySer.updateMember(userModifyModel);
        return "redirect:/member/Modify?memberid=" + userModifyModel.getMemberid();
    }

}
