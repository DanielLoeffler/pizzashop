package ch.ti8m.azubi.lod.pizzashop.persistence;


import ch.ti8m.azubi.lod.pizzashop.dto.Order;

import java.util.List;

/**
 * @author Daniel Löffler
 * @since 27.02.2019
 * OrderDAO Interface
 */
public interface OrderDAO {

    /**
     * @return Returns a list all Orders
     * @throws Exception a exception for the list
     *                   Get all Orders in a List
     */
    List<Order> getOrders() throws Exception;

    /**
     * @param id ID of a Order
     * @return Order of the requested Order
     * Get one Order with a specific ID
     */
    Order getOrderByID(Integer id);

    /**
     * @param order creates Order
     * @return returns Order to reuse if needed
     * Creates a Order in the DB
     */
    void create(Order order);

    /**
     * @param order Order to change
     * @param id    ID of the Order to change
     *              Updates a Order with a specific ID in the DB
     */
    void update(Order order, Integer id);

    /**
     * @param id ID of Order to delete
     *           Deletes a Order with a specific ID in the DB
     */
    void delete(Integer id);
}
