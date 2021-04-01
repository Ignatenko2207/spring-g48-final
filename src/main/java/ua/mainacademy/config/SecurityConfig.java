package ua.mainacademy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import ua.mainacademy.service.impl.AuthServiceImpl;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private AuthServiceImpl authService = new AuthServiceImpl();

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authService);
    }

}
