package com.yunpumian.blog.service;

import com.yunpumian.blog.config.exception.GlobalExceptionHandler;
import com.yunpumian.blog.mapper.PermissionMapper;
import com.yunpumian.blog.mapper.RoleMapper;
import com.yunpumian.blog.mapper.UserMapper;
import com.yunpumian.blog.pojo.Permission;
import com.yunpumian.blog.pojo.Role;
import com.yunpumian.blog.pojo.User;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author :wn
 * @program : blog
 * @descript : Rbac服务接口
 * @create :2021-03-20 14:36
 */

/**
 * 授权
 *
 * @author 86152
 */
@Component("rbacService")
public class RbacServiceImpl implements RbacService {
    private AntPathMatcher antPathMatcher = new AntPathMatcher();
    @Resource
    RoleMapper roleMapper;
    @Resource
    UserMapper userMapper;
    @Resource
    PermissionMapper permissionMapper;

    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        Object principal = authentication.getPrincipal();

        boolean hasPermission = false;
        if (principal != null && principal instanceof User) {
            String username = ((UserDetails) principal).getUsername();
            User byAccount = userMapper.findByAccount(username);
            Set<String> urls = new HashSet<>();
            try {
                String user_role = byAccount.getUser_role();
                Role byDescription = roleMapper.findByDescription(user_role);

                Permission permissionByRole1 = permissionMapper.findPermissionByRole(byDescription.getRole());
                if (permissionByRole1.equals(null)){

                    new GlobalExceptionHandler().handleAccessException(new AccessDeniedException("权限不够"),(Model) new ModelAndView("/error/error"));
                }
                urls.add(permissionByRole1.getUrl());

            } catch (Exception e) {
               e.printStackTrace();

            }
            for (String url : urls) {
                if (antPathMatcher.match(url, request.getRequestURI())) {
                    hasPermission = true;
                    break;
                } else {
                    hasPermission = false;
                }
            }
        }
        return hasPermission;
    }
}
