package task3;

public class Main2 {

    public static void main(String[] args) {
        MFU mfu = new MFU();
        Thread thread = new Thread(()-> mfu.scan("doc1", 7));
        Thread thread1 = new Thread(()->mfu.scan("doc2", 10));
        Thread thread2 = new Thread(()->mfu.print("doc1", 7));
        Thread thread3 = new Thread(()->mfu.print("doc2", 10));
        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            thread.join();
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MFU {
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void print(String docName, int n) {
        synchronized (lock1) {
            System.out.println("Print " + docName + " starts:");
            for (int i = 0; i < n; i++) {
                System.out.println("Print " + i + " page ");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Print " + docName + " finished.");
        }
    }

    public void scan(String docName, int n) {
        synchronized (lock2) {
            System.out.println("Scan " + docName + " begin.");
            for (int i = 0; i < 10; i++) {
                System.out.println("Scan " + i + " page");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Scan " + docName + " finished.");
        }
    }
}
