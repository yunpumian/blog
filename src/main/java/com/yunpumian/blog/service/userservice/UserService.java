package com.yunpumian.blog.service.userservice;

import com.yunpumian.blog.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author 86152
 */
public interface UserService {
    /**
     * @param account
     * @return
     */
    User selectUser(String account);

    /**
     * @param account
     */
    void updateByAccount(String account);

    /**
     * @param account
     */
    int deleteByAccount(String account);

    List<User> findAll();

    Boolean updateRoleByAccount(String role,String user_account);

}
