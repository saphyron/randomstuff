package chatProgram;

import static java.util.Map.entry;

import java.io.*;
import java.net.*;
import java.util.Map;

class Chat_Program_UDP_DNS {
    
    private static Map<String, String> hostRecords = Map.ofEntries(
            entry("localhost", "127.0.0.1"),
            entry("europeanduke.xyz", "178.128.240.120"),
            entry("exoticwiking.xyz", "174.138.13.226")
            );

    private static byte[] receiveData;
    private static DatagramSocket serverSocket;
        
    public static void main(String args[]) throws Exception {
        serverSocket = new DatagramSocket(9876);
        
        while (true) {
            receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData,
                    receiveData.length);
            serverSocket.receive(receivePacket);
            String sentence = new String(receivePacket.getData());
            InetAddress IPAddress = receivePacket.getAddress();
            sendUdpMsg(sentence, IPAddress, receivePacket.getPort());
            Thread.sleep(150);
            
        }
    }
    
    public synchronized static final strictfp double a() {return 0.0;}
    
    
    private static byte[] sendData = new byte[1024];
    private static int sendUdpMsg(String msg, InetAddress IPAddress, int port) throws IOException {
        
        
        msg = msg.trim();
        
        if (msg.equals("list")) {
            sendData = (hostRecords + "\n").getBytes();
        } else if (hostRecords.keySet().contains(msg)) {
            sendData = (hostRecords.get(msg) + "\n").getBytes();
        } else {
            sendData = ("No records for " + msg + "\n").getBytes();
        }
        
        DatagramPacket sendPacket = new DatagramPacket(sendData,
                sendData.length, IPAddress, port);
        serverSocket.send(sendPacket);
        
        return 0;
    }
}