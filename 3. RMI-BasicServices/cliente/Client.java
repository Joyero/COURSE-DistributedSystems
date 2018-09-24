import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {

    private Client() {}

    public static void main(String[] args) {

        String host = (args.length < 1) ? null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            RemoteInterface stub = (RemoteInterface) registry.lookup("RemoteInterface");
            String response = stub.welcomeMessage();
            System.out.println(response);
			System.out.println("Enter an hour from 1 to 24");
			Scanner sc = new Scanner(System.in);
			Integer a = sc.nextInt();
			response = stub.service(a);
            System.out.println(response);
			response = stub.goodByeMessage();
            System.out.println(response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}