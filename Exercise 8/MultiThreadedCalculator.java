import java.util.Random;

public class MultiThreadedCalculator {

    private static final Object lock = new Object();
    private static Integer sharedNumber = null; // Shared number between threads

    public static void main(String[] args) {
        Thread generatorThread = new Thread(() -> {
            Random random = new Random();
            while (true) {
                int number = random.nextInt(100);  // Generate number between 0-99
                synchronized (lock) {
                    sharedNumber = number;
                    System.out.println("Generated number: " + number);
                    lock.notifyAll(); // Notify worker threads
                }
                try {
                    Thread.sleep(1000); // 1 second delay
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        });

        Thread evenThread = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    try {
                        while (sharedNumber == null || sharedNumber % 2 != 0) {
                            lock.wait();
                        }
                        // Process even number
                        int num = sharedNumber;
                        System.out.println("Square of " + num + " is " + (num * num));
                        sharedNumber = null;  // Reset after processing
                        lock.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        });

        Thread oddThread = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    try {
                        while (sharedNumber == null || sharedNumber % 2 == 0) {
                            lock.wait();
                        }
                        // Process odd number
                        int num = sharedNumber;
                        System.out.println("Cube of " + num + " is " + (num * num * num));
                        sharedNumber = null;  // Reset after processing
                        lock.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        });

        generatorThread.start();
        evenThread.start();
        oddThread.start();
    }
}

