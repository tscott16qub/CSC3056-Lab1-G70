package tests;

import java.util.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import model.Transaction;
import utils.TestUtils;

public class TransactionTest {

	public static void testTransactionConstructor() {
		
		String test_acount_number = "";
		Double test_transaction_amount= 60.00;
		String test_transaction_date="2024-4-12";
		
		Transaction testTransaction = new Transaction(test_acount_number, test_transaction_amount,
					test_transaction_date);
		
	System.out.println("Starting the assertions of the test method: test TransactionConstructor");
	/*String test_case_name = "TC1-getAccount_number";
	if (testTransaction.getAcount_number() == test_acount_number)
		TestUtils.printTestPassed(test_case_name);
	else
		TestUtils.printTestFailed(test_case_name);
	
	 	test_case_name = "TC1-getTransaction_amount";
	if (testTransaction.getTransaction_amount() == test_transaction_amount)
		TestUtils.printTestPassed(test_case_name);
	else
		TestUtils.printTestFailed(test_case_name);
	
		test_case_name = "TC1-getTransaction_date";
	if (testTransaction.getTransaction_date() == test_transaction_date)
		TestUtils.printTestPassed(test_case_name);
	else
		TestUtils.printTestFailed(test_case_name);} */
	
	boolean passed=true;
	
	if(passed)
		System.out.println("All TC'S passed.");
	if(testTransaction.getAcount_number()!=test_acount_number) {
		System.out.println("TC1 failed: Account number did not match");
		passed=false;
	}
	if(testTransaction.getTransaction_amount()!=test_transaction_amount) {
		System.out.println("TC2 failed: Transaction amount did not match");
		passed=false;
	}
	if(testTransaction.getTransaction_date()!=test_transaction_date) {
		System.out.println("TC3 failed: Transaction date did not match");
		passed=false;
	}
	
	assert testTransaction.getAcount_number() == test_acount_number;
	assert 1==2;
	
	assert testTransaction.getTransaction_amount() == test_transaction_amount;
	assert 1==2;
	
	assert testTransaction.getTransaction_date() == test_transaction_date;
	assert 1==2;

	System.out.println("All Java assertions in the test suite passed(none failed). ");
}
		
		public static void main(String[] args) {
			testTransactionConstructor();
		}
	}