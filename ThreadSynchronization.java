package Lab;
import java.util.*;

class MultiplicationTable{
	synchronized void  printMultiplicationTable(int number) {   //using synchronized method
	//	synchronized (this) {   //to synchronize current object : this  is used.
			for(int i=1;i<=10;i++) {
				System.out.println(i+"X"+number+"="+i*number);
			//} when using synchronized block
		}
	}
}
class MyThread1 extends Thread{
	MultiplicationTable t;
	MyThread1(MultiplicationTable t){
		this.t =t;
	}
	public void run() {
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getPriority());
		t.printMultiplicationTable(5);
	}
}
class MyThread2 extends Thread{
	MultiplicationTable t;
	MyThread2(MultiplicationTable t){
		this.t =t;
	}
	public void run() {
	    System.out.println(Thread.currentThread().getName());//to print the current running thread name
		System.out.println(Thread.currentThread().getPriority());// to print priority.by default priority of every thread is 5.
		
		t.printMultiplicationTable(7);
	}
}
public class SynchronizationDemo {
public static void main(String [] args) {
	MultiplicationTable m = new MultiplicationTable();

	MyThread1 t= new MyThread1(m);
	
	MyThread2 t1= new MyThread2(m);
	t1.setPriority(2);// to set the priority of a set.(1 to 10)
	t.start();
	t1.start();

  }
}
