package tests;

import java.util.Date;

import model.Account;
import utils.TestUtils;

public class AccountTest {

	public static void testUserConstructor() {
		
		String test_account_number = "";
		String test_username_of_account= "my_password";
		String test_account_type = "Mike";
		Date test_account_opening_date= 2025-02-04;
		
		Account testAccount = new Account(test_account_number, test_username_of_account, test_account_type, test_account_opening_date);
		
		
	}
		
		public static void main(String[] args) {
			testUserConstructor();
		}
	}