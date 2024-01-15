package com.fivestar.careerexploration02.model.userModel;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserModifyModel
{
    private int memberid;
    private String accountnum;
    private String passwd;
    private String username;
    private String email;
    private String mobile;
    private String address;
    private String landline;
}
