package com.fivestar.careerexploration02.service;

import com.fivestar.careerexploration02.DAO_Repository.UserModifyDao;
import com.fivestar.careerexploration02.model.userModel.UserModifyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserModifyService
{
    @Autowired
    private UserModifyDao userModifyDao;

    //回傳給Repository，找出session中帳號做呈現會員資料
    public UserModifyModel getMemberAll02(String accountnum, String passwd, String username, String email, String mobile, String address, String landline, String paymentStatus, Date paymentDate)
    {
        try
        {
            return userModifyDao.getMemberAll01(accountnum,passwd,username,email,mobile,address,landline,paymentStatus,paymentDate);
        }
        catch (Exception e)
        {
            System.out.println(e);
            return null;
        }
    }

    //回傳Id給Repository，做修改會員資料
    public void updateMember(UserModifyModel userModifyModel)
    {
        userModifyDao.updateMember(userModifyModel);
    }

}
