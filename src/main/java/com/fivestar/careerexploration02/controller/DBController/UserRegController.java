package com.fivestar.careerexploration02.controller.DBController;

import com.fivestar.careerexploration02.model.userModel.UserRegModel;
import com.fivestar.careerexploration02.service.UserRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserRegController
{
    @Autowired
    UserRegService userRegService;

    @GetMapping("/user_register")
    public String regpage(Model model)
    {
        UserRegModel userRegModel = new UserRegModel();
        model.addAttribute("userRegForm",userRegModel);
        return "/member/Register2";
    }

    //@PostMapping+ binding讓使用者把Form送進model裡傳，使用@ModelAttribute+ th:object="${ }"+ th:field="*{ }"
    @PostMapping("/user_register")
    public String UserRegProcess2(@ModelAttribute UserRegModel userRegModel, Model model)
    {
        String msg = null;
        // 使用者送 request 進來後 回傳 註冊表單名稱
        // 呼叫 service 開始進行新增
        int result = userRegService.Registration(userRegModel);
        switch (result)
        {
            case 0:     //註冊失敗
                msg = "Registration failed";
                break;
            case 1:     //成功註冊
                msg = "You have successfully registered. Welcome to login,";
                model.addAttribute("userName",userRegModel.getUsername());
                break;
            case 2:     //已經有相同帳號註冊過
                msg = "Your account has already been registered in this system. Please use the login function";
                break;
            case 3:     //帳號禁止禁用字
                msg = "Account cannot contain prohibited system keywords";
                break;
            default:    //其他系統原因
                msg = "For other system-related reasons, please contact the site administrators";
                break;
        }
        // 結果通知
        model.addAttribute("msg",msg);
        return "/member/signin";
    }


}
