package com.yunpumian.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author :wn
 * @program : blog
 * @descript : 博客实体类
 * @create :2021-03-22 19:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog implements Serializable {
    private int id;
    private String blog_account;
    private String blog_type;
    private String user_account;
    private String blog_img;
    private String blog_subject;
    private String blog_content;
    private int pageView;
}
