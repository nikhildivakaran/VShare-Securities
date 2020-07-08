package com.virtusaproject.vsharesecurities.server.configuration;

import com.virtusaproject.vsharesecurities.services.VShareUserDetailsService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private final VShareUserDetailsService vshareUserDetailsService;

    public SecurityConfiguration(VShareUserDetailsService vshareUserDetailsService) {
        this.vshareUserDetailsService = vshareUserDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(vshareUserDetailsService);
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .authorizeRequests()
                    .antMatchers("/", "/css/**", "/js/**", "/images/**").permitAll()
                    .antMatchers("/html/**", "/jsp/**").denyAll()
                    .antMatchers("/register").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .permitAll()
                    .loginPage("/loginPage")
                    .loginProcessingUrl("/login")
                    .defaultSuccessUrl("/dashboard")
                    .and()
                .logout()
                    .logoutSuccessUrl("/")
                    .deleteCookies("JSESSIONID");
    }
}
