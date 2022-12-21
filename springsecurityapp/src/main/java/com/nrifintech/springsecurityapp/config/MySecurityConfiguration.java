package com.nrifintech.springsecurityapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class MySecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		.and()
		//http.csrf().disable()  //cross sight request forgery => harmful script => disabled
		.authorizeRequests()
		//.antMatchers("/home","/login","/register").permitAll()    //allow everbody to access without login credentials
		.antMatchers("/public/**").hasAnyRole("NORMAL")
		.antMatchers("/users/**").hasAnyRole("ADMIN")
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
	}
	
	//TWO types of roles specified
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		
		auth.inMemoryAuthentication()
		.withUser("rini")
		.password(this.passwordEncoder().encode("rini"))
		.roles("NORMAL");
		
		auth.inMemoryAuthentication()
		.withUser("john")
		.password(this.passwordEncoder().encode("john"))
		.roles("ADMIN");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		//return NoOpPasswordEncoder.getInstance();  //ensuring the password in text format (only for Development Purpose)
	    return new BCryptPasswordEncoder(10);  //ensures the password in encrypted format	
	}
	
	//protecting API endpoints role-wise
	
	
}
