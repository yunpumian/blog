package com.yunpumian.blog.service;

import com.yunpumian.blog.mapper.UserMapper;
import com.yunpumian.blog.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author :wn
 * @program : blog
 * @descript :
 * @create :2021-03-19 14:32
 */
@Service("securityService")
public class SecurityService implements UserDetailsService {
    @Resource
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User byAccount = userMapper.findByAccount(s);
        System.out.println("加载user");

        if (byAccount == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        return byAccount;

    }
}
