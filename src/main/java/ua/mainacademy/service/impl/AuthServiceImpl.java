package ua.mainacademy.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.mainacademy.dao.UserDAO;
import ua.mainacademy.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthServiceImpl implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        List<User> users = userDAO.findAllByLogin(login);
        if (users.isEmpty()) {
            throw new RuntimeException("User not found with login " + login);
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        if (users.get(0).getLogin().equals("ignatenko2207")) {
            authorities.add(new SimpleGrantedAuthority("ADMIN"));
        }

        return org.springframework.security.core.userdetails.User.builder()
                .username(users.get(0).getLogin())
                .password(users.get(0).getPassword())
                .authorities(authorities)
                .build();
    }
}
