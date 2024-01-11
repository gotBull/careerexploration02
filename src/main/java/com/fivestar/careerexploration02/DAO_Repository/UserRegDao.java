package com.fivestar.careerexploration02.DAO_Repository;


import com.fivestar.careerexploration02.model.userModel.UserRegModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository  //repository 專門資料庫的存取、處理，倉儲物件
public class UserRegDao
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //進行存檔 Insert into 進資料表
    public int saveUserForm(UserRegModel userRegForm)
    {
        String sql01 = "insert into userdata(accountnum,passwd,username,email,mobile) values (?,?,?,?,?)";
        return jdbcTemplate.update(sql01, userRegForm.getAccountnum(), userRegForm.getPasswd(), userRegForm.getUsername(), userRegForm.getEmail(), userRegForm.getMobile());  //update新增(sql語法物件,資料表.Model方法)
    }

    //檢查帳號是否存在
    public long testUserExist(String accountnum)
    {
        String sql02 = "select count(*) from userdata where accountnum=?";
        // select count(*) 回傳一慮使用 long 型別
        return jdbcTemplate.queryForObject(sql02,Long.class, accountnum);
    }

    //檢查帳號是否有禁用字
    public long testAccountBannedWord(String accountnum)
    {
        String sql03 = "select * from userdata where accountnum=?";
        return jdbcTemplate.queryForObject(sql03,Long.class, accountnum);
    }

    //檢查密碼是否有禁用字
    public long testPasswordBannedWord(String passwd)
    {
        String sql04 = "select * from userdata where passwd=?";
        return jdbcTemplate.queryForObject(sql04,Long.class, passwd);
    }
}
