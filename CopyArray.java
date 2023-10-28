
public class CopyArray {
	public static void main (String[] args) {
		char[] copyFrom = { 'y','a','d','e','B','I','J','A','L','s','i'};
		char[] copyTo   = new char[50];
        System.arraycopy(copyFrom, 4, copyTo, 0, 5);
        System.out.println(new String(copyTo));
		}
	}


