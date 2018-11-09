package ch.ti8m.azubi.lod.pizzashop.persistence;


import ch.ti8m.azubi.lod.pizzashop.dto.Order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDAOJdbc implements OrderDAO {

    private Connection connection;

    public OrderDAOJdbc() {

        try {
            this.connection = ConnectionFactory.createDBConnection("localhost", 3306, "pizzashop", "root", "Danloe12");
        } catch (SQLException e) {
            System.out.println("Fehler beim erstellen der DB-Connection: " + e.getMessage());
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
                //int id = resultSet.getInt("id");
                //Date date = resultSet.getDate("date");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                orders.add(new Order(phone, address));
            }
        }

        return orders;
    }

    /**
     * Get the order with the given id. If no such person is found, null is
     * returned.
     */
    @Override
    public Order getOrderByID(int id) {
        Order order = null;

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from bestellung where id = " + id + ";");

            int tempID = resultSet.getInt("id");
            Date date = resultSet.getDate("date");
            String phone = resultSet.getString("phone");
            String address = resultSet.getString("address");

            //order = new Order(tempID, date, phone, address);
        } catch (SQLException e) {
            System.out.println("Order wurde nicht gefunden: " + e.getMessage());
        }

        return order;
    }


    /**
     * Create a new order.
     */
    @Override
    public void create(Order order) {

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("insert into bestellung (phone, address) values(" + order.getPhone() + ", " + order.getPhone() + ");");

        } catch (SQLException e) {
            System.out.println("Fehlre beim Erstellen der Order: " + e.getMessage());
        }
    }

    /**
     * Update a order
     */
    @Override
    public void update(Order order, int id) {

        try (Statement statement = connection.createStatement()) {
            //statement.executeUpdate("update bestellung set id="+order.getId()+", date="+order.getDate()+", phone="+order.getPhone()+", address="+order.getAddress()+" where id="+id+";");
        } catch (SQLException e) {
            System.out.println("Fehler beim Update der Order: " + e.getMessage());
        }

    }


    /**
     * Delete a order by id.
     */
    @Override
    public void delete(int id) {

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("delete from bestellung where id=" + id + ";");
        } catch (SQLException e) {
            System.out.println("Fehler beim Löschen der order: " + e.getMessage());
        }
    }

}
