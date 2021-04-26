package com.yunpumian.blog.controller;

import com.yunpumian.blog.mapper.BlogMapper;
import com.yunpumian.blog.mapper.UserMapper;
import com.yunpumian.blog.pojo.Blog;
import com.yunpumian.blog.pojo.User;
import com.yunpumian.blog.service.blogservice.BlogServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @author :wn
 * @program : blog
 * @descript : 查看详情
 * @create :2021-03-24 14:02
 */

@Controller
public class ContentController {
    @Resource
    private BlogServiceImpl blogService;
    @Resource
    private UserMapper userMapper;

    @GetMapping("/content")
    public ModelAndView intoContent(@Param("blog_account") String blog_account) {
        Blog blog = blogService.findByBlogAccount(blog_account);
        String user_account = blog.getUser_account();
        User user = userMapper.findByAccount(user_account);
        ModelAndView md = new ModelAndView("/contentView");
        md.addObject("blog", blog);
        md.addObject("writer", user);
        return md;
    }
}
