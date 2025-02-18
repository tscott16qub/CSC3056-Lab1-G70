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
	
	public static void loadUserData() {
		// structure of each record: username (email address), password, first_name, last_name, mobile_number
		
		// in the ideal case (real deployment of the app), we will read from file or database, but let's hard-code for now
		User aUser = new User("mike", "my_passwd", "Mike", "Smith", "07771234567");
		users.add(aUser);
		
		aUser = new User("james.cameron@gmail.com", "angel", "James", "Cameron",  "07777654321");
		users.add(aUser);
		
		aUser = new User("julia.roberts@gmail.com", "change_me",   "Julia", "roberts",   "07770123456");
		users.add(aUser); 
		
	}
	
	public static void printAllUsers() {
		System.out.println("There are: " + users.size() + " users in the system.");	
		System.out.println(String.format("%-25s| %-15s| %-15s| %-15s| %-15s", 
				"username", "password", "first_name", "last_name", "mobile_number"));
		System.out.println("-------------------------------------------------------------------------------------------");
		for  (int i = 0; i < users.size(); i++) 
            System.out.println(users.get(i).toString());	
		System.out.println();
	} 
	
	public static void loadAccountData()  {
		// structure of each record: 
		// account number, username (email) of account holder, account type (Standard or Saving), account_opening_date

		// in the ideal case, we will read from file or database, but let's hard-code for now
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
				"Account #", "username_of_account_holder", "type", "opening_date", "Balance"));
		System.out.println("--------------------------------------------------------------------------------");
		
		 for (Account account : accounts) {
		        System.out.println(account.toString() + " | $" + accountController.getBalance(account.getAccount_number()));
		
		System.out.println();}
	}
	
	public static void addTransaction(String account_number, double amount, Date transaction_date) { 
		Transaction aTransaction =  new Transaction(account_number, amount, Calendar.getInstance().getTime());
		transactions.add(aTransaction);
	}
	
	/**
	 * Calculate the balance of a given account (by its number). To do that, it needs to go over all transactions
	 * that match the account and get their sum total. For example, if an account has only two transactions in the 
	 * system, with values = $10.79 and $-140, the balance would be $-129.21
	 * 
	 * @param account_number
	 * @return A double value, being the balance of the account
	 */
	
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
	
	// TODO 12b: Prevent Transactions from Non-existent accounts
	
	
	
	//////////////////////////////////////////////////////
	public static void main(String[] args) {
		
		loadUserData();
		// let's print them all to see if they have been loaded (populated) properly
		printAllUsers();
		
		loadAccountData();
		// let's print them all to see if they have been loaded (populated) properly
		System.out.println("Accounts: initial state, after loading...");
		
		AccountController accountController = new AccountController(transactions);
		
		printAllAccounts(accountController);
		
		// let's do some activities on the populated accounts, add transactions, etc.
		// Deposit: adding a transaction with a positive value
		// Withdraw: adding a transaction with a negative value
		addTransaction("5495-1234", -50.21, Calendar.getInstance().getTime());
		System.out.println("Account: after the 1st addTransaction function call...");
		printAllAccounts(accountController);
		
		// and some more activities on the accounts
		addTransaction("5495-1234", 520.00, Calendar.getInstance().getTime());
		addTransaction("9999-1111", 21.00, Calendar.getInstance().getTime()); // it seems this account does not exist in the loaded (populated) data, 
											// but the addTransaction does not do that check, need to improve that function in future
		// let's print the accounts and their balance to see if the above transaction have impacted their balances
		System.out.println("Account: after the 2nd/3rd addTransaction function calls...");
		printAllAccounts(accountController);
		

	}

}
