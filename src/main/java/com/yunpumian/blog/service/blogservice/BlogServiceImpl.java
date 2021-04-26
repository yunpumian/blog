package com.yunpumian.blog.service.blogservice;

import com.yunpumian.blog.mapper.BlogMapper;
import com.yunpumian.blog.pojo.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author :wn
 * @program : blog
 * @descript :
 * @create :2021-04-09 17:36
 */
@Service
@CacheConfig(cacheNames = "blogCache", keyGenerator = "keyGenerator")
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogMapper blogMapper;

    @Override
    @Cacheable(keyGenerator = "keyGenerator", value = "blog")
    public Blog findByBlogAccount(String blogAccount) {
        return blogMapper.findByBlogAccount(blogAccount);
    }

    @Override
    @Cacheable(value = "blogList")
    public List<Blog> findByType(String blogType) {
        return blogMapper.findByType(blogType);
    }


}
