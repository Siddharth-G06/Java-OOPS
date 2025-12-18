import java.io.*;
import java.util.Scanner;

public class TransactionSimulator {

    static class InsufficientBalanceException extends Exception {
        public InsufficientBalanceException(String message) {
            super(message);
        }
    }

    private static double balance = 10000.0;

    public static boolean transfer(double amount) throws InsufficientBalanceException {
        try {
            System.out.println("INFO: Attempting to transfer Rs." + amount);
            if (amount > balance) {
                throw new InsufficientBalanceException("Transfer amount exceeds available balance.");
            }
            balance -= amount;
            System.out.println("OUTPUT: Transfer successful. Remaining balance: Rs." + balance);
            return true;  // Return inside try to demonstrate finally always runs
        } finally {
            logTransaction(amount);
        }
    }

    private static void logTransaction(double amount) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("transaction.log", true))) {
            pw.println("LOG: Transaction attempted: amount = Rs." + amount);
        } catch (IOException e) {
            System.out.println("EXCEPTION: Failed to log transaction: " + e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        // Setup dual output (console + log file)
        PrintStream originalOut = System.out;
        PrintWriter logWriter = new PrintWriter(new FileWriter("log.txt", true), true);
        System.setOut(new PrintStream(new OutputStream() {
            public void write(int b) throws IOException {
                originalOut.write(b);
                logWriter.write(b);
            }
            public void write(byte[] b, int off, int len) throws IOException {
                originalOut.write(b, off, len);
                logWriter.write(new String(b, off, len));
            }
        }, true));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Starting balance: Rs." + balance);

        while (true) {
            System.out.print("Enter amount to transfer (or type 'exit' to quit): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting program.");
                break;
            }

            try {
                double amount = Double.parseDouble(input);
                boolean success = transfer(amount);
                System.out.println("INFO: Transfer returned: " + success);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            } catch (InsufficientBalanceException e) {
                System.out.println("EXCEPTION: " + e.getMessage());
            }
        }

        logWriter.close();
        scanner.close();
    }
}

