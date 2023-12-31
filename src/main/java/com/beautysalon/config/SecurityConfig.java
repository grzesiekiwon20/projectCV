package com.beautysalon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/api/user/**").authenticated();
                    auth.requestMatchers("/api/booking/**").authenticated();
                    auth.requestMatchers("/api/employee/**").authenticated();
                    auth.requestMatchers("/api/employee/create").authenticated();
                    auth.requestMatchers("/error").permitAll();
                    auth.anyRequest().permitAll();
                })
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(withDefaults())
                .build();
    }

}
