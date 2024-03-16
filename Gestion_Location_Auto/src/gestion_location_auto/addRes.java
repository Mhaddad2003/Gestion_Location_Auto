package gestion_location_auto;

import java.sql.*;
import java.util.Scanner;

public class addRes {
    
    private String cin;
    
    
    public addRes() {
        
        Scanner in = new Scanner(System.in,"UTF-8");    
        String connectionUrl = "jdbc:mysql://localhost:3306/location_auto";

        try (Connection conn = DriverManager.getConnection(connectionUrl, "root", "1234")) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Statement smt = conn.createStatement() ;

            System.out.print("Enter your CIN");
            cin = in.next();

            String sql = "SELECT CIN FROM client";
            ResultSet res = smt.executeQuery(sql);
            
            while (res.next()) {
               if (cin.equals(res.getString("CIN"))) {
                   sql = "SELECT nom FROM client WHERE CIN = " + cin;
                   ResultSet rest = smt.executeQuery(sql);
                   String nom = rest.getString("nom");
                   
                   if(nom.equals("default_nom")) {
                      sql = "INSERT INTO client (nom, prenom, tel, Permis) VALUES (?, ?, ?, ?)";
                      PreparedStatement pstmt = conn.prepareStatement(sql);
                      System.out.print("Nom: ");
                      pstmt.setString(1, in.next());                  
                      System.out.print("\n");
                      System.out.print("Prenom: ");
                      pstmt.setString(2, in.next());
                      System.out.print("\n");
                      System.out.print("Tel: ");
                      pstmt.setString(3, in.next());
                      System.out.print("\n");
                      System.out.print("Permis: ");
                      pstmt.setString(4, in.next());                                                                             
                   }
                   sql = "INSERT INTO Reservation (DateD, DateF, CIN) VALUES (?, ?, ?)";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    java.util.Date dateD = new java.util.Date();
                    pstmt.setDate(1, (Date) dateD);
                    System.out.print("Date de Fin: ");
                    pstmt.setString(2, in.next());                  
                    System.out.print("\n");                   
                    pstmt.setString(3, cin);
    
               }
            }
            System.out.println("[INFO] Reservation Done!");
        } catch (Exception e) {
            System.out.println(e);
        }       
    }
}
