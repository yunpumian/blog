package com.yunpumian.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author :wn
 * @program : blog
 * @descript :
 * @create :2021-03-18 17:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {
    private int id;
    private String role;
    private String description;

}
