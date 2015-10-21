package ChatServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import ChatClient.ChatClientInterface;

public class ChatServer extends UnicastRemoteObject implements ChatServerInterface{
	private static final long serialVersionUID = 1L;
	private ArrayList<ChatClientInterface> chatClient;
	
	protected ChatServer() throws RemoteException {
		super();
		chatClient = new ArrayList<ChatClientInterface>();
	}

	public void registerChatClient(ChatClientInterface chatClient)
			throws RemoteException {
		this.chatClient.add(chatClient);
	}

	public void broadcastMessage(String message) throws RemoteException {
		int i = 0;
		while (i < chatClient.size()) {
			chatClient.get(i++).retrieveMessage(message);
		}
	}
}
