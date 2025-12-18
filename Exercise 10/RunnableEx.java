// Program to create two threads using Runnable interface
class MessagePrinter implements Runnable {
    private String message;

    // Constructor
    MessagePrinter(String message) {
        this.message = message;
    }

    // run() method — defines the code executed by the thread
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(message);
            try {
                Thread.sleep(300); // pause for 300 milliseconds
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class RunnableEx{
    public static void main(String[] args) {
        // Create Runnable objects
        MessagePrinter hiPrinter = new MessagePrinter("HI");
        MessagePrinter aiPrinter = new MessagePrinter("AI");

        // Create Thread objects and pass Runnable instances
        Thread t1 = new Thread(hiPrinter);
        Thread t2 = new Thread(aiPrinter);

        // Start the threads
        t1.start();
        t2.start();
    }
}

