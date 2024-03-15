package gestion_location_auto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;


public class CreateDB {

    public CreateDB() {
               String connectionUrl = "jdbc:mysql://localhost:3306";

        try (Connection conn = DriverManager.getConnection(connectionUrl, "root", "1234")) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Statement smt = conn.createStatement();
            
            BufferedReader br = new BufferedReader(new FileReader("sql\\CreateDB.sql"));
            StringBuilder sqlBuilder = new StringBuilder(); 
            String line;
            while ((line = br.readLine()) != null)
                sqlBuilder.append(line).append("\n");
            String sql = sqlBuilder.toString();
            
        
            System.out.println("[INFO] Creating DataBase ...");
            smt.executeUpdate(sql);
            System.out.println("[INFO] DataBase created successfully");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
