package com.yunpumian.blog.config.security;

import com.yunpumian.blog.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author :wn
 * @program : blog
 * @descript :
 * @create :2021-03-19 10:30
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    MyAuthenticationFailHandler myAuthenticationFailHandler;
    @Autowired
    MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;

    @Bean
    PasswordEncoder getPassword() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityService getService() {
        return new SecurityService();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().usernameParameter("username").passwordParameter("password").loginPage("/login")
                .successHandler(myAuthenticationSuccessHandler)
                .failureHandler(myAuthenticationFailHandler)
                .successForwardUrl("/userMain");

        http.authorizeRequests().antMatchers("/index", "/login", "/", "/user/upload", "/images/**").permitAll()
                .anyRequest().access("hasRole('superAdmin') or @rbacService.hasPermission(request,authentication)");
        http.csrf().disable();
        http.rememberMe().rememberMeParameter("remember");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(getService()).passwordEncoder(new BCryptPasswordEncoder());
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/static/**");
    }
}
