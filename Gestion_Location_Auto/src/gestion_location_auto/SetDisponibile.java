package gestion_location_auto;
import java.sql.* ;

public class SetDisponibile {
    public SetDisponibile(){
        try {
            // Charger le pilote JDBC pour MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Protocole de connexion
            String protocole =  "jdbc:mysql:" ;
            String ip =  "127.0.0.1" ;  // dépend du contexte
            String port =  "3306" ;  // port MySQL par défaut

            // Chaîne de connexion
            String conString = protocole +  "//" + ip +  ":" + port ;
            
            // Identifiants de connexion et mot de passe
            String nomConnexion =  "root" ;  // dépend du contexte
            String motDePasse =  "Ana@mohamed2003" ;  // dépend du contexte

            // Connexion à la base de données
            Connection conct = DriverManager.getConnection(
                conString, nomConnexion, motDePasse
            );

            // Obtention de la date actuelle
            java.util.Date currentDate = new java.util.Date();
            java.sql.Date sqlCurrentDate = new java.sql.Date(currentDate.getTime());

            // Préparation de la requête SQL pour mettre à jour la disponibilité
            String updateQuery = "UPDATE Reservation SET disponibile = false WHERE DateF < ?";

            // Création de la déclaration PreparedStatement
            PreparedStatement pstmt = conct.prepareStatement(updateQuery);
            pstmt.setDate(1, sqlCurrentDate);

            // Exécution de la mise à jour
            int rowsUpdated = pstmt.executeUpdate();

            // Affichage du nombre de lignes mises à jour
            System.out.println(rowsUpdated + " lignes mises à jour.");

            // Fermeture de la connexion
            conct.close();
        } catch (Exception e) {
            // Gestion des exceptions
            System.out.println(e);
        }
    }
}
