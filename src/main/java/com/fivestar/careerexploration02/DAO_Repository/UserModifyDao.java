package com.fivestar.careerexploration02.DAO_Repository;

import com.fivestar.careerexploration02.DAO_Repository.Mapper.UserModifyMapper;
import com.fivestar.careerexploration02.model.userModel.UserModifyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserModifyDao
{

    @Autowired
    JdbcTemplate jdbcTemplate;

    public UserModifyModel getMemberById(Integer memberid)  // 讀取會員資料的邏輯
    {
        String sql01= "SELECT memberid,accountnum,passwd,username,email,mobile,address,landline from userdata where memberid=?";
        return jdbcTemplate.queryForObject(sql01, new Object[]{memberid}, new UserModifyMapper());
    }

    public void updateMember(UserModifyModel userModifyModel)// 更新會員資料的邏輯
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
