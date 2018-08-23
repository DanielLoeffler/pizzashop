package org.test.webapp.project.service;


import org.test.webapp.project.dto.Pizza;
import org.test.webapp.project.persistence.PizzaDAO;
import org.test.webapp.project.persistence.PizzaDAOJdbc;

public class PizzaServiceImpl {


    private PizzaDAO pizzaDAO;

    public PizzaServiceImpl() {
        this.pizzaDAO = new PizzaDAOJdbc();
    }

    public int idToInt(String x) {
        int id = Integer.parseInt(x);
        return id;


    }

    public String getPizzaByID(int x) {
        Pizza pizza = pizzaDAO.getPizzaByID(x);
        if (pizza == null) {
            return "Pizza ist nicht vorhanden.";
        }
        return pizza.toString();
    }

}
