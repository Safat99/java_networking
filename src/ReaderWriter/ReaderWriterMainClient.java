package ReaderWriter;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ReaderWriterMainClient {
    public static void main(String[] args) throws IOException {
        System.out.println("client started..");
        Socket socket = new Socket("127.0.0.1", 22222);
        System.out.println("client connected..");

        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

        new ReaderThread(ois, "client1");
        new WriterThread(oos, "client1");
//        socket.close();
    }
}
