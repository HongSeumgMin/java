package chatting_server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

//Á¢¼ÓÀÚ
public class Client {
	private static int cnt = 1;

	private String name;
	private Socket sock;
	private DataInputStream in;
	private DataOutputStream out;

	public Client(Socket sock) {
		this.sock = sock;
		this.name = "¼Õ´Ô"+cnt;
		cnt++;
		
		try {
			in = new DataInputStream(sock.getInputStream());
			out = new DataOutputStream(sock.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getName(){
		return name;
	}

	public DataInputStream getInStream() {
		return in;
	}

	public DataOutputStream getOutStream() {
		return out;
	}
	
	@Override
	public String toString(){
		return name;
	}
	
	public boolean equals(Client client){
		if(client.getName()==this.name)
			return true;
		else
			return false;
	}
}
