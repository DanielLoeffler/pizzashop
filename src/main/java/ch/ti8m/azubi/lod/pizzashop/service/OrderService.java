package ch.ti8m.azubi.lod.pizzashop.service;

import ch.ti8m.azubi.lod.pizzashop.dto.Order;

import java.util.List;

public interface OrderService {

    List<Order> getOrders();

    void addOrder(Order order);
}
