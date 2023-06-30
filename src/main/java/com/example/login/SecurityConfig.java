package com.example.login;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Profile("production") // TODO 一時的にSpringSecurityによる認証を無効化
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/js/**", "/images/**");
	}

//	@Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
 //       auth.inMemoryAuthentication()
 //               .withUser("user").password("password").roles("USER");
//
//    }

	@Override
	protected void configure(HttpSecurity http) throws Exception{
                http.authorizeRequests()
                    // TODO 後で下記は修正する
                    .antMatchers("/loginForm").permitAll()
                    .antMatchers("/login/signup").permitAll()
                    .antMatchers("/home").permitAll()
                    .anyRequest().authenticated();

		http.formLogin()
			.loginProcessingUrl("/login")
			.loginPage("/loginForm")
			.passwordParameter("password")
			.usernameParameter("name")
			.defaultSuccessUrl("/home", true)
			.failureUrl("/loginForm?error");

		http.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/loginForm");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}