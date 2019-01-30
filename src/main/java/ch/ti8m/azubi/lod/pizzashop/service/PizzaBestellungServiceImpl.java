package ch.ti8m.azubi.lod.pizzashop.service;

import ch.ti8m.azubi.lod.pizzashop.dto.PizzaBestellung;
import ch.ti8m.azubi.lod.pizzashop.persistence.PizzaBestellungDAO;

import java.util.List;

public class PizzaBestellungServiceImpl implements PizzaBestellungService {

    private PizzaBestellungDAO pizzaBestellungDAO = ServiceRegistry.getInstance().get(PizzaBestellungDAO.class);


    @Override
    public PizzaBestellung createPizzaBestellung(int orderID, int pizzaID, int anzahl, double price) {
        if (orderID < 0) {
            throw new IllegalArgumentException("Order nich vorhanden");
        }
        if (pizzaID < 0) {
            throw new IllegalArgumentException("Pizza nich vorhanden");
        }
        if (anzahl < 0) {
            throw new IllegalArgumentException("Anzahl nich vorhanden");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Preis nich vorhanden");
        }
        return new PizzaBestellung(orderID, pizzaID, anzahl, price);
    }

    @Override
    public void makePizzaBestellung(PizzaBestellung pizzaBestellung) {
        if (pizzaBestellung == null) {
            throw new IllegalArgumentException("PizzaBestellung nich vorhanden");
        }
        pizzaBestellungDAO.create(pizzaBestellung);
    }

    @Override
    public PizzaBestellung getPizzaBestellungByID(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("id nich vorhanden oder ungültig");
        }
        return pizzaBestellungDAO.getPizzzaBestellungByID(i);
    }

    @Override
    public void updatePizzaBestellungByID(PizzaBestellung pb, int x) {
        if (pb == null) {
            throw new IllegalArgumentException("PizzaBestellung nicht vorhanden oder ungültig");
        }
        if (x <= 0) {
            throw new IllegalArgumentException("id nicht vorhanden oder ungültig");
        }
        pizzaBestellungDAO.update(pb, x);
    }

    @Override
    public void deletePizzaBestellungByID(int x) {
        if (x <= 0) {
            throw new IllegalArgumentException("id nich vorhanden oder ungültig");
        }
        pizzaBestellungDAO.delete(x);
    }

    @Override
    public List<PizzaBestellung> list() throws Exception {
        return pizzaBestellungDAO.getPizzaBestellung();
    }


}
