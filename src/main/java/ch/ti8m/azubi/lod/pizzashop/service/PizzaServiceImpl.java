package ch.ti8m.azubi.lod.pizzashop.service;


import ch.ti8m.azubi.lod.pizzashop.dto.Pizza;
import ch.ti8m.azubi.lod.pizzashop.persistence.PizzaDAO;
import ch.ti8m.azubi.lod.pizzashop.persistence.PizzaDAOJdbc;

import java.util.List;


public class PizzaServiceImpl {


    private PizzaDAO pizzaDAO;


    public PizzaServiceImpl() {
        this.pizzaDAO = new PizzaDAOJdbc();
    }

    public int idToInt(String x) {
        int id = Integer.parseInt(x);
        return id;
    }

    public Pizza getPizzaByID(int x) {
        return pizzaDAO.getPizzaByID(x);
    }


    public double priceToDouble(String x) {
        return Double.parseDouble(x);
    }


    public Pizza createPizza(String name, Double price) {
        return new Pizza(name, price);
    }


    public void makePizza(Pizza pizza) {
        pizzaDAO.create(pizza);
    }

    public List<Pizza> list() throws Exception {
        return pizzaDAO.getPizzas();
    }


}



