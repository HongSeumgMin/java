package chatting_server;

import java.io.IOException;
import java.util.ArrayList;

public class Process extends Thread {
	private ArrayList<Client> clientList;
	private Client client;
	private String msg = null;

	public Process(ArrayList<Client> clientList, Client client) {
		this.client = client;
		this.clientList = clientList;
	}

	@Override
	public void run() {
		String[] token;

		msg = client + "���� �����Ͽ����ϴ�.";
		sendAll();

		while (true) {
			try {
				msg = client.getInStream().readUTF();
			} catch (IOException e) {
				close();
				break;
			}

			token = msg.split(" ", 3);

			if (token[0].equals("/m")){
				msg = token[2];
				sendWhisper(token[1]);
			}
			else
				sendAll();
		}
	}

	private void sendAll() {
		for (Client i : clientList) {
			try {
				i.getOutStream().writeUTF("[" + client.getName() + "]" + msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void sendWhisper(String to) {

		for (Client i : clientList) {
			if (i.getName().equals(to))
				try {
					i.getOutStream().writeUTF("[" + client.getName() + "]" + msg);
					return;
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

		try {
			client.getOutStream().writeUTF("[" + to + "���� �������� �ʽ��ϴ�.]");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void close() {
		for (int i = 0; i < clientList.size(); i++) {
			if (clientList.get(i).equals(client)) {
				clientList.remove(i);
				break;
			}
		}
		System.out.println(client + "���� �����Ͽ����ϴ�.");
		msg = "����!!!";
		sendAll();
	}
}
