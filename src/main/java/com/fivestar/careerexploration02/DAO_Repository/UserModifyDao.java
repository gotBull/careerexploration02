package com.fivestar.careerexploration02.DAO_Repository;

import com.fivestar.careerexploration02.DAO_Repository.Mapper.UserModifyMapper;
import com.fivestar.careerexploration02.controller.DBController.LoginController;
import com.fivestar.careerexploration02.model.userModel.UserModifyModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class UserModifyDao
{

    @Autowired
    JdbcTemplate jdbcTemplate;

    Logger logger = LoggerFactory.getLogger(UserModifyDao.class);  //SpringBoot除錯訊息註解

    // 可讀取會員自己所有資料的邏輯
    public UserModifyModel getMemberAll01(String accountnum, String passwd, String username, String email, String mobile, String address, String landline, String paymentStatus, Date paymentDate)
    {
        UserModifyMapper userModifyMapper=new UserModifyMapper();

        List<UserModifyModel> allMemberArray= jdbcTemplate.query(
                "SELECT * from userdata where accountnum = ?",
                userModifyMapper, accountnum, passwd, username, email,
                mobile, address, landline, paymentStatus, paymentDate);

        return allMemberArray.isEmpty() ? null : allMemberArray.get(0);
    }

    //第二次測試考慮只以帳號當參數送進來
    public UserModifyModel getMemberAll02(String accountnum)
    {
        UserModifyMapper userModifyMapper=new UserModifyMapper();

        List<UserModifyModel> allMemberArray= jdbcTemplate.query(
                "SELECT * from userdata where accountnum = ?",
                userModifyMapper, accountnum);

        if (allMemberArray.isEmpty())
        {
            logger.warn("此DAO執行後會員資料 沒 被找到");
        }
        else
        {
            logger.warn("此DAO執行後會員資料 有 被找到");
        }
        return allMemberArray.isEmpty() ? null : allMemberArray.get(0);
    }


    // 更新會員資料的邏輯
    public void updateMember(UserModifyModel userModifyModel)
    {
        String sql02= "UPDATE userdata SET accountnum=?, passwd=?, username=?, email=?, mobile=?, address=?, landline=? WHERE memberid=?";
        jdbcTemplate.update(sql02,
                userModifyModel.getAccountnum(),
                userModifyModel.getPasswd(),
                userModifyModel.getUsername(),
                userModifyModel.getEmail(),
                userModifyModel.getMobile(),
                userModifyModel.getAddress(),
                userModifyModel.getLandline());
    }
}
