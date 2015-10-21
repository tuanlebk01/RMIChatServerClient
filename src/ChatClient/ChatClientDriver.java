package ChatClient;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import ChatServer.ChatServer;
import ChatServer.ChatServerInterface;

public class ChatClientDriver {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException{
		String chatServerURL = "rmi://localhost/RMIChatServer";
		ChatServerInterface chatServer = (ChatServerInterface) Naming.lookup(chatServerURL);
		new Thread((Runnable) new ChatClient(args[0], chatServer)).start();
	}

}
