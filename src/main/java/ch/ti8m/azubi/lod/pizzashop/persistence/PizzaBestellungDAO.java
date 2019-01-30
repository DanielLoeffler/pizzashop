package ch.ti8m.azubi.lod.pizzashop.persistence;


import ch.ti8m.azubi.lod.pizzashop.dto.PizzaBestellung;

import java.util.List;

public interface PizzaBestellungDAO {

    /**
     * @return Returns a list all PizzaBestellungen
     * @throws Exception a exception for the list
     */
    List<PizzaBestellung> getPizzaBestellung() throws Exception;

    /**
     * @param id ID of a PizzaBestellung
     * @return PizzaBestellung of the requested PizzaBestellung
     */
    PizzaBestellung getPizzzaBestellungByID(int id);

    /**
     * @param pizzaBestellung creates PizzaBestellung
     */
    void create(PizzaBestellung pizzaBestellung);

    /**
     * @param pizzaBestellung PizzaBestellung to change
     * @param id              ID of the PizzaBestellung to change
     */
    void update(PizzaBestellung pizzaBestellung, int id);

    /**
     * @param id ID of PizzaBestellung to delete
     */
    void delete(int id);
}
