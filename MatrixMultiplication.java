package Javalab;
import java.util.Iterator;
import java.util.Scanner;
public class MatrixMultiplication {

	public static void main(String[] args) {
		int i,j,k,ROW1,COL1,ROW2,COL2;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the row and column of the first matrix:");
		ROW1=sc.nextInt();
		COL1=sc.nextInt();
		System.out.println("Enter the row and column of the second matrix:");
		ROW2=sc.nextInt();
		COL2=sc.nextInt();
		int[][]A=new int[ROW1][COL1];
		int[][]B=new int[ROW2][COL2];
		int[][]C=new int[ROW1][COL2];
		if (COL1==ROW2) {
				System.out.println("Multiplication is possible");
			    System.out.println("Enter the elements of first matrix:");
			    for(i=0;i<ROW1;i++) {
			    	for(j=0;j<COL1;j++) {
			    		A[i][j]=sc.nextInt();
			    	}
			    }
			    System.out.println("Enter the elements of second matrix:");
			    for(i=0;i<ROW2;i++) {
			    	for(j=0;j<COL2;j++) {
			    		B[i][j]=sc.nextInt();
			    	}
			    }
			    for(i=0;i<ROW1;i++) {
			    	for(j=0;j<COL2;j++) {
			    		C[i][j]=0;
			    	}
			    }
			    for(i=0;i<ROW1;i++) {
			    	for(j=0;j<COL2;j++) {
			    		for(k=0;k<COL1;k++) {
			    			C[i][j]=C[i][j]+A[i][k]*B[k][j];
			    			
			    		}
			    			
			    	}
			    }
			System.out.println("The resultant matrix is ");
			for(i=0;i<ROW1;i++) {
		    	for(j=0;j<COL2;j++) {
		    		System.out.print(C[i][j]+" ");
		    	}
		    	System.out.println("\n");
			}
		}
		else {
			System.out.println("Multiplication is not possible");
		}
	}
}
