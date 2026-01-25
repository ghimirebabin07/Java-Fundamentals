package RMI_Application;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) {
        try {
            // Create RMI registry on port 1099
            LocateRegistry.createRegistry(1099);

            // Create remote object
            Adder adder = new AdderImpl();

            // Bind object to registry
            Naming.rebind("rmi://localhost/AdderService", adder);

            System.out.println("Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
