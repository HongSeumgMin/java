package chatting_client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Sender extends Thread{
	private DataOutputStream out;
	private Socket sock;
	
	public Sender(Socket sock) {
		this.sock = sock;
		try {
			out = new DataOutputStream(sock.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run(){
		String msg;
		Scanner scan = new Scanner(System.in);
		while(true){
			msg = scan.nextLine();
			try {
				out.writeUTF(msg);
			} catch (IOException e) {
				break;
			}
		}
	}
}
