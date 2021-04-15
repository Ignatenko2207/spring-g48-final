package ua.mainacademy.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoDatabase;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.stereotype.Service;
import ua.mainacademy.dao.UserDAO;
import ua.mainacademy.model.User;
import ua.mainacademy.service.UserService;

import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;
    private final MongoDatabase mongoDatabase;

    @Override
    public User create(User user) {
        if (isNull(user.getId()) && userDAO.findAllByLogin(user.getLogin()).isEmpty() && userDAO.findAllByEmail(user.getEmail()).isEmpty()) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                mongoDatabase.getCollection("USERS").insertOne(Document.parse(objectMapper.writeValueAsString(user)));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return userDAO.save(user);
        }
        throw new RuntimeException("User can not be created.");
    }

    @Override
    public User update(User user) {
        if (nonNull(user.getId())) {
            User savedUser = userDAO.findById(user.getId())
                    .orElseThrow(() -> new RuntimeException("User was not found"));
            if (!user.getEmail().equals(savedUser.getEmail())) {
                List<User> result = userDAO.findAllByEmail(user.getEmail());
                if (!result.isEmpty()) {
                    throw new RuntimeException("User email can not be updated");
                }
            }
            if (!user.getLogin().equals(savedUser.getLogin())) {
                List<User> result = userDAO.findAllByLogin(user.getLogin());
                if (!result.isEmpty()) {
                    throw new RuntimeException("User login can not be updated");
                }
            }
            return userDAO.save(user);
        }
        throw new RuntimeException("User can not be updated");
    }

    @Override
    public User findOneById(Integer id) {
        return userDAO.findById(id).orElseThrow(() -> new RuntimeException("User was not found"));
    }

    @Override
    public User findOneByLoginAndPassword(String login, String password) {
        return userDAO.findUserByLoginAndAndPassword(login, password);
    }

    @Override
    public User findFirstByLogin(String login) {
        return userDAO.findFirstByLogin(login);
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        userDAO.deleteById(id);
    }

}
