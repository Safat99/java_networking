package ChatApp;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;

public class ServerMain {
    public static void main(String[] args) throws UnknownHostException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server has started...");
        System.out.println(InetAddress.getLocalHost());
        HashMap<String, Information> clientList = new HashMap<>();

        while (true) {
            Socket socket = serverSocket.accept();
            NetworkConnection nc = new NetworkConnection(socket);

            new Thread(new CreateConnection(clientList, nc)).start();
        }


    }
}
