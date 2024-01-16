package com.fivestar.careerexploration02.service;
import com.fivestar.careerexploration02.DAO_Repository.UserLoginDao;
import com.fivestar.careerexploration02.model.userModel.UserLogModel02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService
{
    @Autowired
    UserLoginDao userLoginDao;

    public boolean loginTest(UserLogModel02 member01)
    {
        UserLogModel02 memberFromDb = userLoginDao.getAccPassWd(member01.getAccountnum(),member01.getPasswd());

        // 如果資料庫中找不到會員帳號和密碼均符合，則回傳false
        if (memberFromDb == null || !memberFromDb.getPasswd().equals(member01.getPasswd()))
        {
            return false;
        }
        // 若會員帳號和密碼均符合，則回傳true
        return true;
    }

    public UserLogModel02 transUserName(String accountnum)  //做一個登入時可同步顯示使用者名稱或其他資料
    {
        return userLoginDao.getUserNameAtDao(accountnum);
    }

    public UserLogModel02 transMemberID(Integer memberid)  //做一個登入時可記載會員ID
    {
        return userLoginDao.getUserIdAtDao(memberid);
    }

}
