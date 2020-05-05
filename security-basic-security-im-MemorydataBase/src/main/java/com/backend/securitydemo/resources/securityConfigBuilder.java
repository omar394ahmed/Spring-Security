package com.backend.securitydemo.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class securityConfigBuilder extends WebSecurityConfigurerAdapter {

    // authentication HooKS
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
         auth.inMemoryAuthentication()
                .withUser("omar")
                .password("resu")
                .roles("USER" , "ADMIN")
                .and()
                .withUser("manager")
                .password("nimda")
                .roles("ADMIN");

    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    // autherization HooKS
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin","/setting").hasRole("ADMIN")
                .antMatchers("/user").hasAnyRole("ADMIN" , "USER")
                .antMatchers("/").permitAll()
                .and().formLogin();

    }
}
