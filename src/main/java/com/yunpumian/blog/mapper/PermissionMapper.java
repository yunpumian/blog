package com.yunpumian.blog.mapper;

import com.yunpumian.blog.pojo.Permission;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * @author :wn
 * @program : blog
 * @descript : 权限接口
 * @create :2021-03-20 15:06
 */
@SuppressWarnings("all")
@Repository
@Mapper
public interface PermissionMapper {
    /**
     * @param role
     * @return
     */
    @Select("select * from blog_user_permission where role=#{param1} ")
    @Results(
            {
                    @Result(column = "id", property = "id"),
                    @Result(column = "role", property = "role"),
                    @Result(column = "url", property = "url")

            }
    )
    Permission findPermissionByRole(@Param("role") String role);
}
