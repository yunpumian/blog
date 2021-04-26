package com.yunpumian.blog.service.mailservice;

import org.springframework.stereotype.Service;

/**
 * @author :wn
 * @program : blog
 * @descript :
 * @create :2021-03-22 21:20
 */

public interface MailService {
    /**
     * @param from
     * @param to
     * @param subject
     * @param content
     */
    void sendMessage(String from, String to, String subject, String content);
}
