package ch.ti8m.azubi.lod.pizzashop.service;

import ch.ti8m.azubi.lod.pizzashop.dto.Order;

import java.util.List;

public interface OrderService {

    /**
     * @param price  the price of one pizza
     * @param anzahl the amount of one kinde of pizza
     * @return the total Price of the Order
     */
    double calculatePrice(Double price, int anzahl);

    /**
     * @param phone   the phonenummber of the Person
     * @param address the addtess of the Person
     * @return creates an Order and returns it
     */
    Order createOrder(String phone, String address);

    /**
     * @param order created Order added to DB
     * @return returns Order to reuse if needed
     */
    void makeOrder(Order order);

    /**
     * @param id ID of a Order
     * @return Price of the requested order
     */
    double getPriceById(Integer id);

    /**
     * @param i ID of a Order
     * @return Order of the requested Order
     */
    Order getOrderByID(Integer i);

    /**
     * @param o Order to change
     * @param i ID of the Order to change
     */
    void updateOrderByID(Order o, Integer i);

    /**
     * @param i ID of Order to delete
     */
    void deleteOrderByID(Integer i);

    /**
     * @return Returns a list all Orders
     * @throws Exception a exception for the list
     */
    List<Order> list() throws Exception;
}
