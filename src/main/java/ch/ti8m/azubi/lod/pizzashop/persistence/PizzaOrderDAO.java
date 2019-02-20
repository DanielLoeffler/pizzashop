package ch.ti8m.azubi.lod.pizzashop.persistence;


import ch.ti8m.azubi.lod.pizzashop.dto.PizzaOrder;

import java.util.List;

public interface PizzaOrderDAO {

    /**
     * @return Returns a list all PizzaBestellungen
     * @throws Exception a exception for the list
     */
    List<PizzaOrder> getPizzaBestellungen(long bestellungsId) throws Exception;

    /**
     * @param id ID of a PizzaOrder
     * @return PizzaOrder of the requested PizzaOrder
     */
    PizzaOrder getPizzzaBestellungByID(Integer id) throws Exception;

    /**
     * @param pizzaOrder creates PizzaOrder
     */
    void create(PizzaOrder pizzaOrder, Integer bestellungId);

    /**
     * @param pizzaOrder PizzaOrder to change
     * @param id         ID of the PizzaOrder to change
     */
    void update(PizzaOrder pizzaOrder, Integer id);

    /**
     * @param id ID of PizzaOrder to delete
     */
    void delete(Integer id);
}
