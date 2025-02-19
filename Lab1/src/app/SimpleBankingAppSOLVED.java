package app;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

import controller.AccountController;
import controller.UserController;

import java.util.Date;

import model.Account;
import model.Transaction;
import model.User;
import model.Account.AccountType;

public class SimpleBankingAppSOLVED {
	public static Vector<User> users = new Vector<User>();
	public static Vector<Account> accounts  = new Vector<Account>();
	public static Vector<Transaction> transactions =  new Vector<Transaction>();
	
	 UserController userController = new UserController(users);
	
	public static void loadAccountData()  {
		// structure of each record: 
		// account number, username (email) of account holder, account type (Standard or Saving), account_opening_date

		Account anAccount;
		try {
			
			anAccount = new Account("5495-1234", "mike", AccountType.SAVINGS, new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2019"));
			accounts.add(anAccount);
			
			anAccount = new Account("5495-1239", "mike", AccountType.STANDARD, new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2020"));
			accounts.add(anAccount);

			anAccount = new Account("5495-1291", "mike", AccountType.SAVINGS, new SimpleDateFormat("dd/MM/yyyy").parse("21/07/2019"));
			accounts.add(anAccount);

			anAccount = new Account("5495-6789", "David.McDonald@gmail.com", AccountType.SAVINGS, new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2019"));
			accounts.add(anAccount); 

		} catch (ParseException e) {			
			e.printStackTrace();
		}  
	}
	
	public static void printAllAccounts(AccountController accountController) {
		System.out.println("There are: " + accounts.size() + " accounts in the system.");
		//System.out.println("Account_number | username_of_account_holder | account_type | account_opening_date");

		System.out.println(String.format("%-10s| %-30s| %-10s| %-15s| %-15s", 
				"Account_number", "username_of_account_holder", "account_type", "account_opening_date", "Balance"));
		System.out.println("--------------------------------------------------------------------------------");
		
		 for (Account account : accounts) {
		        System.out.println(account.toString() + " | $" + accountController.getBalance(account.getAccount_number()));
		
		System.out.println();}
	}
	
	// TODO 12b: Prevent Transactions from Non-existent accounts
	
	public static void addTransaction(String account_number, double amount, Date transaction_date) { 
		
		 boolean accountExists = accounts.stream()
                 .anyMatch(acc -> acc.getAccount_number().equals(account_number));

		 if (!accountExists) {
			System.out.println("Error: Account number " + account_number + " does not exist. Transaction stopped.");
			return;
			}
		Transaction aTransaction =  new Transaction(account_number, amount, Calendar.getInstance().getTime());
		transactions.add(aTransaction);
	}
	
	
	AccountController accountController = new AccountController(transactions);
	double balance = accountController.getBalance("5495-1234");
	
	// TODO 12a: Display accounts for a specific user
	
	public static void printUserAccounts(String username) {
	    System.out.println("Accounts for user: " + username);
	    System.out.println("--------------------------------------");

	    boolean found = false;
	    for (Account acc : accounts) {
	        if (acc.getUsername_of_account_holder().equals(username)) {
	            System.out.println(acc);
	            found = true;
	        }
	    }

	    if (!found) {
	        System.out.println("No accounts found for this user.");
	    }
	}
	

	public static void main(String[] args) {
		
		 UserController userController = new UserController(users);
		 userController.loadUserData();
		 userController.printAllUsers();
		
		loadAccountData();
		System.out.println("Accounts: initial state, after loading...");
		
		AccountController accountController = new AccountController(transactions);
		
		printAllAccounts(accountController);
		
		addTransaction("5495-1234", -50.21, Calendar.getInstance().getTime());
		System.out.println("Account: after the 1st addTransaction function call...");
		printAllAccounts(accountController);
		
		// and some more activities on the accounts
		addTransaction("5495-1234", 520.00, Calendar.getInstance().getTime());
		addTransaction("9999-1111", 21.00, Calendar.getInstance().getTime());
		System.out.println("Account: after the 2nd/3rd addTransaction function calls...");
		printAllAccounts(accountController);
		

	}

}
