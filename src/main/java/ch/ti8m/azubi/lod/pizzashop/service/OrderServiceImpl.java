package ch.ti8m.azubi.lod.pizzashop.service;

import ch.ti8m.azubi.lod.pizzashop.dto.Order;
import ch.ti8m.azubi.lod.pizzashop.dto.Pizza;
import ch.ti8m.azubi.lod.pizzashop.persistence.OrderDAO;

import java.util.List;


public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO = ServiceRegistry.getInstance().get(OrderDAO.class);
    private PizzaServiceImpl pizzaService = ServiceRegistry.getInstance().get(PizzaServiceImpl.class);


    public OrderServiceImpl() {

    }

    @Override
    public double calculatePrice(Double price, int anzahl) {
        if (price == null) {
            throw new IllegalArgumentException("Preis nich vorhanden oder ungültig");
        }
        if (anzahl <= 0) {
            throw new IllegalArgumentException("Anzahl nich vorhanden oder ungültig");
        }
        double total = (price * anzahl);
        return total;

    }

    @Override
    public Order createOrder(String phone, String address) {
        if (phone == null) {
            throw new IllegalArgumentException("Phonel nich vorhanden");
        }
        if (address == null) {
            throw new IllegalArgumentException("Address nich vorhanden");
        }
        return new Order(phone, address);
    }

    @Override
    public Order makeOrder(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order nich vorhanden");
        }
        return orderDAO.create(order);
    }


    @Override
    public double getPriceById(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("id nich vorhanden oder ungültig");
        }
        Pizza p = pizzaService.getPizzaByID(id);
        return p.getPrice();

    }

    @Override
    public Order getOrderByID(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("id nich vorhanden oder ungültig");
        }
        return orderDAO.getOrderByID(i);
    }

    @Override
    public void updateOrderByID(Order o, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("id nich vorhanden oder ungültig");
        }
        if (o == null) {
            throw new IllegalArgumentException("Order nich vorhanden");
        }
        orderDAO.update(o, i);
    }

    @Override
    public void deleteOrderByID(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("id nich vorhanden oder ungültig");
        }
        orderDAO.delete(i);
    }

    @Override
    public List<Order> list() throws Exception {
        return orderDAO.getOrders();
    }


}
