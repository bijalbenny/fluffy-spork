import java.util.Arrays;

public class CopyArray {
	public static void main (String[] args) {
		char[] copyFrom = { 'H','a','i','e','B','s','J','y','L','I','i','A','a'};
		char[] copyTo   = new char[50];
        System.arraycopy(copyFrom, 4, copyTo, 0, 5);
        System.out.println(new String(copyTo));
        char [] copy =new char[10];
        System.arraycopy(copyFrom, 9, copy, 0, 4);
        System.out.println(new String(copy));
        char [] copy1 =new char[10];   
        System.arraycopy(copyFrom, 0, copy1, 0, 3);
        System.out.println(new String(copy1));
		//find length
        int len=copyFrom.length;
        System.out.println("Length is "+copyFrom.length);
		}
	}
/* Another method
		int[] array1 = {1, 2, 3};
		int[] array2 = {4, 5, 6};

		int aLen = array1.length;
		int bLen = array2.length;
		int[] result1 = new int[aLen + bLen];

		System.arraycopy(array1, 0, result1, 0, aLen);
		System.arraycopy(array2, 0, result1, aLen, bLen);
        System.out.println("Another type :");
		System.out.println(Arrays.toString(result1));*/

