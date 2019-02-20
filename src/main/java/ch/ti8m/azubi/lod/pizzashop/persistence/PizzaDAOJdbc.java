package ch.ti8m.azubi.lod.pizzashop.persistence;

import ch.ti8m.azubi.lod.pizzashop.dto.Pizza;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PizzaDAOJdbc implements PizzaDAO {

    private Connection connection;

    public PizzaDAOJdbc() {
        try {
            this.connection = ConnectionFactory.createDBConnection("localhost", 3306, "pizzashop", "root", "Danloe12");
        } catch (SQLException e) {
            System.out.println("Fehler beim erstellen der DB-Connection: " + e.getMessage());
        }
    }

    /**
     * Return a list of all pizzas.
     */
    @Override
    public List<Pizza> getPizzas() throws Exception {
        List<Pizza> pizzas = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from pizza;");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Double price = resultSet.getDouble("price");
                pizzas.add(new Pizza(id, name, price));
            }
        }

        return pizzas;
    }

    /**
     * Get the pizza with the given id. If no such person is found, null is
     * returned.
     */
    @Override
    public Pizza getPizzaByID(int id) {
        Pizza pizza = null;

        String query = "select * from pizza where id = ? ;";


        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int tempID = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Double price = resultSet.getDouble("price");
                pizza = new Pizza(tempID, name, price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Pizza wurde nicht gefunden: " + e.getMessage());
        }

        return pizza;
    }

    /**
     * Create a new pizza.
     */

    @Override
    public void create(Pizza pizza) {

        String query = "insert into pizza (name, price) values( ? , ? );";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            // preparedStatement.setInt(1, pizza.getId());
            preparedStatement.setString(1, pizza.getName());
            preparedStatement.setDouble(2, pizza.getPrice());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Fehlre beim Erstellen der Pizza: " + e.getMessage());
        }
    }


    /**
     * Update a pizza
     */

    @Override
    public void update(Pizza pizza, int id) {

        String query = "update pizza set id= ? , name= ? , price= ?  where id= ? ;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, pizza.getId());
            preparedStatement.setString(2, pizza.getName());
            preparedStatement.setDouble(3, pizza.getPrice());
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Fehler beim Update der Pizza: " + e.getMessage());
        }

    }


    /**
     * Delete a pizza by id.
     */

    @Override
    public void delete(int id) {

        String query = "delete from pizza where id= ? ;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Fehler beim Löschen der Pizza: " + e.getMessage());
        }
    }

}
