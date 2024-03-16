
package gestion_location_auto;

import java.sql.*;
import java.util.Scanner;


public class ajouterV {
    
    private String matricule, marque, module, couleur;
    private float prix;
    
    public ajouterV() {

        String connectionUrl = "jdbc:mysql://localhost:3306/location_auto";
        Scanner in = new Scanner(System.in,"UTF-8");

        try (Connection conn = DriverManager.getConnection(connectionUrl, "root", "1234")) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Statement smt = conn.createStatement();

            System.out.print("Matricule: ");
            matricule = in.next();
            System.out.print("\n");
            System.out.print("Marque: ");
            marque = in.next();
            System.out.print("\n");
            System.out.print("Module: ");
            module = in.next();
            System.out.print("\n");
            System.out.print("Couleur: ");
            couleur = in.next();
            System.out.print("\n");            
            System.out.print("Prix: ");
            prix = in.nextFloat();
            System.out.print("\n");            
            
            String sql = "INSERT INTO voiture (Matricule, Marque, Module, Couleur, Prix, Disponibilite) VALUES (?, ?, ?, ?, ?, true)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, matricule);
            pstmt.setString(2, marque);
            pstmt.setString(3, module);
            pstmt.setString(4, couleur);
            pstmt.setFloat(5, prix);
            
            pstmt.executeUpdate();
            System.out.println("[INFO] Car added successfully");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
