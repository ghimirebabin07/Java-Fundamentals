package Data_Base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.io.Console;

public class DatabaseConnection {

    public static Connection getConnection() {
        Connection con = null;

        try {
            Console console = System.console();

            if (console == null) {
                System.out.println("Run this from terminal, not IDE Run button");
                return null;
            }

            String user = console.readLine("Enter DB Username: ");
            char[] passwordArray = console.readPassword("Enter DB Password: ");
            String password = new String(passwordArray);

            Class.forName("org.postgresql.Driver");

            con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/college_db",
                user,
                password
            );

            System.out.println(" Database connected successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }

    // MAIN METHOD (this fixes your error)
    public static void main(String[] args) {
        getConnection();
    }
}
