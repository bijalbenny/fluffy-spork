package DemoLab;
import java.util.Random;//to generate random number...
class NumberManager{
	private int generatedNumber;//storing random number
	private boolean numberGenerated = false;//to check whether the number is generated or not.
	public synchronized void generateNumber() {
		generatedNumber = new Random().nextInt(99)+2;//to generate random number from 2 to 100
		System.out.println("Generated Random Number : "+generatedNumber);
		numberGenerated = true; //boolean
		notifyAll(); //to wake all the waiting functions that a random number is created..
	}
	public synchronized void printEvenNumbers() throws InterruptedException {  //to print the even numbers
		while(!numberGenerated||generatedNumber%2!=0) {
			wait();  // wait until a even number is generated.
		}
		for(int i=2;i<=generatedNumber;i+=2) {
			System.out.print(i+"  ");
		}
		numberGenerated = false;
		System.out.println(" ");
	}
	public synchronized void printOddNumbers() throws InterruptedException {  //to print the odd numbers
		while(!numberGenerated||generatedNumber%2==0) {
			wait();  // wait until a odd number is generated.
			        //wait function throws an exception
		}
		for(int i=1;i<=generatedNumber;i+=2) {
			System.out.print(i+"  ");
		}
		numberGenerated = false;
		System.out.println(" ");
	}
	
	
}

class NumberGenerator extends Thread{
	NumberManager numberManager;
	public NumberGenerator(NumberManager numberManager) {
		this.numberManager = numberManager;
	}
	public void run() {
		while(true) {
			numberManager.generateNumber();
			try {
				Thread.sleep(1000);// to provide 1 second delay(milliseconds).& 
		//since Thread.sleep function gives an exception so we want to include it in a try-catch block
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class EvenPrinterThread extends Thread{
	NumberManager numberManager;
	public EvenPrinterThread(NumberManager numberManager) {
		this.numberManager = numberManager;
	}
	public void run() {
		while(true) {  //infinite loop to access and print even numbers...
			try {
				numberManager.printEvenNumbers();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class OddPrinterThread extends Thread{
	NumberManager numberManager;
	public OddPrinterThread(NumberManager numberManager) {
		this.numberManager = numberManager;
	}
	public void run() {
		while(true) {  //infinite loop to access and print even numbers...
			try {
				numberManager.printOddNumbers();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}






public class MultiThreadOddEven {
	public static void main(String[] args) {
		NumberManager manager = new NumberManager();
		NumberGenerator numberGenerator = new NumberGenerator(manager);
		EvenPrinterThread evenPrinterThread = new EvenPrinterThread(manager);
		OddPrinterThread oddPrinterThread = new OddPrinterThread(manager);
		numberGenerator.start();
		evenPrinterThread.start();
		oddPrinterThread.start();
		

	}

}
