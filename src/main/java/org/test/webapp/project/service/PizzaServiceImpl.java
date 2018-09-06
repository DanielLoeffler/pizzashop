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

    public Pizza getPizzaByID(int x) {
       return pizzaDAO.getPizzaByID(x);
    }


    public double priceToDouble(String x){
        return Double.parseDouble(x);
    }


    public Pizza crreatePizza(int id, String name, Double price){
        return new Pizza(id, name, price);
    }


    public void makePizza(Pizza pizza) {
        pizzaDAO.create(pizza);
    }


}
