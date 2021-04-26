package com.yunpumian.blog.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * @author :wn
 * @program : blog
 * @descript :
 * @create :2021-03-20 14:12
 */

public interface RbacService {
    boolean hasPermission(HttpServletRequest request, Authentication authentication);
}
