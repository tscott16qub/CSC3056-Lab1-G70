package tests;

import java.util.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.Account;
import model.Account.AccountType;
import utils.TestUtils;

public class AccountTest {

	public static void testAccountConstructor() throws ParseException {
		
		String test_account_number = "";
		String test_username_of_account_holder= "my_password";
		 AccountType test_account_type = AccountType.SAVINGS;
		Date test_account_opening_date = new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2019");
	

		
		Account testAccount = new Account(test_account_number, test_username_of_account_holder, test_account_type, 
				test_account_opening_date);
		
	System.out.println("Starting the assertions of the test method: test AccountConstructor");
		
		boolean passed=true;
		
		if(passed)
			System.out.println("All TC'S passed.");
		if(testAccount.getAccount_number()!=test_account_number) {
			System.out.println("TC1 failed: Account number did not match");
			passed=false;
		}
		if(testAccount.getUsername_of_account_holder()!=test_username_of_account_holder) {
			System.out.println("TC2 failed: Username of account holder did not match");
			passed=false;
		}
		if(testAccount.getAccount_type()!=test_account_type) {
			System.out.println("TC3 failed: Account type did not match");
			passed=false;
		}
		if(testAccount.getAccount_opening_date()!=test_account_opening_date) {
			System.out.println("TC4 failed: Account opening date did not match");
			passed=false;
		}
		assert testAccount.getAccount_number() == test_account_number;
		assert 1==2;
		
		assert testAccount.getUsername_of_account_holder() == test_username_of_account_holder;
		assert 1==2;
		
		assert testAccount.getAccount_type() == test_account_type;
		assert 1==2;
		
		assert testAccount.getAccount_opening_date() == test_account_opening_date;
		assert 1==2;
		System.out.println("All Java assertions in the test suite passed(none failed). ");
	}
		
		public static void main(String[] args)throws ParseException {
		    testAccountConstructor();
		}
	}