package com.microservice.user.config;

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
                .csrf(csrf -> csrf.disable()) // Deshabilitar CSRF para APIs REST
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/users/public/**").permitAll() // Endpoints públicos
                        .requestMatchers("/api/v1/users/admin/**").hasRole("ADMIN") // Solo ADMIN
                        .requestMatchers("/api/v1/users/editor/**").hasRole("EDITOR") // Solo EDITOR
                        .anyRequest().authenticated() // Cualquier otra solicitud requiere autenticación
                )
                .oauth2ResourceServer(oauth2 -> oauth2.jwt()); // Integración con el microservicio de seguridad (OAuth)

        return http.build();
    }
}