// Class representing the shared resource (Stock)
class Stock {
    private int stock = 0;   // current stock value
    private final int MAX = 5; // maximum stock limit

    // Method for producer to add stock
    synchronized void addStock(int value) {
        // If stock is full, producer must wait
        while (stock >= MAX) {
            System.out.println("Stock is full. Producer is waiting...");
            try {
                wait(); // wait until consumer consumes stock
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        stock += value;
        System.out.println("Producer added: " + value + " | Current Stock: " + stock);
        notify(); // Notify consumer that stock is available
    }

    // Method for consumer to get stock
    synchronized void getStock(int value) {
        // If stock is empty, consumer must wait
        while (stock < value) {
            System.out.println("Stock is empty. Consumer is waiting...");
            try {
                wait(); // wait until producer adds stock
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        stock -= value;
        System.out.println("Consumer bought: " + value + " | Remaining Stock: " + stock);
        notify(); // Notify producer that space is available
    }
}

// Producer class
class Producer extends Thread {
    private Stock stock;

    Producer(Stock stock) {
        this.stock = stock;
    }

    public void run() {
        for (int i = 1; i <= 6; i++) {
            stock.addStock(1);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

// Consumer class
class Consumer extends Thread {
    private Stock stock;

    Consumer(Stock stock) {
        this.stock = stock;
    }

    public void run() {
        for (int i = 1; i <= 6; i++) {
            stock.getStock(1);
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

// Main class
public class ProducerConsumer {
    public static void main(String[] args) {
        Stock stock = new Stock();

        Producer producer = new Producer(stock);
        Consumer consumer = new Consumer(stock);

        producer.start();
        consumer.start();
    }
}
 
