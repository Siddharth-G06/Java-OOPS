// Program to demonstrate multithreading using Thread subclass
class WeatherThread extends Thread {

    // Override the run() method to define the thread's task
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": Today is hot, humid and sunny.");
            try {
                Thread.sleep(500); // pause for 500ms to show concurrent behavior
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class Weather{
    public static void main(String[] args) {
        // Create two thread objects
        WeatherThread t1 = new WeatherThread();
        WeatherThread t2 = new WeatherThread();

        // Set names for the threads (optional but useful for clarity)
        t1.setName("WeatherThread-1");
        t2.setName("WeatherThread-2");

        // Start the threads
        t1.start();
        t2.start();
    }
}

