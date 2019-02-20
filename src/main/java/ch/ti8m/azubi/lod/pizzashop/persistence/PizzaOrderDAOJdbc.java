package ch.ti8m.azubi.lod.pizzashop.persistence;

import ch.ti8m.azubi.lod.pizzashop.dto.PizzaOrder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PizzaOrderDAOJdbc implements PizzaOrderDAO {

    private Connection connection;

    public PizzaOrderDAOJdbc() {
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
    public List<PizzaOrder> getPizzaBestellungen(long bestellungsId) throws Exception {
        List<PizzaOrder> pizzaOrders = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from pizza_bestellung where bestellung_id=" + bestellungsId);
            while (resultSet.next()) {
                //int id = resultSet.getInt("id");
                int bestellung_id = resultSet.getInt("bestellung_id");
                int pizza_id = resultSet.getInt("pizza_id");
                int anzahl = resultSet.getInt("anzahl");
                double preis = resultSet.getDouble("preis");
                pizzaOrders.add(new PizzaOrder(pizza_id, anzahl, preis));
            }
        }

        return pizzaOrders;
    }

    /**
     * Get the order with the given id. If no such person is found, null is
     * returned.
     */

    @Override
    public PizzaOrder getPizzzaBestellungByID(Integer id) {
        PizzaOrder pizzaOrder = null;

        String query = "select * from pizza_bestellung where id = ? ;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Integer tempID = resultSet.getInt("id");
                Integer bestellung_id = resultSet.getInt("bestellung_id");
                Integer pizza_id = resultSet.getInt("pizza_id");
                Integer anzahl = resultSet.getInt("anzahl");
                pizzaOrder = new PizzaOrder(bestellung_id, pizza_id, anzahl);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Pizza_Order wurde nicht gefunden: " + e.getMessage());
        }

        return pizzaOrder;
    }


    /**
     * Create a new order.
     */

    @Override
    public void create(PizzaOrder pizzaOrder, Integer bestellungId) {
        String query = "insert into pizza_bestellung (bestellung_id, pizza_id, anzahl, preis) values( ?, ? , ? , ?);";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, bestellungId);
            preparedStatement.setInt(2, pizzaOrder.getPizza_id());
            preparedStatement.setInt(3, pizzaOrder.getAnzahl());
            preparedStatement.setDouble(4, pizzaOrder.getPreis());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Fehlre beim Erstellen der PizzaOrder: " + e.getMessage());
        }
    }

    /**
     * Update a order
     */

    @Override
    public void update(PizzaOrder pizzaOrder, Integer id) {
        String query = "update pizza_bestellung set pizza_id= ? , anzahl= ? , price= ?  where bestellung_id= ? ;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, pizzaOrder.getPizza_id());
            preparedStatement.setInt(2, pizzaOrder.getAnzahl());
            preparedStatement.setDouble(3, pizzaOrder.getPreis());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Fehler beim Update der pizza_Order: " + e.getMessage());
        }
    }


    /**
     * Delete a order by id.
     */


    @Override
    public void delete(Integer id) {
        String query = "delete from pizza_bestellung where id= ? ;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Fehler beim Löschen der Pizza_Order: " + e.getMessage());
        }
    }

}
