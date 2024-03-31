package com.security.jwt.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@SuppressWarnings("deprecation")
@Configuration
public class SecurityConfig {

    //As csrf isn't required, we disabled it

    @Bean
    @Autowired
    SecurityFilterChain securityFilterChain(HttpSecurity http, JWTValidationFilter jwtValidationFilter)
            throws Exception {
        http.sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        // var requestHandler = new CsrfTokenRequestAttributeHandler();
        // requestHandler.setCsrfRequestAttributeName("_csrf");
        http.authorizeHttpRequests(auth -> auth
                    .requestMatchers("/prestamos/crear", "/libreria/listar").authenticated()
                    .requestMatchers("/prestamos/**", "/libreria/**").hasAnyRole("LIBRARIAN", "ADMIN")
                    .requestMatchers("/users/**").hasRole("ADMIN")           
                    .anyRequest().authenticated())
                .addFilterAfter(jwtValidationFilter, BasicAuthenticationFilter.class);
        http.cors(cors -> corsConfigurationSource());
        http.csrf(csrf -> csrf.disable());
        // http.csrf(csrf -> csrf
        //         .csrfTokenRequestHandler(requestHandler)
        //         .ignoringRequestMatchers("/authenticate")
        //         .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
        //         .addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        var config = new CorsConfiguration();

        config.setAllowedOrigins(List.of("*"));
        config.setAllowedMethods(List.of("*"));
        config.setAllowedHeaders(List.of("*"));

        var source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return source;
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

}
