package com.example.demo.springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SpringSecurityConfiguration {

	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((authz) -> authz
					.requestMatchers("/**").hasRole("employee")
					.requestMatchers("/admin/**").hasRole("ADMIN")
					)
			.formLogin(withDefaults());
		return http.build();
	}

	private Customizer<FormLoginConfigurer<HttpSecurity>> withDefaults() {
		return null;
	}

	@Bean
	public UserDetailsManager userDetailsService() {
	  UserDetails user1 = User.withDefaultPasswordEncoder()
		  .username("khanh")
		  .password("123456")
		  .roles("USER")
		  .build();
	  UserDetails user2 = User.withDefaultPasswordEncoder()
	      .username("thanh")
		  .password("123456")
		  .roles("ADMIN")
		  .build();
	 
	  return new InMemoryUserDetailsManager(user1, user2);
	}
}
