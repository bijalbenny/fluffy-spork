import java.util.Scanner;
class InvalidAmountException extends Exception{
	public InvalidAmountException(String str) {
		super(str);
	}
}
class InvalidFundException extends Exception{
	public InvalidFundException(String str) {
		super(str);
	}
}
class Customer{
	int accountNumber;
	String accountType;
	String customerName;
	int accountBalance;
	Scanner sc = new Scanner(System.in);
	public void setCustomerDetails() {
		
		System.out.println("Enter the Account Number");
		accountNumber = sc.nextInt();
		System.out.println("Enter the Account Type");
		accountType = sc.next();
		System.out.println("Enter the Customer Name ");
		customerName = sc.next();
		System.out.println("Enter the Account opening balance");
		accountBalance = sc.nextInt();
	}
	public  void getCustomerDetails() {
		System.out.println("****************************************");
		System.out.println("The Customer Details are : ");
		System.out.println("Account Number : "+accountNumber);
		System.out.println("Account Type : "+accountType);
		System.out.println("Customer Name : "+customerName);
		System.out.println("Account Balance : "+accountBalance);
		System.out.println("****************************************");
	}
}
public class BankException{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		InvalidAmountException amountException = new  InvalidAmountException("Invalid Amount");
		InvalidFundException fundsException = new InvalidFundException("Insufficient fund");
		System.out.println("Enter the number of Customers ");
		int noOfCustomers = sc.nextInt();	
		Customer [] customer = new Customer[noOfCustomers]; //array of objects
		for(int i=0;i<noOfCustomers;i++) {
			customer[i] = new Customer(); //To create object
			customer[i].setCustomerDetails();		
		}
		/*for(int i=0;i<noOfCustomers;i++) {
			customer[i].getCustomerDetails();
		}*/
		int choice;
		do{
			System.out.println("1.Display Account Details");
			System.out.println("2.Search by Account Number");
			System.out.println("3.Deposit the amount");
			System.out.println("4.Withdraw the amount");
			System.out.println("5.Exit");
			System.out.println("Enter your choice");
			choice = sc.nextInt();
			switch(choice) {
			case 1:
				for(int i=0;i<noOfCustomers;i++) {
					customer[i].getCustomerDetails();
				}
				break;
			case 2:
				System.out.println("Enter the account number");
				int searchAccountNo = sc.nextInt();
				for(int i=0;i<noOfCustomers;i++) {
					if(customer[i].accountNumber==searchAccountNo) {
						customer[i].getCustomerDetails();
					}
				}
				break;
			case 3:
				try {
					System.out.println("Enter the account number");
					searchAccountNo = sc.nextInt();
					System.out.println("Enter the amount to deposit");
					int depositAmount = sc.nextInt();
					if(depositAmount<=0) {
						throw amountException;
					}
					else {
					for(int i=0;i<noOfCustomers;i++) {
						if(customer[i].accountNumber==searchAccountNo) {
							customer[i].accountBalance = customer[i].accountBalance+depositAmount;
							customer[i].getCustomerDetails();
						}
					}
				}
					
					
					
				}catch(InvalidAmountException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4: 
				System.out.println("Enter the account number");
				searchAccountNo = sc.nextInt();
				try {
				System.out.println("Enter the amount to withdraw");
				int withdrawAmount = sc.nextInt();
				if(withdrawAmount<=0) {
					throw amountException;
				}
				else {
					for(int i=0;i<noOfCustomers;i++) {
						if(customer[i].accountNumber==searchAccountNo) {
							if(withdrawAmount>customer[i].accountBalance) {
								throw fundsException;
							}
							else {
								customer[i].accountBalance = customer[i].accountBalance;
								customer[i].getCustomerDetails();
							}
						}
				}
				}}catch(InvalidAmountException e) {
					System.out.println(e.getMessage());
				}
				break;
			default:
			}
			
		}while(choice<4);
		
	}
	
}

	
