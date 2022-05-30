package com.koowin.board.config.auth;

import com.koowin.board.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf(c -> c
                        .disable()
                )
                .headers(h -> h
                        .frameOptions()
                        .disable()
                )
                .authorizeRequests(a -> a
                        .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile").permitAll()
                        .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                        .anyRequest().authenticated()
                )
                .logout(l -> l
                        .logoutSuccessUrl("/")
                )
                .oauth2Login(o -> o
                        .userInfoEndpoint()
                        .userService(customOAuth2UserService)
                );
    }
}