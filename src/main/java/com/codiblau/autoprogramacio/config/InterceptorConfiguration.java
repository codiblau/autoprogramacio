package com.codiblau.autoprogramacio.config;

import com.codiblau.autoprogramacio.handler.TokenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class InterceptorConfiguration implements WebMvcConfigurer {

    @Bean
    public TokenInterceptor getInterceptor(){
        return new TokenInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] excludedPiano = {"/piano/auth/**/*", "/piano/public/**/*", "/piano/nologin/**/*"};
        registry.addInterceptor(getInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(excludedPiano);
    }
}