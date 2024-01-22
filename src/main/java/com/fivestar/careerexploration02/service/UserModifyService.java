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
            return userModifyDao.getMemberAll02(accountnum);
        }
        catch (Exception e)
        {
            System.out.println(e);
            return null;
        }
    }

    //回傳給Repository，找出session中帳號做呈現會員資料，測試第二次
    public UserModifyModel getAllByAccount03(String accountnum)
    {
        try
        {
            return userModifyDao.getMemberAll02(accountnum);
        }
        catch (Exception e)
        {
            System.out.println(e);
            return null;
        }
    }

    //回傳給Repository，找出session中帳號做呈現會員資料，測試第三次
    public UserModifyModel getAllByAccount04(String accountnum)
    {
        return userModifyDao.getMemberAll02(accountnum);
    }



    //回傳Id給Repository，做修改會員資料
    public void updateMember(UserModifyModel userModifyModel)
    {
        userModifyDao.updateMember(userModifyModel);
    }

    public void updateMember03(String accountnum)
    {
        userModifyDao.updateMember02(accountnum);
    }
//
//    //回傳Id給Repository，做修改會員資料02
//    public UserModifyModel updateMember02(String accountnum, String username, String passwd, String address, String email, String mobile, String landline)
//    {
//        userModifyDao.updateMember02(username,passwd,address,email,mobile,landline,accountnum);
//        return null;
//    }
//
//    public UserModifyModel updateMember02(String loggedInAccountId)
//    {
//        return null;
//    }
}
