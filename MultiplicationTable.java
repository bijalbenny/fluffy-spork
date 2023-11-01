import java.util.*;
public class MultiplicationTable {

	public static void main(String[] args) {
		int number;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number");
		number=sc.nextInt();
		for(int i=1;i<=10;i++) {
			System.out.println(+i+"*"+number+"="+(i*number));
		}
	}
}
