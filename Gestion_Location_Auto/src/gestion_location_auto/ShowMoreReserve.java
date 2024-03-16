package gestion_location_auto;
import java.sql.* ;

public class ShowMoreReserve {
    public ShowMoreReserve () {
        try {
            // Charger le pilote JDBC pour MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Protocole de connexion
            String protocole = "jdbc:mysql:";
            String ip = "127.0.0.1";  // dépend du contexte
            String port = "3306";  // port MySQL par défaut

            // Chaîne de connexion
            String conString = protocole + "//" + ip + ":" + port;

            // Identifiants de connexion et mot de passe
            String nomConnexion = "root";  // dépend du contexte
            String motDePasse = "Ana@mohamed2003";  // dépend du contexte

            // Connexion à la base de données
            Connection conct = DriverManager.getConnection(
                    conString, nomConnexion, motDePasse
            );

            // Préparation de la requête SQL pour trouver les voitures les plus réservées
            String query = "SELECT Matricule, COUNT(*) AS reservation_count FROM Reservation GROUP BY Matricule ORDER BY reservation_count DESC LIMIT 10";

            // Création de la déclaration PreparedStatement
            PreparedStatement pstmt = conct.prepareStatement(query);

            // Exécution de la requête
            ResultSet rs = pstmt.executeQuery();

            // Affichage des voitures les plus réservées
            System.out.println("Les voitures les plus réservées:");

            while (rs.next()) {
                String matricule = rs.getString("Matricule");
                int reservationCount = rs.getInt("reservation_count");
                System.out.println("Matricule: " + matricule + ", Nombre de réservations: " + reservationCount);
            }

            // Fermeture de la connexion
            conct.close();
        } catch (Exception e) {
            // Gestion des exceptions
            System.out.println(e);
        }
    }
}
