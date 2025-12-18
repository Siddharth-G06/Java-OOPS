import java.io.*;
import java.util.Scanner;
abstract class Shape {
	abstract double area();
	abstract String color();
}
class Rectangle extends Shape {
	double length, breadth;
	
	Rectangle(double l, double b) {
this.length = l;
this.breadth = b;
}
double area() {
return length * breadth;
}
String color() {
return "Green";
}
}
class Triangle extends Shape {
double base, height;
Triangle(double b, double h) {
this.base = b;
this.height = h;
}
double area() {
return 0.5 * base * height;
}
String color() {
return "Red";
}
}
class Circle extends Shape {
double radius;
Circle(double r) {
this.radius = r;
}
double area() {
return Math.PI * radius * radius;
}
String color() {
return "Yellow";
}
}
public class ShapeDemo {
public static void main(String[] args) throws Exception {
FileWriter fw = new FileWriter("log.txt", true);
PrintWriter logWriter = new PrintWriter(fw, true);
Scanner sc = new Scanner(System.in);
// Rectangle
System.out.print("Enter length and breadth of rectangle : ");
logWriter.print("Enter length and breadth of rectangle : ");
logWriter.flush();
double l = sc.nextDouble();
double b = sc.nextDouble();
logWriter.println(l + " " + b);
logWriter.flush();
Shape rect = new Rectangle(l, b);
System.out.println("Shape: Rectangle");
System.out.println("Area: " + rect.area());
System.out.println("Rectangle color is " + rect.color());
logWriter.println("Shape: Rectangle");
logWriter.println("Area: " + rect.area());
logWriter.println("Rectangle color is " + rect.color());
logWriter.flush();

// Triangle
System.out.print("Enter base and height of triangle : ");
logWriter.print("Enter base and height of triangle : ");
logWriter.flush();
double base = sc.nextDouble();
double h = sc.nextDouble();
logWriter.println(base + " " + h);
logWriter.flush();
Shape tri = new Triangle(base, h);
System.out.println("Shape: Triangle");
System.out.println("Area: " + tri.area());
System.out.println("Triangle color is " + tri.color());
logWriter.println("Shape: Triangle");
logWriter.println("Area: " + tri.area());
logWriter.println("Triangle color is " + tri.color());
logWriter.flush();
// Circle
System.out.print("Enter radius of circle : ");
logWriter.print("Enter radius of circle : ");
logWriter.flush();
double r = sc.nextDouble();
logWriter.println(r);
logWriter.flush();
Shape cir = new Circle(r);
System.out.println("Shape: Circle");
System.out.println("Area: " + cir.area());
System.out.println("Circle color is " + cir.color());
logWriter.println("Shape: Circle");
logWriter.println("Area: " + cir.area());
logWriter.println("Circle color is " + cir.color());
logWriter.flush();
sc.close();
logWriter.close();
}
}
