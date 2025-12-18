import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
class MathOperations {
public int sum(int a, int b) { return a + b; }
public double sum(double a, double b, double c) { return a + b + c; }
public int sum(int... nums) {
int s = 0; for (int n : nums) s += n; return s;
}
}
public class MathDemo {
public static void main(String[] args) throws Exception {
FileWriter fw = new FileWriter("math_log.txt", true);
PrintWriter logWriter = new PrintWriter(fw, true);
Scanner sc = new Scanner(System.in);
MathOperations mo = new MathOperations();
// Two integers
System.out.print("Enter two integers: ");
logWriter.print("Enter two integers: ");
logWriter.flush();
int a = sc.nextInt();
int b = sc.nextInt();
logWriter.println(a + " " + b);
logWriter.flush();
System.out.println("Sum (two ints): " + mo.sum(a, b));
logWriter.println("OUTPUT Sum (two ints): " + mo.sum(a, b));
logWriter.flush();
// Three doubles
System.out.print("Enter three doubles: ");
logWriter.print("Enter three doubles: ");
logWriter.flush();
double x = sc.nextDouble();
double y = sc.nextDouble();
double z = sc.nextDouble();
logWriter.println(x + " " + y + " " + z);
logWriter.flush();
System.out.println("Sum (three doubles): " + mo.sum(x, y, z));
logWriter.println("OUTPUT Sum (three doubles): " + mo.sum(x, y, z));
logWriter.flush();
// Varargs integers
System.out.print("Enter number of integers for varargs: ");
logWriter.print("Enter number of integers for varargs: ");
logWriter.flush();
int n = sc.nextInt();
logWriter.println(n);
logWriter.flush();
int[] arr = new int[n];
System.out.print("Enter " + n + " integers: ");
logWriter.print("Enter " + n + " integers: ");
logWriter.flush();
for (int i = 0; i < n; i++) {
arr[i] = sc.nextInt();
logWriter.print(arr[i] + (i < n - 1 ? " " : ""));
}
logWriter.println();
logWriter.flush();
System.out.println("Sum (varargs): " + mo.sum(arr));
logWriter.println("OUTPUT Sum (varargs): " + mo.sum(arr));
logWriter.flush();
sc.close();
logWriter.close();
}
}
