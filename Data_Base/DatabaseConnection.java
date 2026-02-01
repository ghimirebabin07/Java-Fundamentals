package Data_Base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.io.Console;

public class DatabaseConnection {

    public static Connection getConnection() throws Exception {

        Console console = System.console();
        if (console == null) {
            throw new Exception("Run this program from terminal, not IDE");
        }

        String user = console.readLine("Enter DB Username: ");
        char[] passwordArray = console.readPassword("Enter DB Password: ");
        String password = new String(passwordArray);

        Class.forName("org.postgresql.Driver");

        return DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/college_db",
            user,
            password
        );
    }

    public static void main(String[] args) throws Exception {
        getConnection();
        System.out.println("Database connected successfully");
    }
}
