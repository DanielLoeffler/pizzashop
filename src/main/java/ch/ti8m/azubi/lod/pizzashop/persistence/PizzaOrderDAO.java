package ch.ti8m.azubi.lod.pizzashop.persistence;


import ch.ti8m.azubi.lod.pizzashop.dto.PizzaOrder;

import java.util.List;

/**
 * @author Daniel Löffler
 * @since 27.02.2019
 * PizzaOrderDAO Interface
 */
public interface PizzaOrderDAO {

    /**
     * @return Returns a list all PizzaOrder
     * @throws Exception a exception for the list
     *                   Get all PizzaOrders in a List
     */
    List<PizzaOrder> getPizzaOrder(long bestellungsId) throws Exception;

    /**
     * @param id ID of a PizzaOrder
     * @return PizzaOrder of the requested PizzaOrder
     * Get one PizzaOrder with a specific ID (Not usable)
     */
    PizzaOrder getPizzzaOrderByID(Integer id) throws Exception;

    /**
     * @param pizzaOrder creates PizzaOrder
     *                   Creates a PizzaOrder in the DB
     */
    void create(PizzaOrder pizzaOrder, Integer bestellungId);

    /**
     * @param pizzaOrder PizzaOrder to change
     * @param id         ID of the PizzaOrder to change
     *                   Updates a PizzaOrder with a specific ID in the DB
     */
    void update(PizzaOrder pizzaOrder, Integer id);

    /**
     * @param id ID of PizzaOrder to delete
     *           Deletes a PizzaOrder with a specific ID in the DB
     */
    void delete(Integer id);
}
