package com.fivestar.careerexploration02.DAO_Repository;

import com.fivestar.careerexploration02.model.userModel.UserModifyModel;
import com.fivestar.careerexploration02.model.userModel.UserRegModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ForgotPasswordDao
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //檢查帳號是否存在
    public long testUserExist02(String accountnum)
    {
        //count(*)= 1 ， 代表帳號存在  ；  count(*)=0  ， 代表帳號不存在
        String sql01 = "select count(*) from userdata where accountnum=?";
        // select count(*) 回傳一慮使用 long 型別
        return jdbcTemplate.queryForObject(sql01,Long.class, accountnum);
    }

    //從帳號讀出DB的Email
    public String searchUserEmail(String accountnum)
    {
        String sql03 = "select email from userdata where accountnum=?";
        return jdbcTemplate.queryForObject(sql03,String.class, accountnum);  //使用 accountnum 的值作為參數傳遞給 SQL 查詢中的 ?
    }

    //進行存檔 Insert into 進資料表
    public int saveRandomCode(UserModifyModel saveRandom)
    {
        String sql02 = "insert into userdata(randomCode) values (?)";
        return jdbcTemplate.update(sql02, saveRandom.getRandomCode());  //update新增(sql語法物件,資料表.Model方法)
    }
}
