package org.test.webapp.project.service;


import org.test.webapp.project.persistence.PizzaDAO;

public class PizzaServiceImpl {

    private PizzaDAO pizzaDAO;

    public int idToInt(String x) {
        int id=Integer.parseInt(x);
        return id;
    }


}
