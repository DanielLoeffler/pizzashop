package ch.ti8m.azubi.lod.pizzashop.service;

import ch.ti8m.azubi.lod.pizzashop.dto.Pizza;

import java.util.List;

/**
 * @author Daniel Löffler
 * @since 27.02.2019
 * PizzaService Interface
 */
public interface PizzaService {

    /**
     * @param x String of ID
     * @return ID as a int
     * String from Website to an int
     */
    int stringToInt(String x);

    /**
     * @param x ID of a Order
     * @return Price of the requested order
     * Gets a specific Pizza by ID
     */
    Pizza getPizzaByID(int x);

    /**
     * @param x String of Price
     * @return Price as a double
     * String from Website to an double
     */
    double priceToDouble(String x);

    /**
     * @param name  Name of a Pizza
     * @param price Price of a Pizza
     * @return creates a Pizza and returns it
     * Creates a Pizza
     */
    Pizza createPizza(String name, Double price);

    /**
     * @param pizza created Pizza added to DB
     *              Creates a Pizza in the DB
     */
    void makePizza(Pizza pizza);

    /**
     * @param p Pizza to change
     *          Updates a specific Oder in the DB
     */
    void updatePizza(Pizza p);

    /**
     * @param i ID of Pizza to delete
     *          Deletes a specific Oder by ID in the DB
     */
    void deletePizzaByID(int i);

    /**
     * @return Returns a list all Pizzas
     * @throws Exception a exception for the list
     *                   Lists all Orders
     */
    List<Pizza> list() throws Exception;
}
