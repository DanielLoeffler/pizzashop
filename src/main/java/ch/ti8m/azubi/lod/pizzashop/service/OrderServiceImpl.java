package ch.ti8m.azubi.lod.pizzashop.service;

import ch.ti8m.azubi.lod.pizzashop.dto.Order;
import ch.ti8m.azubi.lod.pizzashop.dto.Pizza;
import ch.ti8m.azubi.lod.pizzashop.dto.PizzaBestellung;
import ch.ti8m.azubi.lod.pizzashop.persistence.OrderDAO;
import ch.ti8m.azubi.lod.pizzashop.persistence.PizzaBestellungDAO;

import java.util.List;


public class OrderServiceImpl {

    private OrderDAO orderDAO;
    private PizzaBestellungDAO pizzaBestellungDAO;


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

    public Order makeOrder(Order order) {
        return orderDAO.create(order);
    }


    public double getPriceById(int id) {

        Pizza p = pizzaService.getPizzaByID(id);
        double price = p.getPrice();

        return price;

    }

    public List<Order> list() throws Exception {
        return orderDAO.getOrders();
    }


    public void createpizzaBestellung(PizzaBestellung pizzaBestellung) {
        pizzaBestellungDAO.create(pizzaBestellung);
    }

}
