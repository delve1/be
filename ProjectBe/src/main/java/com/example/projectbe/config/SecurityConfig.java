package com.example.projectbe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import com.example.projectbe.handler.OAuth2LoginFailureHandler;
import com.example.projectbe.handler.OAuth2LoginSuccessHandler;
import com.example.projectbe.service.CustomOAuth2UserService;

import lombok.RequiredArgsConstructor;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final OAuth2LoginSuccessHandler oAuth2LoginSuccessHandler;
    private final OAuth2LoginFailureHandler oAuth2LoginFailureHandler;
    private final CustomOAuth2UserService customOAuth2UserService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)
        throws Exception {
        // whiteList
        String[] whiteList = {
            "/", "css/**", "js/**", "img/**",
            "/user/login", "/user/loginform"
        };

        return httpSecurity
        	.cors(cors -> cors.and()
        	).csrf(csrf -> csrf.disable()
            ).headers(headers -> headers.frameOptions(options -> options.disable())
            ).sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            ).authorizeHttpRequests(config -> config
            		.requestMatchers(whiteList).permitAll()
            		.requestMatchers("/secure/**").authenticated()
            		.requestMatchers("/admin/**").hasRole("ADMIN")
                    .anyRequest().authenticated()
            ).oauth2Login(config -> config
            		.successHandler(oAuth2LoginSuccessHandler) // 동의하고 계속하기를 눌렀을 때 Handler 설정
					.failureHandler(oAuth2LoginFailureHandler) // 소셜 로그인 실패 시 핸들러 설정
					.userInfoEndpoint().userService(customOAuth2UserService) // customUserService 설정
            ).formLogin(withDefaults()
            ).exceptionHandling(config -> config
            		.accessDeniedPage("/user/denied")
            ).oauth2Login(config -> config
            		.userInfoEndpoint(userInfo -> userInfo.userService(customOAuth2UserService))
            ).sessionManagement(config -> config
            		.maximumSessions(1).expiredUrl("/user/expired")
            ).build();
    }
    


}
