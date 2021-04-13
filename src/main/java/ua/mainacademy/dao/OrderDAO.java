package ua.mainacademy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.mainacademy.model.Order;
import ua.mainacademy.model.User;

@Repository
public interface OrderDAO extends JpaRepository<Order, Integer> {
    Order findFirstByUserAndStatus(User user, Order.Status open);
}
