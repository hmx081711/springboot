package com.springboot.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

//配置安全验证
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .csrfTokenRepository(new CookieCsrfTokenRepository())
                .requireCsrfProtectionMatcher(
//                        new RequestMatcher() {
//                    @Override
//                    public boolean matches(HttpServletRequest request) {
//                        return request.getRequestURI().startsWith("/login");
//                    }
                HttpServletRequest -> HttpServletRequest.getMethod().equals("POST")
    );
        http.headers().contentSecurityPolicy(" script-src https://spring.io/");
    }
}
