package ch.ti8m.azubi.lod.pizzashop.service;

import ch.ti8m.azubi.lod.pizzashop.dto.Pizza;

import java.util.List;

public interface PizzaService {

    /**
     * @param x String of ID
     * @return ID as a int
     */
    int idToInt(String x);

    /**
     * @param x ID of a Order
     * @return Price of the requested order
     */
    Pizza getPizzaByID(int x);

    /**
     * @param x String of Price
     * @return Price as a double
     */
    double priceToDouble(String x);

    /**
     * @param name  Name of a Pizza
     * @param price Price of a Pizza
     * @return creates a Pizza and returns it
     */
    Pizza createPizza(String name, Double price);

    /**
     * @param pizza created Pizza added to DB
     */
    void makePizza(Pizza pizza);

    /**
     * @param p Pizza to change
     */
    void updatePizza(Pizza p);

    /**
     * @param i ID of Pizza to delete
     */
    void deletePizzaByID(int i);

    /**
     * @return Returns a list all Pizzas
     * @throws Exception a exception for the list
     */
    List<Pizza> list() throws Exception;
}
