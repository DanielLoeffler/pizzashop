package ch.ti8m.azubi.lod.pizzashop.service;


import ch.ti8m.azubi.lod.pizzashop.dto.Pizza;
import ch.ti8m.azubi.lod.pizzashop.persistence.PizzaDAO;

import java.util.List;

/**
 * @author Daniel Löffler
 * @since 27.02.2019
 * Pizza Service to interact between Servlets and DAO and to changes Information from the Servlets
 */
public class PizzaServiceImpl implements PizzaService {


    private PizzaDAO pizzaDAO = ServiceRegistry.getInstance().get(PizzaDAO.class);


    @Override
    public int stringToInt(String x) {
        if (x == null) {
            throw new IllegalArgumentException("ID nich vorhanden oder ungültig");
        }
        return Integer.parseInt(x);

    }

    @Override
    public Pizza getPizzaByID(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("ID nich vorhanden oder ungültig");
        }
        return pizzaDAO.getPizzaByID(x);
    }


    @Override
    public double priceToDouble(String x) {
        if (x == null) {
            throw new IllegalArgumentException("Preis nich vorhanden oder ungültig");
        }
        return Double.parseDouble(x);
    }


    @Override
    public Pizza createPizza(String name, Double price) {
        if (name == null) {
            throw new IllegalArgumentException("Name nich vorhanden oder ungültig");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Preis nich vorhanden oder ungültig");
        }
        return new Pizza(name, price);
    }


    @Override
    public void makePizza(Pizza pizza) {
        if (pizza == null) {
            throw new IllegalArgumentException("Pizza nich vorhanden oder ungültig");
        }
        pizzaDAO.create(pizza);
    }

    @Override
    public void updatePizza(Pizza p) {
        if (p == null) {
            throw new IllegalArgumentException("Pizza nich vorhanden oder ungültig");
        }
        if (p.getId() == null) {
            throw new IllegalArgumentException("ID nich vorhanden oder ungültig");
        }
        pizzaDAO.update(p, p.getId());
    }

    @Override
    public void deletePizzaByID(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("ID nich vorhanden oder ungültig");
        }
        pizzaDAO.delete(i);
    }

    @Override
    public List<Pizza> list() throws Exception {
        return pizzaDAO.getPizzas();
    }


}



