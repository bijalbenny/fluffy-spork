/***************************************************************************
 * File          :          BankApp.java
 * Descriptiopn  :          To understand Exception Handling in Java
 * Author        :          Bijal T Benny
 * Version       :          1.0
 * Date          :          14/11/2023
 * *************************************************************************/
package basil_vazhathottathil;

import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        int choice;
        InvalidAmountException invalidAmount = new InvalidAmountException("Invalid amount, less than 0");
        InsufficientFundsException insufficientFunds = new InsufficientFundsException("Insufficient balance");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of customers");
        int noOfCustomers = sc.nextInt();
        Customer[] customers = new Customer[noOfCustomers];

        for (int i = 0; i < noOfCustomers; i++) {
            customers[i] = new Customer();
            customers[i].getDetails(sc);
        }

        do {
            System.out.print("\n\n\n");
            System.out.print("MENU\n" + "1. Display all account details\n"
                    + "2. Search by account number\n" + "3. Deposit the amount\n"
                    + "4. Withdraw the amount\n" + "5. Exit\n");
            choice = sc.nextInt();

            switch (choice) {
                case 1: {
                    for (Customer customer : customers) {
                        customer.printDetails();
                    }
                    break;
                }
                case 2: {
                    System.out.println("Enter the account number");
                    int search = sc.nextInt();
                    boolean accountFound = false;

                    for (Customer customer : customers) {
                        if (customer.accountNumber == search) {
                            customer.printDetails();
                            accountFound = true;
                            break;
                        }
                    }

                    if (!accountFound) {
                        System.out.println("Account not found");
                    }
                    break;
                }
                case 3: {
                    System.out.println("Enter the account number");
                    int query = sc.nextInt();
                    boolean accountFound = false;

                    for (Customer customer : customers) {
                        if (customer.accountNumber == query) {
                            accountFound = true;
                            try {
                                System.out.println("Enter the amount to deposit");
                                int deposit = sc.nextInt();
                                if (deposit < 0) {
                                    throw invalidAmount;
                                }
                                customer.balance += deposit;
                                System.out.println("Deposit successful. New balance: " + customer.balance);
                            } catch (InvalidAmountException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        }
                    }

                    if (!accountFound) {
                        System.out.println("Account not found");
                    }
                    break;
                }
                case 4: {
                    System.out.println("Enter the account number");
                    int query = sc.nextInt();
                    boolean accountFound = false;

                    for (Customer customer : customers) {
                        if (customer.accountNumber == query) {
                            accountFound = true;
                            try {
                                System.out.println("Enter the amount to withdraw");
                                int withdraw = sc.nextInt();
                                if (withdraw < 0) {
                                    throw invalidAmount;
                                } else if (withdraw > customer.balance) {
                                    throw insufficientFunds;
                                } else {
                                    customer.balance -= withdraw;
                                    System.out.println("Withdrawal successful. New balance: " + customer.balance);
                                }
                            } catch (InvalidAmountException e) {
                                System.out.println(e.getMessage());
                            } catch (InsufficientFundsException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        }
                    }

                    if (!accountFound) {
                        System.out.println("Account not found");
                    }
                    break;
                }
                case 5:
                    break;
                default:
                    System.out.println("Enter the correct choice");
            }
        } while (choice != 5);

        sc.close(); // Close the scanner to prevent resource leak
    }
}

class Customer {
    Scanner sc = new Scanner(System.in);
    String accountType, customerName;
    int balance, accountNumber;

    public void getDetails(Scanner sc) {
        System.out.println("Enter the Customer Name");
        sc.nextLine();
        customerName = sc.nextLine();
        System.out.println("Enter the account Number");
        accountNumber = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the account Type");
        accountType = sc.nextLine();
        System.out.println("Enter the balance in the account");
        balance = sc.nextInt();
    }

    public void printDetails() {
        System.out.println("________________________________");
        System.out.println("Customer Name : " + customerName);
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account type : " + accountType);
        System.out.println("Balance : " + balance);
        System.out.println("________________________________");
    }
}

class InvalidAmountException extends Exception {
    InvalidAmountException(String str) {
        super(str);
    }
}

class InsufficientFundsException extends Exception {
    InsufficientFundsException(String str) {
        super(str);
    }
}
