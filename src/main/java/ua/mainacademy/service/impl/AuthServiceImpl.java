//package ua.mainacademy.service.impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import ua.mainacademy.dao.UserDAO;
//import ua.mainacademy.model.User;
//
//import java.util.List;
//
//import static java.util.Objects.isNull;
//
//@Service
//public class AuthServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private UserDAO userDAO;
//
//    @Override
//    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
//        User user = userDAO.findFirstByLogin(login);
//        if (isNull(user)) {
//            throw new RuntimeException("User not found with login " + login);
//        }
//        List<GrantedAuthority> authorities =
//                List.of(new SimpleGrantedAuthority(user.getRole().name()));
//        return org.springframework.security.core.userdetails.User.builder()
//                .username(user.getLogin())
//                .password(user.getPassword())
//                .authorities(authorities)
//                .build();
//    }
//}
