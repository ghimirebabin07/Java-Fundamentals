package Data_Base;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    public static Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("org.postgresql.Driver");

            con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/college_db",
                "postgres",
                "Babin123" 
            );

            System.out.println("Database connected successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}
