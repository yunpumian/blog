package com.yunpumian.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author :wn
 * @program : blog
 * @descript :
 * @create :2021-03-18 17:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permission implements Serializable {
    private int id;
    private String role;
    private String url;
}
