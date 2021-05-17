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
@CacheConfig(cacheNames = "users")
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    @Cacheable(key = "#account")
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
    public List<User> findAll() {
        List<User> all = userMapper.findAll();
        return all;
    }

    @Override
    @CachePut(key = "#user_account")
    public Boolean updateRoleByAccount(String role, String user_account) {
        int i = userMapper.updateRoleByAccount(role, user_account);
        if(i>0){
            System.out.println("修改成功");
            return true;
        }else {
            System.out.println("修改失败");
            return false;
        }
    }

    @Override
    public Boolean addUser(User user) {
        User byAccount = userMapper.findByAccount(user.getUser_account());
        if (byAccount!=null){
            System.out.println("该账号已经被注册");
            return false;
        }else {
            User byAccount1 = userMapper.findByAccount(user.getUser_emile());
            if(byAccount1!=null){
                System.out.println("该邮箱已经被注册");
                return false;
            }else {
                userMapper.addUser(user);
                return true;
            }
        }

    }
}
