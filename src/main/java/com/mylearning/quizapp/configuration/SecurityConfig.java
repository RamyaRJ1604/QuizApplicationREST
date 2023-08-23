package com.mylearning.quizapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
        userDetailsManager
                .setUsersByUsernameQuery("select user_name, user_password, enabled from user_roles where user_name=?");
        userDetailsManager
                .setAuthoritiesByUsernameQuery("select user_name, user_role from user_roles where user_name=?");
        return userDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        // QUESTIONS
                        .requestMatchers(HttpMethod.GET, "/quiz/questions").hasAnyRole("ADMIN", "TEACHER", "STUDENT")
                        .requestMatchers(HttpMethod.GET, "/quiz/questions/**").hasAnyRole("TEACHER", "ADMIN", "STUDENT")
                        .requestMatchers(HttpMethod.POST, "/quiz/questions").hasAnyRole("TEACHER", "ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/quiz/questions").hasAnyRole("TEACHER", "ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/quiz/questions/**").hasAnyRole("TEACHER", "ADMIN")

                        // ANSWERS
                        .requestMatchers(HttpMethod.GET, "/quiz/answers").hasAnyRole("TEACHER", "ADMIN")
                        .requestMatchers(HttpMethod.GET, "/quiz/answers/**").hasAnyRole("TEACHER", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "/quiz/answers").hasAnyRole("TEACHER", "ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/quiz/answers").hasAnyRole("TEACHER", "ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/quiz/answers/**").hasAnyRole("TEACHER", "ADMIN")

                        // RESPONSES
                        .requestMatchers(HttpMethod.GET, "/quiz/responses").hasAnyRole("TEACHER", "ADMIN")

                        // RESULTS
                        .requestMatchers(HttpMethod.GET, "/quiz/results").hasAnyRole("TEACHER", "ADMIN", "STUDENT")
                        .requestMatchers(HttpMethod.GET, "/quiz/results/**").hasAnyRole("TEACHER", "ADMIN", "STUDENT")
                        .requestMatchers(HttpMethod.POST, "/quiz/results").hasRole("TEACHER")
                        .requestMatchers(HttpMethod.PUT, "/quiz/results").hasAnyRole("TEACHER", "ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/quiz/results/**").hasAnyRole("TEACHER", "ADMIN")

                        //USERS
                        .requestMatchers(HttpMethod.GET, "/quiz/users").hasAnyRole("TEACHER", "ADMIN", "STUDENT")
                        .requestMatchers(HttpMethod.GET, "/quiz/users/**").hasAnyRole("TEACHER", "ADMIN", "STUDENT")
                        .requestMatchers(HttpMethod.POST, "/quiz/users").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/quiz/users").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/quiz/users/**").hasRole("ADMIN")

        );

        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }



}
