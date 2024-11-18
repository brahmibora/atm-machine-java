package ATMMachine;

import java.util.ArrayList;
import java.util.Scanner;

class ATM{
	
	//Attributes of the ATM class
	float Balance;
	int PIN = 1234;      
	ArrayList<String> transactionHistory = new ArrayList<>();
	
	//Method to check PIN
	public void checkpin() {
		System.out.println("Enter your pin: ");
		Scanner sc = new Scanner(System.in);
		int enterpin = sc.nextInt();
		if(enterpin == PIN)
		{
			menu();  //If the entered PIN is correct, show the menu
		}
		else
		{
			System.out.println("Enter a valid PIN");
			checkpin();  //If the entered PIN is incorrect, try again
		}
	}
	
	//Method to display menu options
	public void menu() {
		System.out.println("Enter your Choice: ");
		System.out.println("\t1. Check A/C Balance");
		System.out.println("\t2. Cash Withdrawal");
		System.out.println("\t3. Cash Deposit");
		System.out.println("\t4. PIN Change");
		System.out.println("\t5. Transection History");
		System.out.println("\t6. EXIT");
		Scanner sc = new Scanner(System.in);
		int opt = sc.nextInt();
		
		//Call the perticuler method based on user choice
		if(opt == 1)
		{
			Check_Balance();
		}
		else if(opt == 2)
		{
			Cash_Withdrawal();
		}
		else if(opt == 3)
		{
			Cash_Deposit();
		}
		else if(opt == 4)
		{
			PIN_Change();
		}
		else if(opt == 5)
		{
			Transection_History();
		}
		else if(opt == 6)
		{
			return; //exit the program
		}
		else
		{
			System.out.println("Enter a valid choice");
			menu();  //If choice is invalid, try again
		}
	}
	
	//Method to check  balance
	public void Check_Balance() {
		System.out.println("Balance: "+Balance);
		menu();
	}
	
	//Method to withdraw cash
	public void Cash_Withdrawal() {
		System.out.println("Enter Your Amount to Withdrawal: ");
		Scanner sc = new Scanner(System.in);
		int amount = sc.nextInt();
		if(amount>Balance)
		{
			System.out.println("Insufficient Balance");
		}
		else
		{
			Balance = Balance-amount;
			System.out.println("Money Withdrawal Successfully");
			System.out.println("Your Current Balance is: "+Balance);
			
			//Store withdrawal data on Transection_History method
			transactionHistory.add("Withdrew: " + amount + ", New balance: " + Balance);
			
		}
		menu();
	}
	
	//Method to deposit cash
	public void Cash_Deposit() {
		System.out.println("Enter the Amount: ");
		Scanner sc = new Scanner(System.in);
		int amount = sc.nextInt();
		
		Balance = Balance + amount;
		System.out.println("Money Deposit Successfully");
		
		//Store deposit data on Transection_History method
		transactionHistory.add("Deposited: " + amount + ", New balance: " + Balance);
		menu();
	}
	
	//Method to change PIN
	public void PIN_Change() {
		System.out.println("Enter Your Current PIN: ");
		Scanner sc = new Scanner(System.in);
		int currentPin = sc.nextInt();
		
		if(currentPin == PIN)
		{
			System.out.println("Enter New PIN: ");
			int newPin = sc.nextInt();
			PIN = newPin;
			System.out.println("PIN Changed Successfully");
			menu();
		}
		
		else
		{
			System.out.println("Invalid PIN");
			menu();
		}
		
	}
	
	//Method to show transection history
	public void Transection_History() {
		if(transactionHistory.isEmpty())  //No any transection made
		{
            System.out.println("No transactions made yet.");
        } 
		
		else 
		{
            for(String transaction : transactionHistory)
            {
                System.out.println(transaction);
            }
        }
		
        menu();
	}
}

public class ATMMachine {

	public static void main(String[] args) {
		
		//Creating an object of ATM class 
		
		ATM obj = new ATM();
		obj.checkpin();  //Start PIN check process

	}

}
