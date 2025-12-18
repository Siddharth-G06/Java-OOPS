import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import currency.CurrencyConverter; 
import distance.DistanceConverter;
import time.TimeConverter;

public class Convertor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputs;
        int option;
        double result;

        // Setup for log file
        try (FileOutputStream fileOutputStream = new FileOutputStream("log.txt", true);
             PrintStream logWriter = new PrintStream(fileOutputStream)) {

            while (true) {
                System.out.println("Enter 1 for Currency Conversion");
                System.out.println("Enter 2 for Distance Conversion");
                System.out.println("Enter 3 for Time Conversion");
                System.out.println("Enter 4 to Exit");
                System.out.print("Enter Your Option: ");
                
                inputs = sc.nextInt();  // User input for conversion choice
                logWriter.println("User chose option: " + inputs);  // Log the option selected
                System.out.println("User chose option: " + inputs);  // Immediate console output

                switch (inputs) {
                    case 1:
                        System.out.println("Currency Conversion Options:");
                        System.out.println("1. Dollar to INR");
                        System.out.println("2. INR to Dollar");
                        System.out.println("3. Euro to INR");
                        System.out.println("4. INR to Euro");
                        System.out.println("5. Yen to INR");
                        System.out.println("6. INR to Yen");

                        System.out.print("Enter your option: ");
                        option = sc.nextInt();
                        logWriter.println("Currency conversion option selected: " + option);

                        System.out.print("Enter the amount: ");
                        double amount = sc.nextDouble();
                        logWriter.println("Amount entered for conversion: " + amount);

                        result = CurrencyConverter.convert(option, amount);
                        if (option == 1) {
                            System.out.println(amount + " Dollar = " + result + " INR");
                            logWriter.println(amount + " Dollar = " + result + " INR");
                        } else if (option == 2) {
                            System.out.println(amount + " INR = " + result + " Dollars");
                            logWriter.println(amount + " INR = " + result + " Dollars");
                        } else if (option == 3) {
                            System.out.println(amount + " Euro = " + result + " INR");
                            logWriter.println(amount + " Euro = " + result + " INR");
                        } else if (option == 4) {
                            System.out.println(amount + " INR = " + result + " Euros");
                            logWriter.println(amount + " INR = " + result + " Euros");
                        } else if (option == 5) {
                            System.out.println(amount + " Yen = " + result + " INR");
                            logWriter.println(amount + " Yen = " + result + " INR");
                        } else if (option == 6) {
                            System.out.println(amount + " INR = " + result + " Yen");
                            logWriter.println(amount + " INR = " + result + " Yen");
                        } else {
                            System.out.println("INVALID CHOICE");
                            logWriter.println("INVALID CHOICE for currency conversion.");
                        }
                        break;

                    case 2:
                        System.out.println("Distance Conversion Options:");
                        System.out.println("1. Meter to Kilometer");
                        System.out.println("2. Kilometer to Meter");
                        System.out.println("3. Miles to Kilometer");
                        System.out.println("4. Kilometer to Miles");

                        System.out.print("Enter your option: ");
                        option = sc.nextInt();
                        logWriter.println("Distance conversion option selected: " + option);

                        System.out.print("Enter the Distance: ");
                        double distance_value = sc.nextDouble();
                        logWriter.println("Distance entered for conversion: " + distance_value);

                        result = DistanceConverter.convert(option, distance_value);

                        if (option == 1) {
                            System.out.println(distance_value + " Meters = " + result + " Kilometer");
                            logWriter.println(distance_value + " Meters = " + result + " Kilometer");
                        } else if (option == 2) {
                            System.out.println(distance_value + " Kilometer = " + result + " Meter");
                            logWriter.println(distance_value + " Kilometer = " + result + " Meter");
                        } else if (option == 3) {
                            System.out.println(distance_value + " Miles = " + result + " Kilometer");
                            logWriter.println(distance_value + " Miles = " + result + " Kilometer");
                        } else if (option == 4) {
                            System.out.println(distance_value + " Kilometer = " + result + " Miles");
                            logWriter.println(distance_value + " Kilometer = " + result + " Miles");
                        } else {
                            System.out.println("INVALID CHOICE");
                            logWriter.println("INVALID CHOICE for distance conversion.");
                        }
                        break;

                    case 3:
                        System.out.println("Time Conversion Options:");
                        System.out.println("1. Hours to Minutes");0
                        System.out.println("2. Minutes to Hours");
                        System.out.println("3. Hours to Seconds");
                        System.out.println("4. Seconds to Hours");

                        System.out.print("Enter your option: ");
                        option = sc.nextInt();
                        logWriter.println("Time conversion option selected: " + option);

                        System.out.print("Enter the Time: ");
                        double time = sc.nextDouble();
                        logWriter.println("Time entered for conversion: " + time);

                        result = TimeConverter.convert(option, time);

                        if (option == 1) {
                            System.out.println(time + " Hours = " + result + " Minutes");
                            logWriter.println(time + " Hours = " + result + " Minutes");
                        } else if (option == 2) {
                            System.out.println(time + " Minutes = " + result + " Hours");
                            logWriter.println(time + " Minutes = " + result + " Hours");
                        } else if (option == 3) {
                            System.out.println(time + " Hours = " + result + " Seconds");
                            logWriter.println(time + " Hours = " + result + " Seconds");
                        } else if (option == 4) {
                            System.out.println(time + " Seconds = " + result + " Hours");
                            logWriter.println(time + " Seconds = " + result + " Hours");
                        } else {
                            System.out.println("INVALID CHOICE");
                            logWriter.println("INVALID CHOICE for time conversion.");
                        }
                        break;

                    case 4:
                        System.out.println("Exiting...");
                        logWriter.println("Exiting the program.");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid option.");
                        logWriter.println("Invalid option selected.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
