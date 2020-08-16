package com.example.demo.sec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import com.example.demo.sec.service.CustomUserService;


@SuppressWarnings("deprecation")
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{//1
	// 配置登录方法Bean
	@Bean
	UserDetailsService customUserService(){ //2
		return new CustomUserService(); 
	}
	// 重写登录方法
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserService()); //3
		
	}
	@Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
	}
	// 设置免加密
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
	  return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
	// 设置登录拦截连
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/login").permitAll()
		.antMatchers("/**.html","/bootstrap/**","/jquery.**","/popper.**","/**.jpg").permitAll()
		.antMatchers("/rest/*").permitAll()
						.anyRequest().authenticated() //4
						.and()
						.formLogin()
						.loginPage("/login")
							.defaultSuccessUrl("/")
							.failureUrl("/login")
							.permitAll() //5
						.and()
						.logout().permitAll()
						; //6
		http
        .csrf().disable();

	}


}
