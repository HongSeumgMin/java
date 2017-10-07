package chatting_server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

//���� ����
public class Server {
	private ArrayList<Client> clientList;
	private ServerSocket servSock;
	
	public Server() {
		clientList = new ArrayList<Client>();
		try {
			servSock = new ServerSocket(7979);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void gogogogo(){
		Client client;
		System.out.println("ä�����α׷��� �����մϴ�.");
		
		while(true){
			try {
				client = new Client(servSock.accept());
				System.out.println(client+"���� �����Ͽ����ϴ�.");
				
				clientList.add(client);
				new Process(clientList,client).start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new Server().gogogogo();
	}

}
