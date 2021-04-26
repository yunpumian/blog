package com.yunpumian.blog.controller;

import com.yunpumian.blog.mapper.UserMapper;
import com.yunpumian.blog.pojo.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;

/**
 * @author :wn
 * @program : blog
 * @descript :
 * @create :2021-03-19 14:53
 */

@Controller
public class BasisController {
    @Resource
    UserMapper userMapper;

    @RequestMapping("/userMain")
    public ModelAndView success() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        User user = userMapper.findByAccount(username);
        ModelAndView md = new ModelAndView("/userMain");
        md.addObject("user", user);
        return md;
    }

}
