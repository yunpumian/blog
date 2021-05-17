package com.yunpumian.blog.service.userservice;

import com.yunpumian.blog.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author 86152
 */
public interface UserService {
   /**
    *@Description: 根据账号查询
    *@Param: [account] 
    *@return: com.yunpumian.blog.pojo.User
    *@date: 2021/5/16
   **/
   
    User selectUser(String account);

   /**
    *@Description: 根据账号修改
    *@Param: [account] 
    *@return: void
    *@date: 2021/5/16
   **/
   
    void updateByAccount(String account);

    /**
     *@Description: 根据账号删除用户
     *@Param: [account] 
     *@return: int
     *@date: 2021/5/16
    **/
    
    int deleteByAccount(String account);
    /**
     *@Description: 查询所有用户
     *@Param: [] 
     *@return: java.util.List<com.yunpumian.blog.pojo.User>
     *@date: 2021/5/16
    **/
    
    List<User> findAll();
    /**
     *@Description:通过账号修改用户角色
     *@Param: [role, user_account] 
     *@return: java.lang.Boolean
     *@date: 2021/5/16
    **/
    

    Boolean updateRoleByAccount(String role,String user_account);
    /**
     *@Description: 添加用户
     *@Param: [user] 
     *@return: java.lang.Boolean
     *@date: 2021/5/16
    **/
    
    Boolean addUser(User user);

}
