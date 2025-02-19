package tests;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import controller.AccountController;
import controller.UserController;
import app.SimpleBankingAppSOLVED;
import utils.TestUtils;
import model.Account;
import model.Transaction;
import model.User;

public class SimpleBankingAppTestSOLUTION {
	
	private static AccountController accountController;
    private static UserController userController;
    private static List<User> users;
    private static List<Account> accounts;
    private static List<Transaction> transactions;
    
    static {
        users = new ArrayList<>();
        accounts = new ArrayList<>();
        transactions = new ArrayList<>();
        userController = new UserController(users);
        accountController = new AccountController(transactions);
    }
	
	public static void testLoadData() {
		 if (userController == null) {
	            System.out.println(TestUtils.TEXT_COLOR_RED + "Error: userController is null" + TestUtils.TEXT_COLOR_RESET);
	            return; }
		
		 userController.loadUserData();

		if (SimpleBankingAppSOLVED.users.size() == 3)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "testLoadData: loadUserData: TC1 passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "testLoadData: loadUserData: TC1 FAILED" + TestUtils.TEXT_COLOR_RESET);

		SimpleBankingAppSOLVED.loadAccountData();
		if (SimpleBankingAppSOLVED.accounts.size() == 4)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "testLoadData: loadAccountData: TC2 passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "testLoadData: loadAccountData: TC2 FAILED" + TestUtils.TEXT_COLOR_RESET);
		
		 accountController = new AccountController(SimpleBankingAppSOLVED.transactions);
	}
	
	// this test method (test case) verifies if the Deposit feature works properly
	public static void testDeposits() {
		// 1-Setup phase
		double balanceBefore = accountController.getBalance("5495-1234");
		double depositAmount = 50.21;
		
		// 2-Exercise phase
		SimpleBankingAppSOLVED.addTransaction("5495-1234", depositAmount, Calendar.getInstance().getTime());
		 double balanceAfter = accountController.getBalance("5495-1234");
		
		// 3-verify
		assert balanceBefore + depositAmount == balanceAfter;
		if (balanceBefore + depositAmount == balanceAfter)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "testDeposits: TC1 passed"+ TestUtils.TEXT_COLOR_RESET);
		else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "testDeposits: TC1 FAILED XXX: balanceBefore + depositAmount != balanceAfter");
			System.out.format("testDeposits: balanceBefore = %.2f ; depositAmount = %.2f ; balanceAfter = %.2f %s\n", 
					balanceBefore , depositAmount , balanceAfter, TestUtils.TEXT_COLOR_RESET);
		}
		
		// 4-tear-down: put the system state back in where it was
		// read more about the tear-down phase of test cases: http://xunitpatterns.com/Four%20Phase%20Test.html
		SimpleBankingAppSOLVED.addTransaction("5495-1234", -depositAmount, Calendar.getInstance().getTime());
	}
	
	public static void testWithdrawals() {
		// 1-Setup phase
		 double balanceBefore = accountController.getBalance("5495-1234");
		double withdrawalAmount = 20.10;
		
		// 2-Exercise phase
		SimpleBankingAppSOLVED.addTransaction("5495-1234", -withdrawalAmount, Calendar.getInstance().getTime());
		double balanceAfter = accountController.getBalance("5495-1234");
		
		// 3-verify
		assert balanceBefore - withdrawalAmount == balanceAfter;
		if (balanceBefore - withdrawalAmount == balanceAfter)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "testWithdrawals: TC1 passed"+ TestUtils.TEXT_COLOR_RESET);
		else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "testWithdrawals: TC1 FAILED XXX: balanceBefore - WithdrawalAmount != balanceAfter");
			System.out.format("testWithdrawals: balanceBefore = %.2f ; WithdrawalAmount = %.2f ; balanceAfter = %.2f %s\n", 
					balanceBefore , withdrawalAmount , balanceAfter, TestUtils.TEXT_COLOR_RESET);
		}
		
		
		
		SimpleBankingAppSOLVED.addTransaction("5495-1234", +withdrawalAmount, Calendar.getInstance().getTime());}
	
	public static void testPrintUserAccounts() {
	    System.out.println("\n==== Running testPrintUserAccounts ====");

	    System.out.println("Test Case 1: User with accounts");
	    printUserAccounts("David");  // Expected: Two accounts for "user1"

	    System.out.println("\nTest Case 2: User with NO accounts");
	    printUserAccounts("nonexistentUser");  

	    
	    System.out.println("\nTest Case 3: No accounts available");
	    accounts.clear();
	    printUserAccounts("David");  
	}
	
	// TODO 12a: Display accounts for a specific user
	public static void printUserAccounts(String username) {
	    System.out.println("Accounts for user: " + username);
	    System.out.println("---------------------------------");

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
	public static void testInvalidAccountTransaction() {
	    System.out.println("\n===== Running testInvalidAccountTransaction =====");

	    String validAccount = "5495-1234";  
	    String invalidAccount = "9999-1111";  
	    double amount = 50.00;
	    
	    double balanceBeforeValid = accountController.getBalance(validAccount);
	    SimpleBankingAppSOLVED.addTransaction(validAccount, amount, Calendar.getInstance().getTime());
	    double balanceAfterValid = accountController.getBalance(validAccount);
	    
	    assert balanceAfterValid == balanceBeforeValid + amount;
	    if (balanceAfterValid == balanceBeforeValid + amount)
	        System.out.println(TestUtils.TEXT_COLOR_GREEN + "Valid account transaction test PASSED!" + TestUtils.TEXT_COLOR_RESET);
	    else
	        System.out.println(TestUtils.TEXT_COLOR_RED + "Valid account transaction test FAILED!" + TestUtils.TEXT_COLOR_RESET);
	     
	    int transactionsBeforeInvalid = SimpleBankingAppSOLVED.transactions.size();
	    SimpleBankingAppSOLVED.addTransaction(invalidAccount, amount, Calendar.getInstance().getTime());
	    int transactionsAfterInvalid = SimpleBankingAppSOLVED.transactions.size();
	    
	    assert transactionsBeforeInvalid == transactionsAfterInvalid;  // No new transaction should be added
	    if (transactionsBeforeInvalid == transactionsAfterInvalid)
	        System.out.println(TestUtils.TEXT_COLOR_GREEN + "Invalid account transaction test PASSED!" + TestUtils.TEXT_COLOR_RESET);
	    else
	        System.out.println(TestUtils.TEXT_COLOR_RED + "Invalid account transaction test FAILED!" + TestUtils.TEXT_COLOR_RESET);
	}
	

	public static void main(String[] args) {
		// we need to call our test cases (methods)
		testLoadData();
		testDeposits();
		testWithdrawals();
		testPrintUserAccounts();
		testInvalidAccountTransaction();
	}

}
