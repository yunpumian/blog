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
 *@Description: 发送邮箱
 *@Param: [from, to, subject, content] 
 *@return: void
 *@date: 2021/5/16
**/

    void sendMessage(String from, String to, String subject, String content);
}
