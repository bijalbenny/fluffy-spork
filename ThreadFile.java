/*Write a Java program that creates three threads. First thread generates a random
positive number (>1) every 1 second. If the number is even, the second thread
writes that number into even.txt. If the number is odd, the third thread writes that number into
odd.txt file*/

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

class NumberManager {
    private int generatedNumber;
    private boolean numberGenerated = false;

    // Method to generate a random number
    public synchronized void generateNumber() {
        // Generate a random number between 2 and 100
        generatedNumber = new Random().nextInt(99) + 2;
        System.out.println("Generated Number: " + generatedNumber);

        // Set the flag to indicate that the number has been generated
        numberGenerated = true;

        // Notify waiting threads that the number is ready
        notifyAll();
    }

    // Method for threads to print even numbers and append to even.txt
    public synchronized void printEvenNumbers() {
        try {
            // Wait until the number is generated and is even
            while (!numberGenerated || generatedNumber % 2 != 0) {
                wait();
            }

            // Append even numbers to even.txt
            try{
            	FileWriter writer = new FileWriter("even.txt", true);
                System.out.println("Writing the " + generatedNumber + "to even.txt ");
                writer.write(generatedNumber + " ");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Reset the flag for the next iteration
            numberGenerated = false;

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Method for threads to print odd numbers and append to odd.txt
    public synchronized void printOddNumbers() {
        try {
            // Wait until the number is generated and is odd
            while (!numberGenerated || generatedNumber % 2 == 0) {
                wait();
            }

            // Append odd numbers to odd.txt
            try {
            	FileWriter writer = new FileWriter("odd.txt", true);
            	System.out.println("Writing the " + generatedNumber + "to odd.txt ");
                writer.write(generatedNumber + " ");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Reset the flag for the next iteration
            numberGenerated = false;

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class NumberGenerator extends Thread {
    private NumberManager numberManager;

    public NumberGenerator(NumberManager numberManager) {
        this.numberManager = numberManager;
    }

    public void run() {
        while (true) {
            // Generate a new number every 1 second
            numberManager.generateNumber();

            try {
                // Sleep for 1 second before generating the next number
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class EvenPrinterThread extends Thread {
    private NumberManager numberManager;

    public EvenPrinterThread(NumberManager numberManager) {
        this.numberManager = numberManager;
    }

    public void run() {
        while (true) {
            // Print even numbers and append to even.txt
            numberManager.printEvenNumbers();
        }
    }
}

class OddPrinterThread extends Thread {
    private NumberManager numberManager;

    public OddPrinterThread(NumberManager numberManager) {
        this.numberManager = numberManager;
    }

    public void run() {
        while (true) {
            // Print odd numbers and append to odd.txt
            numberManager.printOddNumbers();
        }
    }
}

public class MultiThreadOddEven2 {
    public static void main(String[] args) {
        // Create a shared instance of NumberManager
        NumberManager numberManager = new NumberManager();

        // Create instances of the three threads with the shared NumberManager
        NumberGenerator numberGenerator = new NumberGenerator(numberManager);
        EvenPrinterThread evenPrinterThread = new EvenPrinterThread(numberManager);
        OddPrinterThread oddPrinterThread = new OddPrinterThread(numberManager);

        // Start the threads
        numberGenerator.start();
        evenPrinterThread.start();
        oddPrinterThread.start();
    }
}
