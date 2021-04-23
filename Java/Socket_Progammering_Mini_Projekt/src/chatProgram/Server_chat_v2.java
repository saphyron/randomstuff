package chatProgram;

import java.net.ServerSocket;
import java.net.Socket;

public class Server_chat_v2 {
	
	private static Socket connectionSocket;
	private static ServerSocket welcomSocket;
	public static boolean status = true;

	public static void main(String[] args) throws Exception {
		System.out.println("Welcome to TCP Chat Server");
		welcomSocket = new ServerSocket(9002);
		
		while (true) {
			connectionSocket = welcomSocket.accept();
			WriteNextLineTraad writeTraad = new WriteNextLineTraad(connectionSocket);
			ReadNextLineTraad readTraad = new ReadNextLineTraad(connectionSocket);
			readTraad.start();
			writeTraad.start();
			while(status) {
				Thread.sleep(10);
			}
			System.out.println("Programmet er lukket");
		}
	}
}
