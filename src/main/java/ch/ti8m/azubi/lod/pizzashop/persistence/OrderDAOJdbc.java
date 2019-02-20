package ch.ti8m.azubi.lod.pizzashop.persistence;


import ch.ti8m.azubi.lod.pizzashop.dto.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDAOJdbc implements OrderDAO {

    private Connection connection;

    public OrderDAOJdbc() {

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
    public List<Order> getOrders() throws Exception {
        List<Order> orders = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from bestellung;");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                //Date date = resultSet.getDate("date");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                orders.add(new Order(id, phone, address));
            }
        }

        return orders;
    }

    /**
     * Get the order with the given id. If no such person is found, null is
     * returned.
     */

    @Override
    public Order getOrderByID(Integer id) {
        Order order = null;
        String query = "select * from bestellung where id = ? ;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            int tempID = resultSet.getInt("id");
            Date date = resultSet.getDate("date");
            String phone = resultSet.getString("phone");
            String address = resultSet.getString("address");

            order = new Order(tempID, phone, address);
        } catch (SQLException e) {
            throw new RuntimeException("Order wurde nicht gefunden: " + e.getMessage());
        }
        return order;
    }


    /**
     * Create a new order.
     */

    @Override
    public void create(Order order) {

        String query = "insert into bestellung (phone, address) values( ? , ? );";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, order.getPhone());
            preparedStatement.setString(2, order.getAddress());
            int id = preparedStatement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            order.setId(id);

        } catch (SQLException e) {
            throw new RuntimeException("Fehlre beim Erstellen der Order: " + e.getMessage());
        }
    }

    /**
     * Update a order
     */

    @Override
    public void update(Order order, Integer id) {
        String query = "update bestellung set id= ? , phone= ? , address= ?  where id= ? ;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, order.getId());
            preparedStatement.setString(2, order.getPhone());
            preparedStatement.setString(3, order.getAddress());
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Fehler beim Update der Order: " + e.getMessage());
        }
    }


    /**
     * Delete a order by id.
     */

    @Override
    public void delete(Integer id) {
        String query = "delete from pizza where id= ? ;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Fehler beim Löschen der Order: " + e.getMessage());
        }
    }
}
