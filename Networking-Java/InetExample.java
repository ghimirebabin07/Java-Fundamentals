import java.net.*;

public class InetExample {
    public static void main(String[] args) throws Exception {
        InetAddress ip = InetAddress.getLocalHost();
        System.out.println("IP Address: " + ip);
    }
}
