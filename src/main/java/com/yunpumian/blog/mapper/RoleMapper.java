package com.yunpumian.blog.mapper;

import com.yunpumian.blog.pojo.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * @author 86152
 */
@SuppressWarnings("all")
@Repository
@Mapper
public interface RoleMapper {
    /**
     * @param description
     * @return
     */
    @Select("select * from blog_user_role where description=#{param1}")
    @Results(
            {
                    @Result(column = "id", property = "id"),
                    @Result(column = "role", property = "role"),
                    @Result(column = "description", property = "description")
            }
    )
    Role findByDescription(@Param("description") String description);
}
