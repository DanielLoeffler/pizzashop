package ch.ti8m.azubi.lod.pizzashop.persistence;

import ch.ti8m.azubi.lod.pizzashop.dto.PizzaBestellung;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PizzaBestellungDAOJdbc implements PizzaBestellungDAO {

    private Connection connection;

    public PizzaBestellungDAOJdbc() {
        try {
            this.connection = ConnectionFactory.createDBConnection("localhost", 3306, "pizzashop", "root", "Danloe12");
        } catch (SQLException e) {
            throw new RuntimeException("Fehler beim erstellen der DB-Connection: " + e.getMessage());
        }
    }

    /**
     * Return a list of all orders.
     */
    @Override
    public List<PizzaBestellung> getPizzaBestellung() throws Exception {
        List<PizzaBestellung> pizzaBestellungs = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from pizza_bestellung;");
            while (resultSet.next()) {
                //int id = resultSet.getInt("id");
                int bestellung_id = resultSet.getInt("bestellung_id");
                int pizza_id = resultSet.getInt("pizza_id");
                int anzahl = resultSet.getInt("anzahl");
                double preis = resultSet.getDouble("preis");
                pizzaBestellungs.add(new PizzaBestellung(bestellung_id, pizza_id, anzahl, preis));
            }
        }

        return pizzaBestellungs;
    }

    /**
     * Get the order with the given id. If no such person is found, null is
     * returned.
     */
    @Override
    public PizzaBestellung getPizzzaBestellungByID(int id) {
        PizzaBestellung pizzaBestellung = null;

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from pizza_bestellung where id = " + id + ";");

            int tempID = resultSet.getInt("id");
            int bestellung_id = resultSet.getInt("bestellung_id");
            int pizza_id = resultSet.getInt("pizza_id");
            int anzahl = resultSet.getInt("anzahl");

            //pizzaBestellung = new PizzaBestellung(tempID, bestellung_id, pizza_id, anzahl);
        } catch (SQLException e) {
            throw new RuntimeException("Pizza_Order wurde nicht gefunden: " + e.getMessage());
        }

        return pizzaBestellung;
    }

    /**
     * Create a new order.
     */
    @Override
    public void create(PizzaBestellung pizzaBestellung) {

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("insert into pizza_bestellung (bestellung_id, pizza_id, anzahl, preis) values(" + pizzaBestellung.getBestellung_id() + ", " + pizzaBestellung.getPizza_id() + ", " + pizzaBestellung.getAnzahl() + pizzaBestellung.getPreis() + ");");

        } catch (SQLException e) {
            throw new RuntimeException("Fehlre beim Erstellen der PizzaOrder: " + e.getMessage());
        }
    }

    /**
     * Update a order
     */
    @Override
    public void update(PizzaBestellung pizzaBestellung, int id) {

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("update pizza_bestellung bestellung_id=" + pizzaBestellung.getBestellung_id() + ", pizza_id=" + pizzaBestellung.getPizza_id() + ", anzahl=" + pizzaBestellung.getAnzahl() + " where id=" + id + ";");
        } catch (SQLException e) {
            throw new RuntimeException("Fehler beim Update der pizza_Order: " + e.getMessage());
        }

    }

    /**
     * Delete a order by id.
     */
    @Override
    public void delete(int id) {

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("delete from pizza_bestellung where id=" + id + ";");
        } catch (SQLException e) {
            throw new RuntimeException("Fehler beim Löschen der Pizza_Order: " + e.getMessage());
        }
    }


}
