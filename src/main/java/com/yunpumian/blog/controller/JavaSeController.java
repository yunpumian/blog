package com.yunpumian.blog.controller;

import com.yunpumian.blog.mapper.UserMapper;
import com.yunpumian.blog.pojo.Blog;
import com.yunpumian.blog.pojo.User;
import com.yunpumian.blog.service.blogservice.BlogService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * @author :wn
 * @program : blog
 * @descript : JavaSE控制器类
 * @create :2021-03-23 15:21
 */


@Controller
public class JavaSeController {
    @Autowired
    private BlogService blogService;
    @Resource
    UserMapper userMapper;

    /**
     * 根据blog类别查询博客，展示作用
     *
     * @param blog_type
     * @return
     */
    @GetMapping("/javaSe")
    public ModelAndView intoJavaSe(@Param("blog_type") String blog_type) {
        List<Blog> blog = blogService.findByType(blog_type);
        List<String> articleList = new LinkedList<>();
        ModelAndView mav = new ModelAndView("/JavaSE/JavaseMain");
        for (Blog blog1 : blog) {
            User byAccount = userMapper.findByAccount(blog1.getUser_account());
            String user_othername = byAccount.getUser_othername();
            articleList.add(user_othername);

        }
        mav.addObject("blogList", blog);
        mav.addObject("articleList", articleList);
        return mav;
    }

}
