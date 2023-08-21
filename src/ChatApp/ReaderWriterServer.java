package ChatApp;

import java.util.HashMap;

public class ReaderWriterServer implements Runnable{

    String username;
    NetworkConnection nc;
    HashMap<String, Information> clientList;

    public ReaderWriterServer(String username, NetworkConnection nc, HashMap<String, Information> clientList) {
        this.username = username;
        this.nc = nc;
        this.clientList = clientList;
    }

    @Override
    public void run() {
        Object obj = nc.read();
        Data dataObj = (Data)obj;
        String actualMessage = dataObj.message;
        System.out.println(actualMessage);

        if (actualMessage.toLowerCase().contains("list")) {
            System.out.println("list asked..." + actualMessage);
            String words[] = actualMessage.split("$");
        }

    }
}
