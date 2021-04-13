package ua.mainacademy.service;

import ua.mainacademy.model.User;

import java.util.List;

public interface UserService {

    User create(User user);
    User update(User user);
    User findOneById(Integer id);
    User findOneByLoginAndPassword(String login, String password);
    User findFirstByLogin(String login);
    List<User> findAll();
    void deleteById(Integer id);

}
