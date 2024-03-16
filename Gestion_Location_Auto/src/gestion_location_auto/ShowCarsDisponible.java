package source_code;
import java.io.* ;
import java.sql.*;
import com.mysql.jdbc.Driver;

/**
 *
 * @author hp
 */
public class ShowCarsDisponible {
    public ShowCarsDisponible(){
        try {
            // chargement de la classe par son nom
            Class.forName("com.mysql.cj.jdbc.Driver") ;
            
            // Protocole de connexion
            String protocole =  "jdbc:mysql:" ;
            String ip =  "127.0.0.1" ;  // depend du contexte
            String port =  "3306" ;  // port MySQL par defaut
            // Chaîne de connexion
            String conString = protocole +  "//" + ip +  ":" + port+"/Mini_Projet" ;
            // Identifiants de connexion et mot de passe
            String nomConnexion =  "root" ;  // depend du contexte
            String motDePasse =  "Ana@mohamed2003" ;  // depend du contexte
            // C. Connexion
            Connection conct = DriverManager.getConnection(
                    conString, nomConnexion, motDePasse) ;

            // D. Executer la requete pour afficher les voitures disponibles
            Statement stmt = conct.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM voiture WHERE Disponibilite = true");

            // E. Afficher les voitures disponibles
            System.out.println("\nVoitures disponibles :");
            while (rs.next()) {
                System.out.println("Matricule : " + rs.getString("Matricule"));
                System.out.println("Modèle : " + rs.getString("Module"));
                System.out.println("Marque : " + rs.getString("Marque"));
                System.out.println("Prix : " + rs.getInt("Prix"));
                System.out.println("Couleur : " + rs.getString("Coleur"));
                System.out.println("-----------------------------------");
            }

            // F. Fermer les connexions
            rs.close();
            stmt.close();
            conct.close();

        } catch (Exception e) {
            // gestion des exceptions
            System.out.println(e);
        }
    }
}
