package ch.ti8m.azubi.lod.pizzashop.service;


import ch.ti8m.azubi.lod.pizzashop.dto.Pizza;
import ch.ti8m.azubi.lod.pizzashop.persistence.PizzaDAO;
import ch.ti8m.azubi.lod.pizzashop.persistence.PizzaDAOJdbc;


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


    public Pizza createPizza(int id, String name, Double price) {
        return new Pizza(id, name, price);
    }


    public void makePizza(Pizza pizza) {
        pizzaDAO.create(pizza);
    }


}
