package chatProgram;

import java.io.IOException;
import java.net.Socket;

public class Client_Chat_v2 {

	public static void main(String[] args) throws Exception, IOException {
		//connect til dns
		Socket clientSocket = new Socket("10.24.74.203", 6789);
		WriteNextLineTraad writeTraad = new WriteNextLineTraad(clientSocket);
		ReadNextLineTraad readTraad = new ReadNextLineTraad(clientSocket);
		readTraad.start();
		writeTraad.start();
	}

}
