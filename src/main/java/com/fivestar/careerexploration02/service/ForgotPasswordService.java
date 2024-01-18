package com.fivestar.careerexploration02.service;

import com.fivestar.careerexploration02.DAO_Repository.ForgotPasswordDao;
import com.fivestar.careerexploration02.model.userModel.UserModifyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ForgotPasswordService
{
    @Autowired
    ForgotPasswordDao forgotPasswordDao;
    UserRegService userRegService;

    public int AccOnlyOneAndSaveCode(UserModifyModel userModifyModel)
    {
        int setRandomCode= forgotPasswordDao.saveRandomCode(userModifyModel);

        if(userRegService.isUserExists(userModifyModel.getAccountnum()))  //從公用方法抓"確認帳號是否存在"功能
        {
            return setRandomCode;  // 帳號已經存在，存入該帳號的隨機碼
        }
        else
        {
            return 0;  // 帳號不存在，請重新輸入或註冊
        }
    }

//    public void saveForgotPasswordInfo(String randomCode)
//    {
//        // 存儲忘記密碼信息到資料庫
//        ForgotPasswordDao forgotPasswordInfo = new ForgotPasswordDao();
//        String saveCode=forgotPasswordInfo.saveRandomCode(randomCode);
//        return saveCode;
//    }

    // 帳號已經存在，找出存在的E-mail
    public String getEmailByAccount(String accountnum)
    {
        return forgotPasswordDao.searchUserEmail(accountnum);
    }

}
