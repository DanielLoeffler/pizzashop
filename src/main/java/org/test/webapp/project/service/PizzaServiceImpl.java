package org.test.webapp.project.service;


import org.test.webapp.project.dto.Pizza;
import org.test.webapp.project.persistence.PizzaDAO;
import org.test.webapp.project.persistence.PizzaDAOJdbc;

public class PizzaServiceImpl {


    private PizzaDAO pizzaDAO;
    Pizza pizza =new Pizza();

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


    public double priceToDouble(String x){
        double price= Double.parseDouble(x);
        pizza.setPrice(price);
        return price;
    }


    public Pizza crreatePizza(int id, String name, Double price){
        pizza = new Pizza(id, name, price);
        return pizza;
    }

    public void makePizza(Pizza pizza) {
        pizzaDAO.create(pizza);
    }

}
