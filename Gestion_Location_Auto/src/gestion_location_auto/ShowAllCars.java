package gestion_location_auto;
import com.mysql.jdbc.Driver.*;
import java.sql.* ;

public class ShowAllCars {
    public ShowAllCars() {
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

            // Connect to the database
            Connection connection = DriverManager.getConnection(conString, nomConnexion, motDePasse);

            // Prepare SQL query to fetch all cars
            String query = "SELECT * FROM voiture";

            // Create a PreparedStatement
            PreparedStatement pstmt = connection.prepareStatement(query);

            // Execute the query
            ResultSet rs = pstmt.executeQuery();

            // Display all cars
            System.out.println("List of all cars:");

            while (rs.next()) {
                String matricule = rs.getString("Matricule");
                int module = rs.getInt("Module");
                String marque = rs.getString("Marque");
                double prix = rs.getDouble("Prix");
                String couleur = rs.getString("Couleur");
                boolean disponibilite = rs.getBoolean("Disponibilite");

                System.out.println("Matricule: " + matricule + ", Module: " + module + ", Marque: " + marque +
                                   ", Prix: " + prix + ", Couleur: " + couleur + ", Disponibilité: " + (disponibilite ? "Disponible" : "Non disponible"));
            }

            // Close the connection
            connection.close();
        } catch (Exception e) {
            // Exception handling
            System.out.println(e);
        }
    }
}
