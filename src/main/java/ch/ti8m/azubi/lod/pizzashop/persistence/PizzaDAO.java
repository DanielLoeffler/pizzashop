package ch.ti8m.azubi.lod.pizzashop.persistence;

import ch.ti8m.azubi.lod.pizzashop.dto.Pizza;

import java.util.List;

public interface PizzaDAO {

    /**
     * @return Returns a list all Pizzas
     * @throws Exception a exception for the list
     */
    List<Pizza> getPizzas() throws Exception;

    /**
     * @param id ID of a Pizza
     * @return Pizza of the requested Pizza
     */
    Pizza getPizzaByID(int id);

    /**
     * @param pizza creates Pizza
     */
    void create(Pizza pizza);

    /**
     * @param pizza Pizza to change
     * @param id    ID of the Pizza to change
     */
    void update(Pizza pizza, int id);

    /**
     * @param id ID of Pizza to delete
     */
    void delete(int id);
}
