package chatProgram;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client_Chat_v1 {

	public static void main(String[] args) throws Exception, IOException {

		String sentence;
		String modifiedSentence;
		String line;

		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

		Socket clientSocket = new Socket("10.24.74.203", 6789);
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		while (true) {
			sentence = inFromUser.readLine();
			outToServer.writeBytes(sentence + '\n');
			modifiedSentence = inFromServer.readLine();
			System.out.println("FROM SERVER: " + modifiedSentence);
		}

	}

}
