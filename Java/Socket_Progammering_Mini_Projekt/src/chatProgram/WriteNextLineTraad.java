package chatProgram;

import java.net.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.net.Socket;

public class WriteNextLineTraad extends Thread{
	String sentence;
	Socket connSocket;

	public WriteNextLineTraad(Socket connSocket) {
		this.connSocket = connSocket;
	}

	public void run() {
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		DataOutputStream outToServer;
		try {
			outToServer = new DataOutputStream(connSocket.getOutputStream());
			while (true) {

				sentence = inFromUser.readLine();
				System.out.println("FROM USER: " + sentence);
				
				outToServer.writeBytes(sentence + '\n');
				if(sentence.toLowerCase().equals("server.exit")) {
					connSocket.close();
					System.out.println("Du closede serveren.");
					Server_chat_v2.status = false;
					return;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
