package com.yunpumian.blog.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;

/**
 * @author :wn
 * @program : blog
 * @descript : 获取账户类
 * @create :2021-05-16 18:15
 */
@Component
public class AccountUtils {
    public String getAccount(){
        StringBuffer account=new StringBuffer();
        for(int j=0;j<9;j++){
            Random random1 = new Random();
            int i1 = random1.nextInt(9);
            account.append(i1);
        }
        return account.toString();


    }
}
