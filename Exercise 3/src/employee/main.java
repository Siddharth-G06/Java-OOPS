package employee;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        ArrayList<employee> employees = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        try (FileOutputStream fos = new FileOutputStream("employee_log.txt", true);
             PrintStream logWriter = new PrintStream(fos)) {

            System.out.println("Enter details for Programmer:");

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Employee ID: ");
            String empID = sc.nextLine();

            System.out.print("Address: ");
            String address = sc.nextLine();

            System.out.print("Email: ");
            String email = sc.nextLine();

            System.out.print("Mobile Number: ");
            String mobile = sc.nextLine();

            System.out.print("Basic Pay: ");
            double bPay = sc.nextDouble();
            sc.nextLine();  // consume leftover newline

            System.out.print("Designation: ");
            String des = sc.nextLine();

            // Create Programmer object
            Programmer p = new Programmer(name, empID, address, email, mobile, bPay, des);
            employees.add(p);

            // Print and log pay slips
            PrintStream console = System.out;

            for (employee e : employees) {
                System.setOut(logWriter);
                e.paySlip();
                System.out.println();  // blank line in file

                System.setOut(console);
                e.paySlip();
                System.out.println();  // blank line in console
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
