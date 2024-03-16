package gestion_location_auto;

import java.sql.*;
import java.util.Scanner;

public class LogIn {
    
    private int valid;
    
    public LogIn() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connection protocol
            String protocol = "jdbc:mysql:";
            String ip = "127.0.0.1";  // depends on the context
            String port = "3306";  // default MySQL port
            // Connection string
            String conString = protocol + "//" + ip + ":" + port + "/Mini_projet";
            // Connection credentials
            String nomConnexion = "root";  // depends on the context
            String motDePasse = "1234";  // depends on the context
            // Connection
            Connection conct = DriverManager.getConnection(conString, nomConnexion, motDePasse);

            Scanner scanner = new Scanner(System.in);
            int option = 0;
            boolean validOption = false;

            // Loop until a valid option is chosen
            while (!validOption) {
                System.out.println("Choose an option:");
                System.out.println("1. Log in");
                System.out.println("2. Sign up");

                // Validate the input
                if (scanner.hasNextInt()) {
                    option = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    if (option == 1 || option == 2) {
                        validOption = true;
                    } else {
                        System.out.println("Invalid option. Please choose 1 or 2.");
                    }
                } else {
                    System.out.println("Invalid option. Please choose 1 or 2.");
                    scanner.nextLine(); // Consume invalid input
                }
            }

            if (option == 1) { // Log in
                System.out.println("Enter CIN:");
                String cin = scanner.nextLine();
                System.out.println("Enter password:");
                String password = scanner.nextLine();

                // Check if the client exists
                PreparedStatement checkStatement = conct.prepareStatement("SELECT * FROM client WHERE CIN = ? AND password = ?");
                checkStatement.setString(1, cin);
                checkStatement.setString(2, password);
                ResultSet resultSet = checkStatement.executeQuery();

                if (resultSet.next()) {
                    System.out.println("Logged in successfully!");
                } else {
                    System.out.println("Invalid CIN or password. Please try again.");
                }

            } else if (option == 2) { // Sign up
                System.out.println("Enter CIN:");
                String cin = scanner.nextLine();
                System.out.println("Enter password:");
                String password = scanner.nextLine();
                System.out.println("Confirm password:");
                String confirmPassword = scanner.nextLine();

                // Check if the CIN already exists in the database
                PreparedStatement checkCINStatement = conct.prepareStatement("SELECT * FROM client WHERE CIN = ?");
                checkCINStatement.setString(1, cin);
                ResultSet cinResultSet = checkCINStatement.executeQuery();

                if (cinResultSet.next()) {
                    System.out.println("This CIN already exists. Please log in instead.");
                } else {
                    if (password.equals(confirmPassword)) {
                        // Insert the new client into the database with default values for other attributes
                        PreparedStatement insertStatement = conct.prepareStatement("INSERT INTO client (CIN, password, nom, prenom, tel, Permis) VALUES (?, ?, 'default_nom', 'default_prenom', 'default_tel', 'default_permis')");
                        insertStatement.setString(1, cin);
                        insertStatement.setString(2, password);
                        insertStatement.executeUpdate();

                        System.out.println("Sign up successful! You can now log in.");
                    } else {
                        System.out.println("Passwords do not match. Sign up failed.");
                    }
                }
            }

            // Close the connection
            conct.close();
        } catch (ClassNotFoundException | SQLException e) {
            // Exception handling
            System.out.println(e);
        }
    }
}
