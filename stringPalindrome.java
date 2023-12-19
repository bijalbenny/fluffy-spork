import java.util.Scanner;
public class Palindrome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string\n");
		String input = sc.nextLine();
		char[] charArray = input.toCharArray();
		int length = input.length();
		for(int i=0;i<length/2;i++) {
			if(charArray[i]!=charArray[length-i-1]) {
				System.out.println("Not Palindrome\n");
                     break;
			}
			else {
				System.out.println("Palindrome\n");
				break;
			}
		}
	}
}
