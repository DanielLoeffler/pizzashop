package ch.ti8m.azubi.lod.pizzashop.persistence;

import ch.ti8m.azubi.lod.pizzashop.dto.Pizza;

import java.util.List;

public interface PizzaDAO {
    List<Pizza> getPizzas() throws Exception;

    Pizza getPizzaByID(int id);

    void create(Pizza pizza);

    void update(Pizza pizza, int id);

    void delete(int id);
}
