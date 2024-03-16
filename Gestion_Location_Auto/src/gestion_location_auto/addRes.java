package gestion_location_auto;

import java.sql.*;
import java.util.Scanner;

public class addRes {
    
    private String cin;
    
    
    public addRes() {
        
        Scanner in = new Scanner(System.in,"UTF-8");    
        String connectionUrl = "jdbc:mysql://localhost:3306/Mini_Projet";

        try (Connection conn = DriverManager.getConnection(connectionUrl, "root", "1234")) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Statement smt = conn.createStatement() ;
            
            System.out.print("Enter your CIN ");
            cin = in.next();

            String sql = "SELECT CIN, nom FROM client";
            ResultSet res = smt.executeQuery(sql);
            
            
            while (res.next()) {
               if (cin.equals(res.getString("CIN"))) {                   
                   if(res.getString("nom").equals("default_nom")) {
                      sql = "UPDATE client SET nom = ?, prenom = ?, tel = ?, Permis = ? WHERE CIN = ?";
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
                      pstmt.setString(5, res.getString("CIN"));  
                      pstmt.executeUpdate();

                   }
                   ShowCarsDisponible cr = new ShowCarsDisponible();                   
                   sql = "INSERT INTO reservation ( Matricule, DaysNumber, CIN) VALUES (?, ?, ?)";
                   PreparedStatement pstmt = conn.prepareStatement(sql);

                   System.out.print("Choose your car matricule: ");
                   pstmt.setString(1, in.next());
//                   int b = 1;
//                   sql = "SELECT Matricule FROM voiture WHERE Disponibilite = true";
//                   ResultSet rs = smt.executeQuery(sql);
//                   do {
//                       System.out.print("Choose your car matricule: ");
//                       String mat = in.next(); 
//                       while (rs.next()) {
//                          if(mat.equals(rs.getString("Matricule"))) {
//                              b = 0;
//                              pstmt.setString(1, mat); 
//                              break;
//                          }
//                       } 
//                    
//                   } while(b == 1);
//                   rs.close();
                    
                    
                    System.out.print("Number of Days: ");
                    pstmt.setString(2, in.next());                  
                    System.out.print("\n");                   
                    pstmt.setString(3, cin);
                    pstmt.executeUpdate();
            
                    System.out.println("[INFO] Reservation Done!");
               }
            }
            res.close();

        } catch (Exception e) {
            System.out.println(e);
        }       
    }
}
