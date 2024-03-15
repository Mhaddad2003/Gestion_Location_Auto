
package gestion_location_auto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;

public class CreateTables {
    
    public CreateTables() {

        String connectionUrl = "jdbc:mysql://localhost:3306/location_auto";

        try (Connection conn = DriverManager.getConnection(connectionUrl, "root", "1234")) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Statement smt = conn.createStatement();

            System.out.println("[INFO] Creating Tables ...");
            smt.executeUpdate(readSQLFromFile("sql\\CreateClient.sql"));
            smt.executeUpdate(readSQLFromFile("sql\\CreateVoiture.sql"));
            smt.executeUpdate(readSQLFromFile("sql\\CreateReservation.sql"));
            System.out.println("[INFO] Tables created successfully");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public String readSQLFromFile(String path) {
        String sql = "";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            StringBuilder sqlBuilder = new StringBuilder(); 
            String line;
            while ((line = br.readLine()) != null)
                sqlBuilder.append(line).append("\n"); 
            sql = sqlBuilder.toString(); 
        } catch(Exception e) {
            
        }
        
        return sql;  
         
    }
}
