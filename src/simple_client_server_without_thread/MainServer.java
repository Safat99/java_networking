package simple_client_server_without_thread;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(22222);
        System.out.println("Server started");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            try {
                // read from client
                Object cMsg = ois.readObject();
                System.out.println("From client: " + (String) cMsg);

                // upper case the client message
                String serverMsg = (String) cMsg;
                serverMsg = serverMsg.toUpperCase();

                // send to client
                oos.writeObject(serverMsg);

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
//            throw new RuntimeException(e);
            }
        }
    }
}
