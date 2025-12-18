import java.io.*;
import java.util.Scanner;
class InvalidDataException extends Exception {
public InvalidDataException(String msg) { super(msg); }
}
class Employee {
protected String name;
protected double salary;
Employee(String name, double salary) throws InvalidDataException {
if (salary <= 0) throw new InvalidDataException("Salary must be positive.");
this.name = name;
this.salary = salary;
}
public double calculateSalary() { return salary; }
}
class Manager extends Employee {
private double bonus;
Manager(String name, double salary, double bonus) throws InvalidDataException {
super(name, salary);
if (bonus < 0) throw new InvalidDataException("Bonus cannot be negative.");
this.bonus = bonus;
}
@Override
public double calculateSalary() { return super.calculateSalary() + bonus; }
}
public class EmployeeDemo {
public static void main(String[] args) throws Exception {
FileWriter fw = new FileWriter("employee_log.txt", true);
PrintWriter logWriter = new PrintWriter(fw, true);
Scanner sc = new Scanner(System.in);
try {
// Employee input
System.out.print("Enter Employee name: ");
logWriter.print("Enter Employee name: ");
logWriter.flush();
String ename = sc.nextLine();
logWriter.println(ename);
logWriter.flush();
System.out.print("Enter Employee base salary: ");
logWriter.print("Enter Employee base salary: ");
logWriter.flush();
double esalary = sc.nextDouble();
logWriter.println(esalary);
logWriter.flush();
sc.nextLine(); // consume leftover newline
Employee emp = new Employee(ename, esalary);
System.out.println("Employee Salary: " + emp.calculateSalary());
logWriter.println("OUTPUT Employee Salary: " + emp.calculateSalary());
logWriter.flush();
// Manager input
System.out.print("Enter Manager name: ");
logWriter.print("Enter Manager name: ");
logWriter.flush();
String mname = sc.nextLine();
logWriter.println(mname);
logWriter.flush();
System.out.print("Enter Manager base salary: ");
logWriter.print("Enter Manager base salary: ");
logWriter.flush();
double msalary = sc.nextDouble();
logWriter.println(msalary);
logWriter.flush();
System.out.print("Enter Manager bonus: ");
logWriter.print("Enter Manager bonus: ");
logWriter.flush();
double bonus = sc.nextDouble();
logWriter.println(bonus);
logWriter.flush();
Manager mgr = new Manager(mname, msalary, bonus);
System.out.println("Manager Salary: " + mgr.calculateSalary());
logWriter.println("OUTPUT Manager Salary: " + mgr.calculateSalary());
logWriter.flush();
} catch (InvalidDataException e) {
System.out.println("Error: " + e.getMessage());
logWriter.println("Error: " + e.getMessage());
} catch (Exception e) {
System.out.println("Error: Invalid input");
logWriter.println("Error: Invalid input");
}
sc.close();
logWriter.close();
}
}
