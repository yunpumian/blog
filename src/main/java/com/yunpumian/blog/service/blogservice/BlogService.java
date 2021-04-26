package com.yunpumian.blog.service.blogservice;

import com.yunpumian.blog.pojo.Blog;

import java.util.List;

/**
 * @author 86152
 */
public interface BlogService {
    /**
     * @param blogAccount
     * @return
     */
    Blog findByBlogAccount(String blogAccount);

    List<Blog> findByType(String blogType);
}
