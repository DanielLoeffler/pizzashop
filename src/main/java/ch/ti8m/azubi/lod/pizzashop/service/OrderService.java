package ch.ti8m.azubi.lod.pizzashop.service;

import ch.ti8m.azubi.lod.pizzashop.dto.Order;

import java.util.List;

/**
 * @author Daniel Löffler
 * @since 27.02.2019
 * OrderService Interface
 */
public interface OrderService {

    /**
     * @param price  the price of one pizza
     * @param anzahl the amount of one kinde of pizza
     * @return the total Price of the Order
     * Calculates Price out of the Price of the Pizza and the number of Pizzas
     */
    double calculatePrice(Double price, int anzahl);

    /**
     * @param phone   the phonenummber of the Person
     * @param address the addtess of the Person
     * @return creates an Order and returns it
     * Creates a Order
     */
    Order createOrder(String phone, String address);

    /**
     * @param order created Order added to DB
     * @return returns Order to reuse if needed
     * Creates a Order in the DB
     */
    void makeOrder(Order order);

    /**
     * @param id ID of a Order
     * @return Price of the requested order
     * Gets the Price of a specific Pizza by ID
     */
    double getPriceById(Integer id);

    /**
     * @param i ID of a Order
     * @return Order of the requested Order
     * Gets a specific Oder by ID
     */
    Order getOrderByID(Integer i);

    /**
     * @param o Order to change
     * @param i ID of the Order to change
     *          Updates a specific Oder by ID in the DB
     */
    void updateOrderByID(Order o, Integer i);

    /**
     * @param i ID of Order to delete
     *          Deletes a specific Oder by ID in the DB
     */
    void deleteOrderByID(Integer i);

    /**
     * @return Returns a list all Orders
     * @throws Exception a exception for the list
     *                   Lists all Orders
     */
    List<Order> list() throws Exception;
}
