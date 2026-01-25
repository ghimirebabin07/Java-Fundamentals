package RMI_Application;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException; 
public class AdderImpl extends UnicastRemoteObject implements Adder {
    public AdderImpl() throws RemoteException {
        super();
    }
    public int add(int x, int y) throws RemoteException {
        return x + y;
    }
}
