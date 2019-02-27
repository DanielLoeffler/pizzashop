package ch.ti8m.azubi.lod.pizzashop.service;

import ch.ti8m.azubi.lod.pizzashop.dto.Order;
import ch.ti8m.azubi.lod.pizzashop.dto.Pizza;
import ch.ti8m.azubi.lod.pizzashop.dto.PizzaOrder;
import ch.ti8m.azubi.lod.pizzashop.persistence.OrderDAO;
import ch.ti8m.azubi.lod.pizzashop.persistence.PizzaOrderDAO;

import java.util.List;

/**
 * @author Daniel Löffler
 * @since 27.02.2019
 * Order Service to interact between Servlets and DAO and to changes Information from the Servlets
 */
public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO = ServiceRegistry.getInstance().get(OrderDAO.class);
    private PizzaOrderDAO pizzaOrderDAOc = ServiceRegistry.getInstance().get(PizzaOrderDAO.class);
    private PizzaService pizzaService = ServiceRegistry.getInstance().get(PizzaService.class);


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
    public void makeOrder(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order nich vorhanden");
        }
        if (order.getBestellungen() == null || order.getBestellungen().isEmpty()) {
            throw new IllegalArgumentException("Keine Bestellungen vorhanden");
        }
        orderDAO.create(order);
        List<PizzaOrder> bestellungen = order.getBestellungen();
        for (PizzaOrder bestellung : bestellungen) {
            pizzaOrderDAOc.create(bestellung, order.getId());
        }
    }


    @Override
    public double getPriceById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("id nich vorhanden oder ungültig");
        }
        Pizza p = pizzaService.getPizzaByID(id);
        return p.getPrice();

    }

    @Override
    public Order getOrderByID(Integer i) {
        if (i == null) {
            throw new IllegalArgumentException("id nich vorhanden oder ungültig");
        }
        return orderDAO.getOrderByID(i);
    }

    @Override
    public void updateOrderByID(Order o, Integer i) {
        if (i == null) {
            throw new IllegalArgumentException("id nich vorhanden oder ungültig");
        }
        if (o == null) {
            throw new IllegalArgumentException("Order nich vorhanden");
        }
        orderDAO.update(o, i);
    }

    @Override
    public void deleteOrderByID(Integer i) {
        if (i == null) {
            throw new IllegalArgumentException("id nich vorhanden oder ungültig");
        }
        orderDAO.delete(i);
    }

    @Override
    public List<Order> list() throws Exception {
        return orderDAO.getOrders();
    }


}
