package ua.mainacademy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import ua.mainacademy.dao.UserDAO;
import ua.mainacademy.model.User;
import ua.mainacademy.service.impl.AuthServiceImpl;

import javax.annotation.PostConstruct;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private AuthServiceImpl authService = new AuthServiceImpl();

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authService);
    }

    @PostConstruct
    void postConst() {
        this.authService = new AuthServiceImpl();
    }

}
