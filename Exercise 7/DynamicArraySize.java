import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

class InvalidArraySizeException extends Exception {
    public InvalidArraySizeException(String message) {
        super(message);
    }
}

public class DynamicArraySize {
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

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter the size of the array (positive integer): ");
            int size = sc.nextInt();
            System.out.println("INPUT size: " + size);

            if (size <= 0) {
                throw new InvalidArraySizeException("Array size must be positive.");
            }

            int[] array = new int[size];
            System.out.println("OUTPUT: Array of size " + size + " created successfully.");

        } catch (InvalidArraySizeException e) {
            System.out.println("EXCEPTION: Custom Exception caught: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("EXCEPTION: InputMismatchException - Please enter a valid integer.");
        } catch (Exception e) {
            System.out.println("EXCEPTION: Unexpected exception: " + e);
        } finally {
            System.out.println("INFO: Execution of try-catch-finally complete.");
            sc.close();
            logWriter.close();
        }
    }
}

