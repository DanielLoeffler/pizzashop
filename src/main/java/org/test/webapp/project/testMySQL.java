package org.test.webapp.project;

import org.test.webapp.project.persistence.PizzaDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

public class testMySQL {
    public static void main(String[] args) throws Exception {
        // load the driver - this will also register it (or fail when the driver is not available)
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL JDBC Driver not found");
        }


        String host = "localhost";
        int port = 3306;
        String dbName = "jdbctest";
        String user = "root";
        String password = "Danloe12";//passwort einfüllen

        String connectionURL = String.format("jdbc:mysql://%s:%d/%s", host, port, dbName);
        try (Connection connection = (Connection) DriverManager.getConnection(connectionURL, user, password)) {
            // do something with the connection

            // the connection will automatically be closed afterwards (when opened in the try()).
            int idDeled = 23;
            try (Statement statement = (Statement) connection.createStatement()) {

                String sql = String.format("insert into person (firstname, lastname, birthdate) values ('%s', '%s', '%s')", "John", "Doe", "1960-01-01");
                statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
                ResultSet generatedKeys = statement.getGeneratedKeys();
                generatedKeys.next();
                int generatedId = generatedKeys.getInt(1);
                System.out.println("Created new person with id=" + generatedId);
            }

            try (Statement statement = (Statement) connection.createStatement()) {

                String sql = String.format("delete from person where id=" + idDeled);
                int numberOfDeletedRecords = statement.executeUpdate(sql);
                System.out.println("Deleted " + numberOfDeletedRecords);
            }
            try (java.sql.Statement statement = connection.createStatement()) {

                ResultSet resultSet = statement.executeQuery("select * from person");
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String firstName = resultSet.getString("firstName");
                    String lastName = resultSet.getString("lastName");
                    Date birthDate = resultSet.getDate("birthDate");

                    System.out.println("#" + id + ": " + firstName + " " + lastName + ", born on " + birthDate);
                }

            }


        }

    }

    public class Person {

        private Integer id;
        private String firstName;
        private String lastName;
        private Date birthDate;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public Date getBirthDate() {
            return birthDate;
        }

        public void setBirthDate(Date birthDate) {
            this.birthDate = birthDate;
        }

        @Override
        public String toString() {
            return "#" + id + ": " + firstName + " " + lastName + ", born on " + birthDate;
        }
    }


    public class PersonDAO {

        private Connection connection;

        public PersonDAO(Connection connection) {
            this.connection = connection;
        }

        /**
         * Return a list of all persons.
         */
        public List<Person> list() throws Exception {
            return null;
            // TODO
        }

        /**
         * Get the person with the given id. If no such person is found, null is returned.
         */
        public Person get(int id) throws Exception {
            return null;
            // TODO
        }

        /**
         * Create a new person.
         */
        public void create(Person person) throws Exception {
            // TODO
        }

        /**
         * Update a person
         */
        public void update(Person person) throws Exception {
            // TODO
        }

        /**
         * Delete a person by id.
         */
        public void delete(int id) throws Exception {
            // TODO
        }
    }


}