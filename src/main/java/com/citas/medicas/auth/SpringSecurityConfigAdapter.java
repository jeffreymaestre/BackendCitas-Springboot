package com.citas.medicas.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public interface SpringSecurityConfigAdapter {
    @Autowired
    void configure(AuthenticationManagerBuilder auth) throws Exception;

    void configure(HttpSecurity http) throws Exception;
}
