package com.ucsal.springbook.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private CustomHandler customHandler;

    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/static/**");
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(
                        authorizeConfig -> {
                            authorizeConfig.requestMatchers("/public", "/schedules", "/pending").permitAll();
                            authorizeConfig.requestMatchers("/home").hasAuthority("USER");
                            authorizeConfig.anyRequest().authenticated();
                        })
                .formLogin(form -> form
                        .loginPage("/login")
                        .successHandler(customHandler)
                        .permitAll())
                .build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails fernando = User.withUsername("fernando")
                .password(passwordEncoder().encode("fernando"))
                .authorities("USER")
                .build();
        UserDetails osvaldo = User.withUsername("osvaldo")
                .password(passwordEncoder().encode("osvaldo"))
                .authorities("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(osvaldo, fernando);
    }
}