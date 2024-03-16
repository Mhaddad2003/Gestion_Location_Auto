package gestion_location_auto;
import java.io.*;
import java.sql.*;
import com.mysql.jdbc.Driver;

public class PlusCher {
    public PlusCher() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connection protocol
            String protocol = "jdbc:mysql:";
            String ip = "127.0.0.1";  // depends on the context
            String port = "3306";  // default MySQL port
            // Connection string
            String conString = protocol + "//" + ip + ":" + port + "/Mini_Projet";
            // Connection credentials
            String nomConnexion = "root";  // depends on the context
            String motDePasse = "1234";  // depends on the context
            // Connection
            Connection conct = DriverManager.getConnection(
                    conString, nomConnexion, motDePasse);

            // Execute the query to fetch the most expensive cars
            Statement stmt = conct.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM voiture WHERE Disponibilite = true ORDER BY Prix DESC");

            // Display the most expensive cars
            System.out.println("\nLes voitures les plus chères :");
            while (rs.next()) {
                System.out.println("Matricule : " + rs.getString("Matricule"));
                System.out.println("Modèle : " + rs.getString("Module"));
                System.out.println("Marque : " + rs.getString("Marque"));
                System.out.println("Prix : " + rs.getInt("Prix"));
                System.out.println("Couleur : " + rs.getString("Couleur"));
                System.out.println("-----------------------------------");
            }

            // Close connections
            rs.close();
            stmt.close();
            conct.close();

        } catch (Exception e) {
            // Exception handling
            System.out.println(e);
        }
    }
}
