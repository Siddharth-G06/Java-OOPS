import java.io.*;
import java.util.Scanner;

public class StackAdt {
    public static void main(String[] args) throws Exception {
        // Setup logging
        FileWriter fw = new FileWriter("log.txt", true);
        PrintWriter logWriter = new PrintWriter(fw, true);
        PrintStream originalOut = System.out;

        PrintStream dualOut = new PrintStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                originalOut.write(b);
                logWriter.write(b);
            }
        }, true);

        System.setOut(dualOut);

        Scanner scanner = new Scanner(System.in);

        try {
            int initialSize = 0;
            while (true) {
                String sizeStr = scanner.nextLine();
                if (sizeStr.trim().isEmpty()) continue;
                try {
                    initialSize = Integer.parseInt(sizeStr.trim());
                    if (initialSize <= 0 || initialSize > 100) {
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    // Ignore invalid input silently
                }
            }
            logWriter.println("INPUT: Enter initial stack size: " + initialSize);

            StackArray stack = new StackArray(initialSize);

            while (true) {
                System.out.println("\n--- Stack Menu ---");
                System.out.println("1. Push  2. Pop  3. Display  4. Exit");
                String choiceStr = scanner.nextLine();
                if (choiceStr.trim().isEmpty()) {
                    continue;
                }
                int choice;
                try {
                    choice = Integer.parseInt(choiceStr.trim());
                } catch (NumberFormatException e) {
                    continue;
                }
                logWriter.println("INPUT: Choice: " + choice);

                switch (choice) {
                    case 1:
                        String value = scanner.nextLine();
                        logWriter.println("INPUT: Enter value to push: " + value);
                        try {
                            stack.push(value);
                        } catch (StackOverflowException e) {
                            System.out.println("Exception: " + e.getMessage());
                            logWriter.println("EXCEPTION: " + e.getMessage());
                        }
                        break;

                    case 2:
                        try {
                            stack.pop();
                        } catch (StackUnderflowException e) {
                            System.out.println("Exception: " + e.getMessage());
                            logWriter.println("EXCEPTION: " + e.getMessage());
                        }
                        break;

                    case 3:
                        stack.display();
                        break;

                    case 4:
                        System.out.println("Program exiting...");
                        logWriter.println("Program exiting...");
                        scanner.close();
                        logWriter.close();
                        return;

                    default:
                        // Ignore invalid choices silently
                }
            }
        } finally {
            if (scanner != null) scanner.close();
            if (logWriter != null) logWriter.close();
        }
    }
}
