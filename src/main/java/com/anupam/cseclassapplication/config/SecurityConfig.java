package com.anupam.cseclassapplication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//import org.springframework.boot.autoconfigure.security.servlet.PathRequest;

import com.anupam.cseclassapplication.service.CustomSuccessHandler;
import com.anupam.cseclassapplication.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	
	@Autowired
	CustomSuccessHandler customSuccessHandler;
	
	@Autowired
	CustomUserDetailsService customUserDetailsService;


	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		http.csrf(c -> c.disable());
		
		http.authorizeHttpRequests(request -> request.requestMatchers(AntPathRequestMatcher.antMatcher("/index/**"))
				.hasAuthority("ADMIN")
				.requestMatchers(AntPathRequestMatcher.antMatcher("/edit/**")).hasAuthority("ADMIN")
				.requestMatchers(AntPathRequestMatcher.antMatcher("/Routine/**")).hasAuthority("ADMIN")

				.requestMatchers(AntPathRequestMatcher.antMatcher("/home/**")).hasAuthority("USER")
				.requestMatchers(AntPathRequestMatcher.antMatcher("/registration")).permitAll()
				.requestMatchers(new AntPathRequestMatcher("/database/**")).permitAll()
				.requestMatchers(new AntPathRequestMatcher("/css/**")).permitAll()
				.anyRequest().authenticated())
		
		.formLogin(form -> form.loginPage("/login").loginProcessingUrl("/login")
				.successHandler(customSuccessHandler).permitAll())
		
		.logout(form -> form.invalidateHttpSession(true).clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login?logout").permitAll());
		
		http.headers().frameOptions().disable();
		return http.build();
		
	}
	

	
	@Autowired
	public void configureGlobal (AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
	}
	

}
