package com.company.staff.staffms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // apply CORS to all endpoints
                .allowedOriginPatterns("http://localhost:3000") // your React dev server
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // HTTP methods
                .allowedHeaders("*") // allow all headers
                .allowCredentials(true) // allow cookies/auth headers
                .maxAge(3600); // cache preflight response for 1 hour
    }
}
