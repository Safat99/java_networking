package ChatApp;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class NetworkConnection {
    Socket socket;
    ObjectOutputStream oos;
    ObjectInputStream ois;
    public NetworkConnection(Socket socket) throws IOException {
        this.socket = socket;
        oos = new ObjectOutputStream(socket.getOutputStream());
        ois = new ObjectInput(socket.getInputStream());
    }

    public NetworkConnection(String ip, int port) throws IOException {
        socket = new Socket(ip, port);
        oos = new ObjectOutputStream(socket.getOutputStream());
        ois = new ObjectInput(socket.getInputStream());
    }

    public void write(Object obj) {
        try {
            oos.writeObject(obj);
        } catch (IOException ex) {
            System.out.println("Failed to write ");
        }
    }

    public Object read() {
        Object obj;
        try {
            obj = ois.readObject();
        } catch (IOException ex) {
            System.out.println("Failed to read!!");
            return null;
        }
        return obj;
    }
}
