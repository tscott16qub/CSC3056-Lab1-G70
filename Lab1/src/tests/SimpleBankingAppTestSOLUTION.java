package tests;

import java.util.Calendar; 
import controller.AccountController;
import app.SimpleBankingAppSOLVED;
import utils.TestUtils;

public class SimpleBankingAppTestSOLUTION {
	
	private static AccountController accountController;
	
	public static void testLoadData() {
		
		SimpleBankingAppSOLVED.loadUserData();

		if (SimpleBankingAppSOLVED.users.size() == 3)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "testLoadData: loadUserData: TC1 passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "testLoadData: loadUserData: TC1 FAILED" + TestUtils.TEXT_COLOR_RESET);

		SimpleBankingAppSOLVED.loadAccountData();
		if (SimpleBankingAppSOLVED.accounts.size() == 4)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "testLoadData: loadAccountData: TC1 passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "testLoadData: loadAccountData: TC1 FAILED" + TestUtils.TEXT_COLOR_RESET);
		
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
		
		
		// 4-tear-down: put the system state back in where it was
		// read more about the tear-down phase of test cases: http://xunitpatterns.com/Four%20Phase%20Test.html
		SimpleBankingAppSOLVED.addTransaction("5495-1234", +withdrawalAmount, Calendar.getInstance().getTime());}
	
	public static void main(String[] args) {
		// we need to call our test cases (methods)
		testLoadData();
		testDeposits();
		testWithdrawals();
	}

}
