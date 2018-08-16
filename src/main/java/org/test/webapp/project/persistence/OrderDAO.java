package org.test.webapp.project.persistence;

import org.test.webapp.project.dto.Order;

import java.util.List;

public interface OrderDAO {
    List<Order> getOrders() throws Exception;

    Order getOrderByID(int id);

    void create(Order order);

    void update(Order order, int id);

    void delete(int id);
}
