package ch.ti8m.azubi.lod.pizzashop.persistence;


import ch.ti8m.azubi.lod.pizzashop.dto.PizzaBestellung;

import java.util.List;

public interface PizzaBestellungDAO {
    List<PizzaBestellung> getPizzaBestellung() throws Exception;

    PizzaBestellung getPizzzaBestellungByID(int id);

    void create(PizzaBestellung pizzaBestellung);

    void update(PizzaBestellung pizzaBestellung, int id);

    void delete(int id);
}
