package com.fivestar.careerexploration02.service;

import com.fivestar.careerexploration02.DAO_Repository.UserRegDao;
import com.fivestar.careerexploration02.model.userModel.UserRegModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//先使用老師的Service
@Service
public class UserRegService
{
    @Autowired
    UserRegDao userRegDao;

    public int Registration(UserRegModel userModel)
    {
        // 收到註冊需求  先檢查帳號是否存在
        // 1:成功 , 2: 帳號已經存在
        if(isUserExists(userModel.getAccountnum()))  // 帳號已經存在，退註冊申請
        {
            return 2;
        }
        // 不存在  開始檢查資料是否合規  // 過濾 惡意字詞 可能異常字串(select , inser, update, delete 等)
        if(isBannedWord(userModel.getAccountnum()))
        {
            return 3;
        }
        // 開始進行 帳號新增作業
        int cnt = userRegDao.saveUserForm(userModel);
        if(cnt > 0 )
        {
            return 1;
        }
        else
        {
            return cnt;
        }
    }

    // 先把確認帳號是否存在的功能可以分享獨立寫成一個公用方法, 改密碼也需要檢查是否有此帳號
    public boolean isUserExists(String accountnum)
    {
        long count = userRegDao.testUserExist(accountnum);
        if( count > 0)
        {
            return true;    /* 資料庫中有相同帳號 */
        }
        else
        {
            return false;   /* 資料庫中沒有相同帳號 */
        }
    }

    //做一個禁用字列表的獨立公用方法
    public List<String> BanWordValidator()
    {
        List<String> bannedWord = new ArrayList<>();
        bannedWord.add("select");
        bannedWord.add("insert");
        bannedWord.add("update");
        bannedWord.add("delete");
        bannedWord.add("drop");
        bannedWord.add("alter");
        bannedWord.add("create");
        bannedWord.add("truncate");
        bannedWord.add("grant");
        bannedWord.add("revoke");
        return bannedWord;
    }
   //從禁用字列表抓取來判斷userInput
   public boolean isBannedWord(String username)
   {
       List<String> bannedWord = BanWordValidator();
       return bannedWord.contains(username.toLowerCase()); // 檢查是否包含禁用字
   }
}