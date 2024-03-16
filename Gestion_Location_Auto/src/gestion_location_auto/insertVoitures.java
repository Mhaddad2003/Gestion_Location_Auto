package gestion_location_auto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;

public class insertVoitures {
    
    public insertVoitures() {

        String connectionUrl = "jdbc:mysql://localhost:3306/Mini_Projet";

        try (Connection conn = DriverManager.getConnection(connectionUrl, "root", "1234")) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Statement smt = conn.createStatement();
 
            BufferedReader br = new BufferedReader(new FileReader("sql\\InsertV.sql"));
            StringBuilder sqlBuilder = new StringBuilder(); 
            String line;
            while ((line = br.readLine()) != null)
                sqlBuilder.append(line).append("\n"); 
            String sql = sqlBuilder.toString();
            
            br.close();
            System.out.println("[INFO] Inserting Data ...");
            smt.executeUpdate(sql);
            System.out.println("[INFO] Data inserted successfully");
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
