package Threading;

class NewThread implements Runnable {

    Thread t;
    int threadNo;

    NewThread(int threadNo){
        t = new Thread(this, "Runnable Thread");
        this.threadNo = threadNo;
        t.start();
    }

    @Override
    public void run() {
        for (int n=10; n>0; n--) {
            System.out.println( threadNo + "-Child Thread: " + n);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Child thread interrupted");
                throw new RuntimeException(e);
            }
        }
        System.out.println("Exiting child thread...");
    }
}


public class RunnableThread {
    public static void main(String[] args) {
        System.out.println("main thread started...");
        NewThread obj1 = new NewThread(1);
        NewThread obj2 = new NewThread(2);
        System.out.println("Thread 1 is alive: " + obj1.t.isAlive());
        System.out.println("Thread 2 is alive: " + obj2.t.isAlive());

        try {
            obj1.t.join();
            obj2.t.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Main thread exited...");
        System.out.println("Thread 1 is alive: " + obj1.t.isAlive());
        System.out.println("Thread 2 is alive: " + obj2.t.isAlive());

    }
}
