package ch.ti8m.azubi.lod.pizzashop.persistence;


import ch.ti8m.azubi.lod.pizzashop.dto.Order;

import java.util.List;

public interface OrderDAO {

    /**
     * @return Returns a list all Orders
     * @throws Exception a exception for the list
     */
    List<Order> getOrders() throws Exception;

    /**
     * @param id ID of a Order
     * @return Order of the requested Order
     */
    Order getOrderByID(int id);

    /**
     * @param order creates Order
     * @return returns Order to reuse if needed
     */
    Order create(Order order);

    /**
     * @param order Order to change
     * @param id    ID of the Order to change
     */
    void update(Order order, int id);

    /**
     * @param id ID of Order to delete
     */
    void delete(int id);
}
