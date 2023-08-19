package com.masai.otms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.bind.annotation.PostMapping;

@Configuration
public class AppConfig {

//	@Bean
//	public SecurityFilterChain springSecurityConfiguration(HttpSecurity http) throws Exception {
//
//		http.authorizeHttpRequests()
//                .requestMatchers(HttpMethod.POST, "/customers").permitAll()
//                .requestMatchers(HttpMethod.POST, "/users").permitAll()
//                .requestMatchers(HttpMethod.POST, "/bookings").permitAll()
//                .requestMatchers(HttpMethod.POST, "/travels").permitAll()
//                .requestMatchers(HttpMethod.POST, "/routes").permitAll()
//                .requestMatchers("/admin/**").hasRole("ADMIN")
//                .anyRequest()
//                .authenticated()
//                .and()
//                .csrf().disable()
//                .formLogin()
//                .and()
//                .httpBasic();
//
//		return http.build();
//
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//
//		return new BCryptPasswordEncoder();
//
//	}
//
//    @Bean
//    public UserDetailsService userDetailsService(){
//
//        UserDetails adminUser = User.withUsername("aman").password(passwordEncoder().encode("aman")).roles("ADMIN").build();
//
//        return new InMemoryUserDetailsManager(adminUser);
//    }

}
