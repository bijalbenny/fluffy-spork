import java.util.Scanner;

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

class Customer {
    int accountNumber;
    String accountType;
    String customerName;
    int accountBalance;
    Scanner sc = new Scanner(System.in);

    public void setCustomerDetails() {
        System.out.println("Enter the Account Number");
        accountNumber = sc.nextInt();
        System.out.println("Enter the account type");
        accountType = sc.next();
        System.out.println("Enter the Customer Name");
        customerName = sc.next();
        System.out.println("Enter the Account Opening Balance");
        accountBalance = sc.nextInt();
    }

    public void getCustomerDetails() {
        System.out.println("_______________________________");
        System.out.println("The Customer Details are:");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Account Balance: " + accountBalance);
        System.out.println("_______________________________");
    }
}

public class BankException {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InvalidAmountException amountException = new InvalidAmountException("Invalid Amount");
        InsufficientFundsException fundsException = new InsufficientFundsException("Insufficient Funds");
        int choice;

        System.out.println("Enter the No of Customers");
        int noOfCustomers = sc.nextInt();
        Customer[] customer = new Customer[noOfCustomers];

        // Input customer details
        for (int i = 0; i < noOfCustomers; i++) {
            customer[i] = new Customer();
            customer[i].setCustomerDetails();
        }

        do {
            System.out.println("1. Display Account Details");
            System.out.println("2. Search by account number");
            System.out.println("3. Deposit the amount");
            System.out.println("4. Withdraw the amount");
            System.out.println("5. Exit");
            System.out.println("Enter your choice:");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    // Display all customer details
                    for (int i = 0; i < noOfCustomers; i++) {
                        customer[i].getCustomerDetails();
                    }
                    break;
                case 2:
                    // Search for a customer by account number
                    System.out.println("Enter the account number");
                    int searchAccount = sc.nextInt();
                    for (int i = 0; i < noOfCustomers; i++) {
                        if (customer[i].accountNumber == searchAccount) {
                            customer[i].getCustomerDetails();
                        }
                    }
                    break;
                case 3: // Deposit Amount
                    System.out.println("Enter the account number");
                    searchAccount = sc.nextInt();
                    try {
                        System.out.println("Enter the amount to deposit");
                        int depositAmount = sc.nextInt();
                        if (depositAmount < 0) {
                            throw amountException;
                        } else {
                            for (int i = 0; i < noOfCustomers; i++) {
                                if (customer[i].accountNumber == searchAccount) {
                                    customer[i].accountBalance = customer[i].accountBalance + depositAmount;
                                    customer[i].getCustomerDetails();
                                }
                            }
                        }

                    } catch (InvalidAmountException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4: // Withdraw Amount
                    System.out.println("Enter the account number");
                    searchAccount = sc.nextInt();
                    try {
                        System.out.println("Enter the amount to withdraw");
                        int withdrawAmount = sc.nextInt();
                        if (withdrawAmount <= 0) {
                            throw amountException;
                        } else {
                            for (int i = 0; i < noOfCustomers; i++) {
                                if (customer[i].accountNumber == searchAccount) {
                                    if (withdrawAmount > customer[i].accountBalance) {
                                        throw fundsException;
                                    } else {
                                        customer[i].accountBalance = customer[i].accountBalance - withdrawAmount;
                                        customer[i].getCustomerDetails();
                                    }
                                }
                            }
                        }
                    } catch (InvalidAmountException e) {
                        System.out.println(e.getMessage());
                    } catch (InsufficientFundsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    // Invalid choice
            }
        } while (choice < 5);
        sc.close();
    }
}
