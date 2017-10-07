package chatting_client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Receiver extends Thread {
	private Socket sock;
	private DataInputStream in;
	
	public Receiver(Socket sock) {
		this.sock = sock;
		try {
			in = new DataInputStream(sock.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run(){
		String msg=null;
		while(true){
			try {
				msg = in.readUTF();
			} catch (IOException e) {
				break;
			}
			System.out.println(msg);
		}
	}
}
