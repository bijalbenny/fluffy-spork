import java.util.Scanner;
public class Area {

	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle();
		Circle circle=new Circle();
		Triangle triangle=new Triangle();
		rectangle.getArea();
		circle.getArea();
		triangle.getArea();

	}

}
interface Shape{
	Scanner sc = new Scanner(System.in);
	public void getArea();

}
class Rectangle implements Shape{
	public void getArea() {
		int length,breadth;
		System.out.println("Enter length and breadth of Rectangle:");
		length = sc.nextInt();
		breadth = sc.nextInt();
		System.out.println("Area = "+length*breadth);
	}
}
class Circle implements Shape{
	public void getArea() {
		System.out.println("Enter radius of circle");
		float radius = sc.nextFloat();
		System.out.println("Area : "+3.14f*radius*radius);
			
	}
}
class Triangle implements Shape{
	public void getArea() {
		System.out.println("Enter base and height of triangle");
		int height = sc.nextInt();
		int base = sc.nextInt();
		System.out.println("Area : "+(base*height)/2);
	}
}
