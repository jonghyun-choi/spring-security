package com.spring.security.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.spring.security.providers.CustomAuthenticationProvider;

// @Configuration
public class ProjectConfig {

    private final CustomAuthenticationProvider customAuthenticationProvider;

    public ProjectConfig(CustomAuthenticationProvider customAuthenticationProvider) {
        this.customAuthenticationProvider = customAuthenticationProvider;
    }
    
    @Bean
    UserDetailsService userDetailsService() {
        UserDetails userDetails = User.withUsername("John")
            .password("12345")
            .authorities("read")
            .build();

        return new InMemoryUserDetailsManager(userDetails);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance(); // compares password only using equals(Object o) of String class
    }

    // @Bean
    // SecurityFilterChain configure(HttpSecurity http) throws Exception {
    //     http.httpBasic(Customizer.withDefaults());                          // .httpBasic() HTTP Basic Authentication
    //     // Customizer defines customization of spring security
    //     // http.authorizeHttpRequests(c -> c.anyRequest().authenticated());    // all requests require authentication
    //     http.authorizeHttpRequests(c -> c.anyRequest().permitAll());     // all requests require no authentication
    //     return http.build();
    // }

    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.httpBasic(Customizer.withDefaults());
        http.authenticationProvider(customAuthenticationProvider);
        http.authorizeHttpRequests(c -> c.anyRequest().authenticated());
        return http.build();
    }
}
