import java.util.Scanner;
import currency.CurrencyConverter; 

public class Convertor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputs;

        while (true) {
            System.out.println("Enter 1 for Currency Conversion");
            System.out.println("Enter 2 for Distance Conversion");
            System.out.println("Enter 3 for Time Conversion");
            System.out.println("Enter 4 to Exit");
            System.out.print("Enter Your Option: ");

            if (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                sc.next(); 
                continue;
            }

            inputs = sc.nextInt();

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

                    int option = sc.nextInt();
                    System.out.print("Enter the amount: ");
                    double amount = sc.nextDouble();

                    double result;
                    result= CurrencyConverter.convert(option, amount);
                    if (option==1){
                            System.out.print(amount+" Dollar in INR = "+result+"\n");
                    }
                    else if (option==2){
                            System.out.print(amount+" INR in Dollar = "+result+"\n");
                    }
                    else if (option==3){
                            System.out.print(amount+" Euro in INR = "+result+"\n");
                    }
                    else if (option==4){
                            System.out.print(amount+" INR in Euro = "+result+"\n");
                    }
                    else if (option==5){
                            System.out.print(amount+" Yen in INR = "+result+"\n");
                    }
                    else if (option==6){
                            System.out.print(amount+" INR in Yen = "+result+"\n");
                    }
                    else{
                        System.out.print("INVALID CHOICE");
                    }
                    break;

                case 2:
                    System.out.println("Distance Conversion Options:");
                    System.out.println("1. Meter to Kilometer");
                    System.out.println("2. Kilometer to Meters");
                    System.out.println("3. Kilometer to Miles");
                    System.out.println("4. Miles to Kilometer");
                    
                    System.out.print("Enter your option: ");

                    int opt = sc.nextInt();
                    System.out.print("Enter the amount: ");
                    double d = sc.nextDouble();

                    double res;
                    res= CurrencyConverter.convert(opt, d);
                    if (opt==1){
                            System.out.print(d+" Meters in Kilometer  = "+res+"\n");
                    }
                    else if (opt==2){
                            System.out.print(d+" Kilometer in Meter = "+res+"\n");
                    }
                    else if (opt==3){
                            System.out.print(d+" Kilometer in Miles = "+res+"\n");
                    }
                    else if (opt==4){
                            System.out.print(d+" Miles in Kilometer = "+res+"\n");
                    }
                    
                    else{
                        System.out.print("INVALID CHOICE");
                    }
                    break;

                case 3:
                    System.out.println("Time Conversion not implemented.");
                    break;

                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
