package co.d1egoprog.examples.sockets;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ProtocolBasic {

	final int PUERTO=5000;
	ServerSocket sc;
	Socket so;
	DataOutputStream remoteStream;
	String messageRecived;
	public ProtocolBasic(){
		BufferedReader entrada;
		try{
			sc = new ServerSocket(PUERTO);
			so=new Socket();
			System.out.println("Waiting for a connection: ");
			so = sc.accept();
			System.out.println("A client has been connected to the server. ");
			entrada = new BufferedReader(new InputStreamReader(so.getInputStream()));
			remoteStream = new DataOutputStream(so.getOutputStream());
			System.out.println("Expecting response for the client application");
			remoteStream.writeUTF("You have connected to the XXX Server, Please press any key to continue \n");
			messageRecived = entrada.readLine();
			System.out.println(messageRecived);
			remoteStream.writeUTF("\n Message was recived, clossing connection, thanks for using our services... ");
			System.out.println("Clossing connection... ");
			sc.close();
		}catch(Exception e ){
			System.out.println("Error: "+e.getMessage());
		}
	}
	public static void main(String[] args) {
		ProtocolBasic protocolo = new ProtocolBasic(); 
	}
	
}
