package ch.ti8m.azubi.lod.pizzashop.service;

import ch.ti8m.azubi.lod.pizzashop.dto.Order;
import ch.ti8m.azubi.lod.pizzashop.dto.Pizza;
import ch.ti8m.azubi.lod.pizzashop.dto.PizzaBestellung;
import ch.ti8m.azubi.lod.pizzashop.persistence.OrderDAO;
import ch.ti8m.azubi.lod.pizzashop.persistence.OrderDAOJdbc;
import ch.ti8m.azubi.lod.pizzashop.persistence.PizzaBestellungDAO;
import ch.ti8m.azubi.lod.pizzashop.persistence.PizzaBestellungDAOJdbc;

import java.util.List;


public class OrderServiceImpl {

    private OrderDAO orderDAO = new OrderDAOJdbc();
    private PizzaBestellungDAO pizzaBestellungDAO = new PizzaBestellungDAOJdbc();

    private PizzaServiceImpl pizzaService = new PizzaServiceImpl();


    public OrderServiceImpl() {

    }

    public double calculatePrice(Double price, int anzahl) {
        if (price == null && anzahl <= 0) {
            throw new IllegalArgumentException("Preis und Anzahl nich vorhanden oder ungültig");
        }
        double total = (price * anzahl);
        return total;

    }

    public Order createOrder(String phone, String address) {
        if (phone == null) {
            throw new IllegalArgumentException("Phonel nich vorhanden");
        }
        if (address == null) {
            throw new IllegalArgumentException("Address nich vorhanden");
        }
        return new Order(phone, address);
    }

    public Order makeOrder(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order nich vorhanden");
        }
        return orderDAO.create(order);
    }


    public double getPriceById(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("id nich vorhanden oder ungültig");
        }
        Pizza p = pizzaService.getPizzaByID(id);
        double price = p.getPrice();

        return price;

    }

    public List<Order> list() throws Exception {
        return orderDAO.getOrders();
    }


    public void createpizzaBestellung(PizzaBestellung pizzaBestellung) {
        if (pizzaBestellung == null) {
            throw new IllegalArgumentException("PizzaBestellung nich vorhanden");
        }
        pizzaBestellungDAO.create(pizzaBestellung);
    }

}
