package com.yunpumian.blog.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.yunpumian.blog.pojo.User;
import com.yunpumian.blog.service.mailservice.MailService;
import com.yunpumian.blog.service.userservice.UserService;
import com.yunpumian.blog.service.userservice.UserServiceImpl;
import com.yunpumian.blog.utils.AccountUtils;
import com.yunpumian.blog.utils.JsonResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

import java.io.File;
import java.io.IOException;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author :wn
 * @program : blog
 * @descript : User控制类
 * @create :2021-03-25 14:41
 */
@SuppressWarnings("all")
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    MailService mailService;
    @Autowired
    AccountUtils accountUtils;
    @Value("${spring.mail.username}")
    String adminEmail;
    //注册方法
    @RequestMapping(value = "/register ")
    public String register(@RequestBody User user) {
        String account = accountUtils.getAccount();
        user.setUser_role("用户");
        user.setUser_account(account);
        mailService.sendMessage(adminEmail,user.getUser_emile(),"账号","尊敬的用户：你的账号为"+account+"！你可以用账号或者邮件登录！欢迎你的加入");
        userService.addUser(user);
        return "redirect:/index";
    }

    //获取全部用户
    @RequestMapping("/userList")
    @ResponseBody
    public Map getUserList() {
        List<User> all = userService.findAll();
        for (User user : all) {
            System.out.println(user.toString());
        }
        JsonResult jsonResult = new JsonResult();
        if (all.size() == 0) {
            jsonResult.setCode(1);
        } else {
            jsonResult.setCode(0);
            jsonResult.setData(all);

        }
        return jsonResult.getValues();
    }

    //头像上传方法
    public final static String UPLOAD_PATH_PREFIX = "static/images/";
    @RequestMapping("/upload")
    @ResponseBody
    public Map upload(@RequestParam("file") MultipartFile uploadFile, HttpServletRequest request) throws IOException {
        if (uploadFile.isEmpty()) {
            return null;
        }
        //构建文件上传所要保存的"文件夹路径"--这里是相对路径，保存到项目根路径的文件夹下
        String realPath = new String("src/main/resources/" + UPLOAD_PATH_PREFIX);
        //存放上传文件的文件夹
        File file = new File(realPath);
        if (!file.isDirectory()) {
            //递归生成文件夹
            file.mkdirs();
        }
        //获取原始的名字  original:最初的，起始的  方法是得到原来的文件名在客户机的文件系统名称
        String originalFilename = uploadFile.getOriginalFilename();
        //获取文件的后缀：
        String oldName = originalFilename.substring(originalFilename.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString();
        String newName = uuid.replace("-", "") + oldName;
        System.out.println(newName);

        //构建真实的文件路径
        File newFile = new File(file.getAbsolutePath() + File.separator + newName);
        //转存文件到指定路径，如果文件名重复的话，将会覆盖掉之前的文件,这里是把文件上传到 “绝对路径”
        uploadFile.transferTo(newFile);
        String filePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/images/" + newName;
        JsonResult jsonResult = new JsonResult();
        jsonResult.put("fileName", filePath);
        System.out.println(filePath);
        jsonResult.setCode(1);
        return jsonResult.getValues();
    }
    //通过账号修改
    @PostMapping("/updateRoleByAccount")
    public String updateRoleByAccount(@Param("role") String role,@Param("account")String account){
        Boolean aBoolean = userService.updateRoleByAccount(role, account);
        if (aBoolean){
            return "redirect:/userMain";
        }else{
            return "redirect:/userMain";
        }
    }
    //根据账号删除
    @PostMapping("/deleteByAccount")
    @ResponseBody
    public Map deleteByAccount(@RequestParam("account") String account){
        int i = userService.deleteByAccount(account);
        JsonResult jsonResult=new JsonResult();
        if(i>0){
            jsonResult.setCode(1);
            return jsonResult.getValues();

        }else{
            jsonResult.setCode(0);
            return jsonResult.getValues();
        }
    }


}
