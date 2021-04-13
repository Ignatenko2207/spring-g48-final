package ua.mainacademy.service;

import ua.mainacademy.model.Order;
import ua.mainacademy.model.User;

import java.util.List;

public interface OrderService {

    Order create(Integer userId);
    Order update(Order order);
    Order updateStatus(Integer id);
    void delete(Order order);
    List<Order> findByUser(User user);
    Order findFirstActiveByUser(User user);

}
