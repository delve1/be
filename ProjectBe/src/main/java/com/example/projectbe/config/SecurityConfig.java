package com.example.projectbe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)
        throws Exception {
        // whiteList
        String[] whiteList = {
            "/", "css/**", "js/**", "img/**",
            "/user/loginform"
        };

        return httpSecurity
        	.cors(cors -> cors.and()
        	).csrf(csrf -> csrf.disable()
            ).headers(headers -> headers.frameOptions(options -> options.disable())
            ).authorizeHttpRequests(config -> config
            		.requestMatchers(whiteList).permitAll()
            		.anyRequest().permitAll()
//                    .anyRequest().authenticated()
            ).oauth2Login(withDefaults()
            ).formLogin(withDefaults()
            ).exceptionHandling(config -> config
            		.accessDeniedPage("/user/denied")
            ).logout(config -> config
                    .logoutUrl("/user/logout")
                    .logoutSuccessUrl("/")
                    .permitAll()
            ).build();
        
    }
}
