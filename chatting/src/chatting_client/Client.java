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
			System.out.println("접속할 수 없습니다.(서버 실행안됨)");
		} catch (IOException e) {
			System.out.println("접속할 수 없습니다.(연결 오류)");
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
