package com.fivestar.careerexploration02.service;

import com.fivestar.careerexploration02.DAO_Repository.UserModifyDao;
import com.fivestar.careerexploration02.model.userModel.UserModifyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserModifyService
{
    @Autowired
    private UserModifyDao userModifyDao;

    public UserModifyModel getMemberById(Integer memberid)
    {
        return userModifyDao.getMemberById(memberid);   //回傳Id給Repository，做呈現會員資料
    }

    public void updateMember(UserModifyModel userModifyModel)
    {
        userModifyDao.updateMember(userModifyModel);    //回傳Id給Repository，做修改會員資料
    }
}
