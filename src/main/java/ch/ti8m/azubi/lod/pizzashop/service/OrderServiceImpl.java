package ch.ti8m.azubi.lod.pizzashop.service;

import ch.ti8m.azubi.lod.pizzashop.dto.Order;
import ch.ti8m.azubi.lod.pizzashop.dto.Pizza;
import ch.ti8m.azubi.lod.pizzashop.persistence.OrderDAO;


public class OrderServiceImpl {

    private OrderDAO orderDAO;


    PizzaServiceImpl pizzaService = new PizzaServiceImpl();


    public OrderServiceImpl() {

    }

    public double calculatePrice(Double price, int anzahl) {
        double total = (price * anzahl);
        return total;
    }

    public Order createOrder(String phone, String address) {

        return new Order(phone, address);
    }

    public void makeOrder(Order order) {
        orderDAO.create(order);
    }


    public double getPriceById(int id) {

        Pizza p = pizzaService.getPizzaByID(id);
        double price = p.getPrice();

        return price;

    }


}
