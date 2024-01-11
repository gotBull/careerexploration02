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
public class UserLogModel02
{
    private int memberid;
    private String accountnum;
    private String passwd;
    private String username;
    private String email;
    private String mobile;
    private Date regdate;
}
