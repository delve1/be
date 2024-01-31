package com.example.projectbe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)
        throws Exception {
        // whiteList
        String[] whiteList = {
            "/", "/user/loginform", "/user/required_loginform", "/user/login",
        };

        httpSecurity
        	.cors(cors -> cors.and())
            .csrf(csrf -> csrf.disable())
            .headers(headers -> headers.frameOptions(options -> options.disable()))
            .authorizeHttpRequests(config -> config
            		.requestMatchers(whiteList).permitAll()
                    .requestMatchers("/admin/**").hasRole("ADMIN")
                    .requestMatchers("/staff/**").hasAnyRole("ADMIN", "STAFF")
                    .anyRequest().authenticated()
            ).logout(config -> config
	                .logoutUrl("/user/logout")
	                .logoutSuccessUrl("/")
	                .permitAll()
            ).exceptionHandling(config -> config
            		.accessDeniedPage("/user/denied")
            ).oauth2Login(config -> config
            		.userInfoEndpoint(userInfo -> userInfo.userService(customOAuth2UserService))
            ).sessionManagement(config -> config
            		.maximumSessions(1).expiredUrl("/user/expired")
            );

        return httpSecurity.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationManager authenticationManager(
        HttpSecurity http,
        BCryptPasswordEncoder bCryptPasswordEncoder,
        UserDetailsService userDetailService
    ) throws Exception {
        return http
            .getSharedObject(AuthenticationManagerBuilder.class)
            .userDetailsService(userDetailService)
            .passwordEncoder(bCryptPasswordEncoder)
            .and()
            .build();
    }
}
