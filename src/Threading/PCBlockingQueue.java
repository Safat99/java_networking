package Threading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// Producer-consumer blocking queue
public class PCBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<String> q = new ArrayBlockingQueue<>(4);
        Producer producer1 = new Producer(q, "Producer1");
    }

}
