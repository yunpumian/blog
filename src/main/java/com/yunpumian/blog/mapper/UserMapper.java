package com.yunpumian.blog.mapper;


import com.yunpumian.blog.pojo.User;
import org.apache.ibatis.annotations.*;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 86152
 */
@SuppressWarnings("all")
@Repository
@Mapper
public interface UserMapper {
    /**
     * 通过账号，来返回User对象
     *
     * @param account
     * @return
     */
    @Select("select * from blog_user where user_account=#{param1} or user_emile=#{param1}  ")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "user_image", property = "user_img"),
            @Result(column = "user_account", property = "user_account"),
            @Result(column = "user_password", property = "user_password"),
            @Result(column = "user_othername", property = "user_othername"),
            @Result(column = "subscriptioned_number", property = "subscriptioned_number"),
            @Result(column = "subscription_number", property = "subscription_number"),
            @Result(column = "user_role", property = "user_role"),
            @Result(column = "user_blog_id", property = "user_blog_id"),
            @Result(column = "user_emile", property = "user_emile"),
            @Result(column = "user_motto", property = "user_motto")
    }
    )
    User findByAccount(@Param("user_account") String account);

    @Select("select * from blog_user where user_othername=#{param1} ")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "user_image", property = "user_img"),
            @Result(column = "user_account", property = "user_account"),
            @Result(column = "user_password", property = "user_password"),
            @Result(column = "user_othername", property = "user_othername"),
            @Result(column = "subscriptioned_number", property = "subscriptioned_number"),
            @Result(column = "subscription_number", property = "subscription_number"),
            @Result(column = "user_role", property = "user_role"),
            @Result(column = "user_blog_id", property = "user_blog_id"),
            @Result(column = "user_emile", property = "user_emile"),
            @Result(column = "user_motto", property = "user_motto")
    }
    )
    User findByOtherName(@Param("user_othername") String user_othername);

    @Insert("insert into blog_user value(#{user.user_image},#{user.user_account},${user.user_password},${user.user_othername},${user.subscriptioned_number},${user.subscription_number},${user.user_role},${user.user_blog_id},${user.user_emile},${user.user_motto})")
    Boolean addUser(@Param("user") User user);

    /**
     * @return
     */
    @Select("select * from blog_user")
    List<User> findAll();
    @Update("update blog_user set user_role=#{param1} where user_account=#{param2} ")
    int updateRoleByAccount(String role,String user_account);
    @Delete("delete from blog_user where user_account=#{param1} or user_emile=#{param1}")
    int deleteByAccount(String account);

}
