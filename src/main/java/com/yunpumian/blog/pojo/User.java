package com.yunpumian.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author :wn
 * @program : blog
 * @descript :
 * @create :2021-03-18 15:18
 */
@SuppressWarnings("all")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails, Serializable {
    private int id;
   private String user_img;
   private String user_account;
    private String user_password;
    private String user_othername;
    private int subscriptioned_number;
    private int subscription_number;
    private String user_role;
    private String user_blog_id;
    private String user_emile;
    private String user_motto;

    public User(int id, String user_img, String user_account, String user_password, String user_othername, int subscriptioned_number, int subscription_number, String user_role, String user_blog_id, String user_emile, String user_motto) {
        this.id = id;
        this.user_img = user_img;
        this.user_account = user_account;
        this.user_password = user_password;
        this.user_othername = user_othername;
        this.subscriptioned_number = subscriptioned_number;
        this.subscription_number = subscription_number;
        this.user_role = user_role;
        this.user_blog_id = user_blog_id;
        this.user_emile = user_emile;
        this.user_motto = user_motto;
    }

    private List<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.user_password;
    }

    @Override
    public String getUsername() {
        return this.user_account;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
