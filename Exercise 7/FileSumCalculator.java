import java.io.*;
import java.util.Scanner;

public class FileSumCalculator {
    public static void main(String[] args) throws IOException {
        // Setup dual output
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

        String filename = "numbers.txt";
        int sum = 0;

        try (Scanner fileScanner = new Scanner(new File(filename))) {
            while (true) {
                try {
                    if (!fileScanner.hasNext()) break;

                    String token = fileScanner.next();
                    System.out.println("INPUT token: " + token);
                    int number = Integer.parseInt(token);
                    sum += number;
                } catch (NumberFormatException e) {
                    System.out.println("EXCEPTION: Invalid number found, skipping token.");
                }
            }
            System.out.println("OUTPUT: Sum of valid numbers: " + sum);
        } catch (FileNotFoundException e) {
            System.out.println("EXCEPTION: File not found: " + filename);
        } finally {
            logWriter.close();
        }
    }
}

