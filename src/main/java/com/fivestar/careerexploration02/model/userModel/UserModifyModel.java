package com.fivestar.careerexploration02.model.userModel;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserModifyModel
{
    private int memberid;            //會員ID
    private String accountnum;       //帳號
    private String passwd;           //密碼
    private String username;         //會員名字
    private String email;            //電子郵件
    private String mobile;           //手機
    private String address;          //地址
    private String landline;         //室內電話
    private String paymentStatus;    //會員付費等級
    private Date paymentDate;        //會員付費時間
    private String randomCode;       //忘記密碼的暫存隨機碼
}
