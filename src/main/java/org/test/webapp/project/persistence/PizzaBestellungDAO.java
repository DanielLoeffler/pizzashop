package org.test.webapp.project.persistence;

import org.test.webapp.project.dto.PizzaBestellung;

import java.util.List;

public interface PizzaBestellungDAO {
    List<PizzaBestellung> getPizzaBestellung() throws Exception;

    PizzaBestellung getPizzzaBestellungByID(int id);

    void create(PizzaBestellung pizzaBestellung);

    void update(PizzaBestellung pizzaBestellung, int id);

    void delete(int id);
}
