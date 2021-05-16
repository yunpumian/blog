package com.yunpumian.blog.controller;

import com.yunpumian.blog.mapper.UserMapper;
import com.yunpumian.blog.pojo.User;
import com.yunpumian.blog.service.mailservice.MailService;
import com.yunpumian.blog.utils.IpUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author :wn
 * @program : blog
 * @descript :
 * @create :2021-03-22 21:35
 */
@Controller
public class MailController {
    @Autowired
    private MailService mailService;
    @Value("${spring.mail.username}")
    String adminEmail;
    @Resource
    private UserMapper userMapper;

    @RequestMapping("/sendMail")
    public String sendMail(HttpServletRequest request, @Param("content") String content) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();

        User byAccount = userMapper.findByAccount(username);
        String ip= IpUtils.getIpAddress(request);
        String user_emile = byAccount.getUser_emile();
        System.out.println(user_emile);
        mailService.sendMessage(adminEmail, adminEmail, "反馈邮件", "来自"+user_emile+": 的反馈意见："
                +content+"\n发送IP地址为："+ip);
        System.out.println("发送成功");
        return "redirect:/userMain";

    }
}
