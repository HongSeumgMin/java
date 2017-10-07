package chatting_server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

//서버 구동
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
		System.out.println("채팅프로그램을 시작합니다.");
		
		while(true){
			try {
				client = new Client(servSock.accept());
				System.out.println(client+"님이 접속하였습니다.");
				
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
