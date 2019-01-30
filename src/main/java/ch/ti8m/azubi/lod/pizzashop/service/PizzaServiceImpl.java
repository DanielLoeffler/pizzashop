package ch.ti8m.azubi.lod.pizzashop.service;


import ch.ti8m.azubi.lod.pizzashop.dto.Pizza;
import ch.ti8m.azubi.lod.pizzashop.persistence.PizzaDAO;

import java.util.List;


public class PizzaServiceImpl implements PizzaService {


    private PizzaDAO pizzaDAO = ServiceRegistry.getInstance().get(PizzaDAO.class);


    @Override
    public int idToInt(String x) {
        return Integer.parseInt(x);

    }

    @Override
    public Pizza getPizzaByID(int x) {
        return pizzaDAO.getPizzaByID(x);
    }


    @Override
    public double priceToDouble(String x) {
        return Double.parseDouble(x);
    }


    @Override
    public Pizza createPizza(String name, Double price) {
        return new Pizza(name, price);
    }


    @Override
    public void makePizza(Pizza pizza) {
        pizzaDAO.create(pizza);
    }

    @Override
    public void updatePizzaByID(Pizza p, int i) {
        pizzaDAO.update(p, i);
    }

    @Override
    public void deletePizzaByID(int i) {
        pizzaDAO.delete(i);
    }

    @Override
    public List<Pizza> list() throws Exception {
        return pizzaDAO.getPizzas();
    }


}



