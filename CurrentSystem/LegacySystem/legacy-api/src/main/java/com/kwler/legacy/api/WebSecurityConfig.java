package com.kwler.legacy.api;

import com.kwler.legacy.api.security.BCryptPasswordEncoder;
import com.kwler.legacy.api.security.StandardUserDetailsService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Log
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, mode = AdviceMode.ASPECTJ)
@FieldDefaults(makeFinal=true, level= AccessLevel.PRIVATE)
@AllArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    StandardUserDetailsService standardUserDetailsService;
    BCryptPasswordEncoder passwordEncoder;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/browser/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and()

                .authorizeRequests()
                    .antMatchers("/adminUsers/**").hasRole("ADMIN")
                    .antMatchers("/standardUsers/**").hasAnyRole("ADMIN", "STANDARD")
                    .anyRequest().permitAll().and()

                .httpBasic().and()

                .csrf().disable();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(standardUserDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource(
            @Value("${app.cors.allowed.origins}") List<String> allowedOrigins,
            @Value("${app.cors.allowed.methods}") List<String> allowedMethods,
            @Value("${app.cors.allowed.headers}") List<String> allowedHeaders
    ) {
        log.info("CORS Configuration:");
        log.info("allowed origins: " + allowedOrigins);
        log.info("allowed methods: " + allowedMethods);
        log.info("allowed headers: " + allowedHeaders);

        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(allowedOrigins);
        configuration.setAllowedMethods(allowedMethods);
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(allowedHeaders);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }

}
