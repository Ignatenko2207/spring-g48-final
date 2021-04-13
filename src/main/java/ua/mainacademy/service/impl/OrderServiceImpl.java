package ua.mainacademy.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.mainacademy.dao.OrderDAO;
import ua.mainacademy.model.Order;
import ua.mainacademy.model.User;
import ua.mainacademy.service.OrderService;
import ua.mainacademy.service.UserService;

import java.util.Date;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderDAO orderDAO;
    private final UserService userService;

    @Override
    public Order create(Integer userId) {
        // TODO: check open cart before
        User user = ofNullable(userService.findOneById(userId))
                .orElseThrow(() -> new RuntimeException("Go away!"));
        Order order = Order.builder()
                .user(user)
                .creationTime(new Date().getTime())
                .status(Order.Status.OPEN)
                .build();
        return orderDAO.save(order);
    }

    @Override
    public Order update(Order order) {
        return orderDAO.save(order);
    }

    @Override
    public Order updateStatus(Integer id) {
        if (nonNull(id)) {

        }
        return null;
    }

    @Override
    public void delete(Order order) {

    }

    @Override
    public List<Order> findByUser(User user) {
        return null;
    }

    @Override
    public Order findFirstActiveByUser(User user) {
        return orderDAO.findFirstByUserAndStatus(user, Order.Status.OPEN);
    }
}
