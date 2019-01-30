package ch.ti8m.azubi.lod.pizzashop.service;

import ch.ti8m.azubi.lod.pizzashop.dto.PizzaBestellung;

import java.util.List;

public interface PizzaBestellungService {

    /**
     * @param orderID ID of the Order
     * @param pizzaID ID of the Pizza
     * @param anzahl  the amount of Pizzas in the Orders
     * @param price   the total of the Price
     * @return creates a PizzaBestellung
     */
    PizzaBestellung createPizzaBestellung(int orderID, int pizzaID, int anzahl, double price);

    /**
     * @param pizzaBestellung created PizzaBestellung added to BD
     */
    void makePizzaBestellung(PizzaBestellung pizzaBestellung);

    /**
     * @param i ID of a PizzaBestellung
     * @return PizzaBestellung of the requested PizzaBestellung
     */
    PizzaBestellung getPizzaBestellungByID(int i);

    /**
     * @param pb PizzaBestellung to changed
     * @param x  ID of the PizzaBestellung to changed
     */
    void updatePizzaBestellungByID(PizzaBestellung pb, int x);

    /**
     * @param x ID of PizzaBestellung to delete
     */
    void deletePizzaBestellungByID(int x);

    /**
     * @return returns a list of all PizzaBestellungen
     * @throws Exception a exception for the list
     */
    List<PizzaBestellung> list() throws Exception;
}
