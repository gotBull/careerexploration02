package com.fivestar.careerexploration02.DAO_Repository.Mapper;

import com.fivestar.careerexploration02.model.userModel.UserModifyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModifyMapper implements RowMapper<UserModifyModel>  //把DB會員資料裝進陣列口袋
{
    @Override
    public UserModifyModel mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        UserModifyModel userModifyModel= new UserModifyModel();
        userModifyModel.setMemberid(rs.getInt("memberid"));
        userModifyModel.setAccountnum(rs.getNString("accountnum"));
        userModifyModel.setPasswd(rs.getNString("passwd"));
        userModifyModel.setUsername(rs.getNString("username"));
        userModifyModel.setEmail(rs.getNString("email"));
        userModifyModel.setMobile(rs.getNString("mobile"));
        userModifyModel.setAddress(rs.getNString("address"));
        userModifyModel.setLandline(rs.getNString("landline"));
        userModifyModel.setPaymentStatus(rs.getNString("paymentStatus")); //把付費時改變先放在這邊
        userModifyModel.setPaymentDate(rs.getDate("paymentDate"));
        userModifyModel.setRandomCode(rs.getNString("randomCode"));
        return userModifyModel;
    }
}
