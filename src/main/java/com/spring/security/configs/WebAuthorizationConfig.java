package com.spring.security.configs;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer.FrameOptionsConfig;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebAuthorizationConfig {

    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.httpBasic(Customizer.withDefaults());
        
        http.csrf(c -> c.ignoringRequestMatchers(PathRequest.toH2Console()));
        http.headers(c -> c.frameOptions(FrameOptionsConfig::sameOrigin));
        http.authorizeHttpRequests(c -> c.requestMatchers(PathRequest.toH2Console()).permitAll());

        http.authorizeHttpRequests(c -> c.anyRequest().authenticated());
        return http.build();
    }
}
