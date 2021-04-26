package com.yunpumian.blog.mapper;

import com.yunpumian.blog.pojo.Blog;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author :wn
 * @program : blog
 * @descript :
 * @create :2021-03-23 15:24
 */
@Repository
@Mapper
@SuppressWarnings("all")
public interface BlogMapper {
    /**
     * @param blog_type
     * @return
     */
    @Select("select * from blog where blog_type=#{param1}")
    @Results(
            {
                    @Result(column = "id", property = "id"),
                    @Result(column = "blog_account", property = "blog_account"),
                    @Result(column = "blog_type", property = "blog_type"),
                    @Result(column = "user_account", property = "user_account"),
                    @Result(column = "blog_img", property = "blog_img"),
                    @Result(column = "blog_subject", property = "blog_subject"),
                    @Result(column = "blog_content", property = "blog_content"),
                    @Result(column = "pageView", property = "pageView")
            }
    )
    List<Blog> findByType(@Param("blog_type") String blog_type);

    /**
     * @param blog_account
     * @return
     */
    @Select("select * from blog where blog_account=#{param1}")
    @Results(
            {
                    @Result(column = "id", property = "id"),
                    @Result(column = "blog_account", property = "blog_account"),
                    @Result(column = "blog_type", property = "blog_type"),
                    @Result(column = "user_account", property = "user_account"),
                    @Result(column = "blog_img", property = "blog_img"),
                    @Result(column = "blog_subject", property = "blog_subject"),
                    @Result(column = "blog_content", property = "blog_content"),
                    @Result(column = "pageView", property = "pageView")
            }
    )
    Blog findByBlogAccount(@Param("blog_account") String blog_account);
}
