package chatProgram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReadNextLineTraad extends Thread{
	String modifiedSentence;
	Socket connSocket;

	public ReadNextLineTraad(Socket connSocket) {
		this.connSocket = connSocket;
	}
	
	public void run() {
		try {
			BufferedReader inFromServer = new BufferedReader(new InputStreamReader(connSocket.getInputStream()));
			while (true) {
				modifiedSentence = inFromServer.readLine();
				if (modifiedSentence.toLowerCase().equals("server.exit")) {
					connSocket.close();
					System.out.println("Serveren blev closet.");
					Server_chat_v2.status = false;
					return;
				}
				System.out.println("FROM USER: " + modifiedSentence);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Clienten fuckede up!");
			Server_chat_v2.status = false;
			return;
		}
		
	}

}
