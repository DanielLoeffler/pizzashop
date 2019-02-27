package ch.ti8m.azubi.lod.pizzashop.persistence;

import ch.ti8m.azubi.lod.pizzashop.dto.Pizza;

import java.util.List;

/**
 * @author Daniel Löffler
 * @since 27.02.2019
 * PizzaDAO Interface
 */
public interface PizzaDAO {

    /**
     * @return Returns a list all Pizzas
     * @throws Exception a exception for the list
     *                   Get all Pizzas in a List
     */
    List<Pizza> getPizzas() throws Exception;

    /**
     * @param id ID of a Pizza
     * @return Pizza of the requested Pizza
     * Get one Pizza with a specific ID
     */
    Pizza getPizzaByID(int id);

    /**
     * @param pizza creates Pizza
     *              Creates a Pizza in the DB
     */
    void create(Pizza pizza);

    /**
     * @param pizza Pizza to change
     * @param id    ID of the Pizza to change
     *              Updates a Pizza with a specific ID in the DB
     */
    void update(Pizza pizza, int id);

    /**
     * @param id ID of Pizza to delete
     *           Deletes a Pizza with a specific ID in the DB
     */
    void delete(int id);
}
