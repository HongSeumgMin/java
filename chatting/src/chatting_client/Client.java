package chatting_client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	private Socket sock;

	public Client() {
		try {
			sock = new Socket("211.199.232.224", 7979);
		} catch (UnknownHostException e) {
			System.out.println("������ �� �����ϴ�.(���� ����ȵ�)");
		} catch (IOException e) {
			System.out.println("������ �� �����ϴ�.(���� ����)");
		}
	}
	
	private void gogogo(){
		Receiver rv = new Receiver(sock);
		Sender sd = new Sender(sock);
		
		rv.start();
		sd.start();
	}

	public static void main(String[] args) {
		new Client().gogogo();		
	}

}
