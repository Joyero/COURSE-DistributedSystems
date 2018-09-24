import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteInterface extends Remote {
    String welcomeMessage() throws RemoteException;
	String service(Integer a) throws RemoteException;
	String goodByeMessage() throws RemoteException;
}