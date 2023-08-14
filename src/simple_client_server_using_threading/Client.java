package simple_client_server_using_threading;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("client started..");
        Socket socket = new Socket("127.0.0.1", 22222);
        System.out.println("client connected..");

        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        while (true) {
            Scanner sc = new Scanner(System.in);

            String message = sc.nextLine();

            if (message.equals("exit"))
                break;
            // sent to server..
            oos.writeObject(message);

            // read from the server
            try {
                Object fromServer = ois.readObject();
                System.out.println("From server: " + (String) fromServer);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        socket.close();
    }
}
