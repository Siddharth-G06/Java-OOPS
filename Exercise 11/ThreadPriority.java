// Program to illustrate Thread Priority
class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + 
                               " (Priority: " + Thread.currentThread().getPriority() + ") - Count: " + i);
            try {
                Thread.sleep(500); // pause for clarity
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class ThreadPriority{
    public static void main(String[] args) {
        // Create threads
        MyThread t1 = new MyThread("Low Priority Thread");
        MyThread t2 = new MyThread("Normal Priority Thread");
        MyThread t3 = new MyThread("High Priority Thread");

        // Set priorities
        t1.setPriority(Thread.MIN_PRIORITY);   // Priority 1
        t2.setPriority(Thread.NORM_PRIORITY);  // Priority 5 (default)
        t3.setPriority(Thread.MAX_PRIORITY);   // Priority 10

        // Start threads
        t1.start();
        t2.start();
        t3.start();
    }
}

