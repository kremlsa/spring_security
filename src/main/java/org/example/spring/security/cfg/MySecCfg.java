package org.example.spring.security.cfg;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@EnableWebSecurity
public class MySecCfg extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser(userBuilder.username("zaur")
                .password("zaur").roles("EMPLOYEE"))
                .withUser(userBuilder.username("alex")
                        .password("alex").roles("HR"))
                .withUser(userBuilder.username("axl")
                        .password("axl").roles("MANAGER", "HR"));

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasAnyRole("EMPLOYEE",
                "HR", "MANAGER")
//                .antMatchers("/hr_info").hasRole("HR")
                .antMatchers("/hr_info").anonymous()
                .antMatchers("/manager_info/**").hasRole("MANAGER")
                .and().formLogin().permitAll();

    }
}
