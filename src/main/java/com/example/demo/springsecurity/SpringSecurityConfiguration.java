package com.example.demo.springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SpringSecurityConfiguration {
	
	private UserDetailsService employeeDetailsService;

    public SpringSecurityConfiguration(@Lazy UserDetailsService employeeDetailsService) {
        this.employeeDetailsService = employeeDetailsService;
    }
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests((authz) -> authz
					//.requestMatchers("/**").hasRole("USER")
					//.requestMatchers("/admin/**").hasRole("ADMIN")
					.requestMatchers("/**", "/address/**").permitAll()
					.anyRequest().authenticated()
					)
			.formLogin(login -> login
					.loginPage("/login")
					.defaultSuccessUrl("/list", true)
					.permitAll()
					)
			.logout(logout -> logout
					.logoutUrl("/logout")
					.logoutUrl("/logout?logout")
					.permitAll()
					);
		
		return http.build();
	}

	@Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
		//cho phép truy cập url '/api' và các file static css,js
        return (web) -> web.ignoring().requestMatchers("/api/**", "/static/**", "/address/**");
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
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManager() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(employeeDetailsService);
		provider.setPasswordEncoder(passwordEncoder());
		return new ProviderManager(provider);
	}
}
