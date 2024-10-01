
package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf(csrf -> csrf
            .ignoringRequestMatchers("/api/submit-feedback")) // Disable CSRF for /api/submit-feedback only
        .authorizeHttpRequests(authz -> authz
            .requestMatchers("/", "/contact.html", "/api/submit-feedback").permitAll() // Allow access to specific paths
            .anyRequest().authenticated() // Require authentication for all other requests
        )
        .formLogin(form -> form
            .permitAll()) // Allow all users to access the login page (default login page)
        .logout(logout -> logout
            .permitAll());

    return http.build();
  }
}
