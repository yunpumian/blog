package com.yunpumian.blog.service.userservice;

import com.yunpumian.blog.mapper.UserMapper;
import com.yunpumian.blog.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author :wn
 * @program : blog
 * @descript :
 * @create :2021-04-09 17:33
 */
@Service
@CacheConfig(cacheNames = "userService")
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public User selectUser(String account) {
        User byAccount = userMapper.findByAccount(account);
        return byAccount;
    }

    @Override
    public void updateByAccount(String account) {


    }

    @Override
    public int deleteByAccount(String account) {
        return userMapper.deleteByAccount(account);

    }

    @Override
    @Cacheable(value = "userList", keyGenerator = "keyGenerator")
    public List<User> findAll() {
        List<User> all = userMapper.findAll();
        return all;
    }
    @CacheEvict(value = "userList", keyGenerator = "keyGenerator")
    @Override
    public Boolean updateRoleByAccount(String role, String user_account) {
        int i = userMapper.updateRoleByAccount(role, user_account);
        if(i>0){
            return true;
        }else {
            return false;
        }
    }
}
