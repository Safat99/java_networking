package simple_client_server_without_thread;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(22222);
        System.out.println("Server started");

        while (true) {
            Socket socket = serverSocket.accept(); // server will be turned on always and wait for the client to be connected.
            System.out.println("Client connected"); // if client connect then a server will get back a socket.

            // new Server Thread Start....
            new ServerThread(socket);
        }
    }
}

class ServerThread implements Runnable {

    Socket clientSocket;
    Thread t;

    ServerThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        try {

            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());

            while (true) {
                // read from client
                Object cMsg = ois.readObject();
                if (cMsg == null) // null means there is no binding with any client.
                    break;
                System.out.println("From client: " + (String) cMsg);

                // upper case the client message
                String serverMsg = (String) cMsg;
                serverMsg = serverMsg.toUpperCase();

                // send to client
                oos.writeObject(serverMsg);
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
//            throw new RuntimeException(e);
        }

        try {
            clientSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}