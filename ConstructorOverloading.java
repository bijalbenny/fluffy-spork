package Javalab;
import java.util.Scanner;
public class ConstructorOverloading {
	public static void main(String[] args) {
		Fibonacci fibonacci = new Fibonacci();
		fibonacci.generateFibonacci();
	}
}
class Fibonacci {
	int firstNumber;
	int secondNumber;
	int thirdNumber;
	Fibonacci(){
		firstNumber = 0;
		secondNumber = 1;
	}
public void generateFibonacci(){
	System.out.println("Enter the limit:");
	Scanner sc = new Scanner(System.in);
	int limit = sc.nextInt();
	for(int i=0;i<limit;i++) {
		thirdNumber = firstNumber + secondNumber;
		System.out.println(thirdNumber+"\t");
		firstNumber = secondNumber;
		secondNumber = thirdNumber;
	}
}
}
