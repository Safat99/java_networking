package Threading;

public class MainThread {
    public static void main(String[] args) {

        Thread t = Thread.currentThread();
        System.out.println("current thread: " + t);

        t.setName("my custom main thread");
        System.out.println("After changing name: " + t);

        for (int n=10; n>0; n--) {
            System.out.println(n);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted");
                throw new RuntimeException(e);
            }
        }
    }
}
