package com.fivestar.careerexploration02.DAO_Repository.Mapper;

import com.fivestar.careerexploration02.model.userModel.UserLogModel02;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class UserLoginMapper implements RowMapper<UserLogModel02> //把DB會員資料裝進陣列口袋
{
    @Override
    public UserLogModel02 mapRow(ResultSet rs, int rowNum) throws SQLException
    {
       UserLogModel02 uLModel = new UserLogModel02();
       uLModel.setMemberid(rs.getInt("memberid"));
       uLModel.setAccountnum(rs.getNString("accountnum"));
       uLModel.setPasswd(rs.getNString("passwd"));
       uLModel.setUsername(rs.getNString("username"));
       uLModel.setEmail(rs.getNString("email"));
       uLModel.setMobile(rs.getNString("mobile"));
       uLModel.setRegdate(rs.getDate("regdate"));
       return uLModel;
    }
}
