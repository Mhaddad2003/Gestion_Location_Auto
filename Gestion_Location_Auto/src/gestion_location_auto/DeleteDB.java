package gestion_location_auto;
import java.sql.*;

public class DeleteDB {

    public DeleteDB() {
        try {
            // Load the MySQL JDBC driver class
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connection protocol
            String protocol = "jdbc:mysql:";
            String ip = "127.0.0.1"; // depends on the context
            String port = "3306"; // default MySQL port

            // Connection string
            String connectionString = protocol + "//" + ip + ":" + port;

            // Connection credentials
            String username = "root"; // depends on the context
            String password = "1234"; // depends on the context

            // Establish connection
            Connection connection = DriverManager.getConnection(connectionString, username, password);

            // Execute the SQL query to drop the database
            Statement statement = connection.createStatement();
            System.out.println("\nDropping the database...");
            statement.executeUpdate("DROP DATABASE IF EXISTS Mini_Projet");
            System.out.println("Database Mini_Projet dropped successfully...\n\n");

            // Close the connection
            connection.close();
        } catch (Exception e) {
            // Handle exceptions
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new DeleteDB();
    }
}
