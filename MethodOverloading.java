package Javalab;
import java.util.Scanner;
public class MethodOverloading {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter length,breadth,side,raius of the shapes:");
		int length = sc.nextInt();
		int breadth = sc.nextInt();
		int side = sc.nextInt();
		int radius = sc.nextInt();
		Shape shape = new Shape();
	shape.area(length,breadth);
	shape.area(side);
	shape.area(radius);
	}

}
class Shape{
	int area;
	public void area(int length,int breadth) {
		area = length*breadth;
		System.out.println("Area="+area);
		
	}
	public void area(int side) {
		area = side*side;
		System.out.println("Area="+area);
	}
	public void area(float radius) {
		System.out.println("Area="+3.14*radius*radius);
	}
}