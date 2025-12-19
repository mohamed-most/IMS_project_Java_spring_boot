package com.mohamedmostafa.IMS_project.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@Slf4j
public class SecurityConfig {
    private final JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                // Disable CSRF for APIs
                .csrf(csrf -> csrf.disable())

                // Define endpoint access rules
                .authorizeHttpRequests(auth -> auth
                        // Public endpoints (login, register)
                        .requestMatchers("/api/v1/auth/**").permitAll()

                        // Users endpoints
                        .requestMatchers("/api/v1/users/all").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/v1/users/{id}").hasAnyAuthority("ADMIN", "MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/v1/users/{id}").hasAnyAuthority("ADMIN", "MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/v1/users/{id}").hasAuthority("ADMIN")
                        .requestMatchers("/api/v1/users/transactions/{userId}").hasAnyAuthority("ADMIN", "MANAGER")
                        .requestMatchers("/api/v1/users/transactions/me").hasAnyAuthority("ADMIN", "MANAGER", "STAFF")
                        .requestMatchers("/api/v1/users/me").hasAnyAuthority("ADMIN", "MANAGER", "STAFF")

                        // Products endpoints
                        .requestMatchers("/api/v1/products/**").hasAnyAuthority("ADMIN", "MANAGER", "STAFF")
                        // Suppliers and Categories (example)
                        .requestMatchers("/api/v1/suppliers/**").hasAnyAuthority("ADMIN", "MANAGER")
                        .requestMatchers("/api/v1/categories/**").hasAnyAuthority("ADMIN", "MANAGER")

                        // All other endpoints must be authenticated
                        .anyRequest().authenticated()
                )

                // Stateless session (JWT)
                .sessionManagement(manager -> manager
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )

                // Add JWT filter before Spring Security authentication filter
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)

                .build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
