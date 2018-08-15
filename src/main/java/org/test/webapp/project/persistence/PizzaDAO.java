package org.test.webapp.project.persistence;

import org.test.webapp.project.dto.Pizza;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PizzaDAO {

    private Connection connection;

    public PizzaDAO() {
        try {
            this.connection = ConnectionFactory.createDBConnection("localhost", 3306, "pizzashop", "root", "Danloe12");
        } catch (SQLException e) {
            System.out.println("Fehler beim erstellen der DB-Connection: " + e.getMessage());
        }
    }

    /**
     * Return a list of all pizzas.
     */
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
    public Pizza getPizzaByID(int id) {
        Pizza pizza = null;

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from pizza where id = " + id + ";");

            int tempID = resultSet.getInt("id");
            String name = resultSet.getString("name");
            Double price = resultSet.getDouble("price");

            pizza = new Pizza(tempID, name, price);
        } catch (SQLException e) {
            System.out.println("Pizza wurde nicht gefunden: " + e.getMessage());
        }

        return pizza;
    }

    /**
     * Create a new pizza.
     */
    public void create(Pizza pizza) {

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("insert into pizza (id, name, price) values(" + pizza.getId() + ", " + pizza.getName() + ", " + pizza.getPrice() + ");");

        } catch (SQLException e) {
            System.out.println("Fehlre beim Erstellen der Pizza: " + e.getMessage());
        }
    }

    /**
     * Update a pizza
     */
    public void update(Pizza pizza, int id) {

        try(Statement statement=connection.createStatement()) {
            statement.executeUpdate("update pizza set id="+pizza.getId()+", name="+pizza.getName()+", price="+pizza.getPrice()+" where id="+id+";");
        } catch (SQLException e) {
            System.out.println("Fehler beim Update der Pizza: "+e.getMessage());
        }

    }

    /**
     * Delete a pizza by id.
     */
    public void delete(int id)  {

        try(Statement statement=connection.createStatement()) {
            statement.executeUpdate("delete from pizza where id="+id+";");
        } catch (SQLException e) {
            System.out.println("Fehler beim Löschen der Pizza: "+e.getMessage());
        }
    }

}