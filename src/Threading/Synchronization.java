package Threading;

class Printer {
//    synchronized void printAssignment(Person p) {
    void printAssignment(Person p) {
        System.out.println(p.name + ": Printing started...");
        for (int i=0; i<p.pages; i++) {
            System.out.println(p.name + "--> page# " + (i+1) + " printed");
        }
        System.out.println(p.name + " Completed...");
    }
}

class Person implements Runnable {

    String name;
    final Printer printer; // need to make final if we use synchronized block
    int pages;
    Thread t;

    Person(String name, Printer printer, int pages) {
        this.name = name;
        this.printer = printer;
        this.pages = pages;
        t = new Thread(this);
        t.start();
    }


    @Override
    public void run() {
//        printer.printAssignment(this);
        synchronized (printer) {
            printer.printAssignment(this);
        }
    }
}

public class Synchronization {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Person p1 = new Person("person1", printer, 5);
        Person p2 = new Person("person2", printer, 10);
    }
}
