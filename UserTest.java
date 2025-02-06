package tests;

import model.User;
import utils.TestUtils;

public class UserTest {

	public static void testUserConstructor() {

		/*
		 * User testUser = new User("mike","my_passwd", "Mike", "Smith", "07771234567"
		 * ); System.out.println(testUser);
		 */
		
		String test_username = "mike";
		String test_password = "my_password";
		String test_first_name = "Mike";
		String test_last_name = "Smith";
		String test_mobile_number = "07771234567";

		User testUser = new User(test_username, test_password, test_first_name, test_last_name, test_mobile_number);

		System.out.println("Starting the assertion of the test method: testUserConstructor");

		/*if (testUser.getUsername() == test_username)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-getUsername-Passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getUsername-FAILED" + TestUtils.TEXT_COLOR_RESET);
		
		*/
		
		/*if (testUser.getPassword() == test_password)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-getpassword-Passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getpassword-FAILED" + TestUtils.TEXT_COLOR_RESET);
		
		if (testUser.getFirst_name() == test_first_name)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-getFirst_name-Passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getFirst_name-FAILED" + TestUtils.TEXT_COLOR_RESET);
		
		if (testUser.getLast_name() == test_last_name)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-getLast_name-Passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getLast_name-FAILED" + TestUtils.TEXT_COLOR_RESET);
		
		if (testUser.getMobile_number() == test_mobile_number)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-getMobile_number-Passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getMobile_number-FAILED" + TestUtils.TEXT_COLOR_RESET);
		
		*/
		
		//Todo-3
		/*String test_case_name = "TC1-getUsername";
		if(testUser.getUsername()== test_username)
			TestUtils.printTestPassed(test_case_name);
		else
			TestUtils.printTestFailed(test_case_name);
		
		 test_case_name = "TC2-password";
		if(testUser.getPassword()== test_password)
			TestUtils.printTestPassed(test_case_name);
		else
			TestUtils.printTestFailed(test_case_name);
		
		test_case_name = "TC3-FirstName";
		if(testUser.getFirst_name()== test_first_name)
			TestUtils.printTestPassed(test_case_name);
		else
			TestUtils.printTestFailed(test_case_name);
		
		test_case_name = "TC4-LastName";
		if(testUser.getLast_name()== test_last_name)
			TestUtils.printTestPassed(test_case_name);
		else
			TestUtils.printTestFailed(test_case_name);
		
		test_case_name = "TC5-MobileNumber";
		if(testUser.getMobile_number()== test_mobile_number)
			TestUtils.printTestPassed(test_case_name);
		else
			TestUtils.printTestFailed(test_case_name);*/
		
		
		if(passed)
			System.out.println("All TC'S passed.");
		if(testUser.getFirst_name()!= test_first_name) {
			System.out.println("TC3 failed: first_name did not match");
			passed = false;
		}
		if (testUser.getLast_name()!= test_last_name) {
			System.out.println("TC4 failed: last_name did not match");
			passed = false;
		}
		if(testUser.getMobile_number() != test_mobile_number) {
			System.out.println("TC5 failed: mobile_number did not match ");
			passed = false;
		}
		
		
		
		assert testUser.getUsername() == test_username;
		assert 1==2;
		System.out.println("All Java assertions in the test suite passed(none failed). ");
		
		
		/*assert testUser.getPassword() == test_password;
		 * assert 1==2;
		System.out.println("All Java assertions in the test suite passed(none failed). ");
		
		assert testUser.getFirst_name() == test_first_name;
		assert 1==2;
		System.out.println("All Java assertions in the test suite passed(none failed). ");
		
		assert testUser.getLast_name() == test_last_name;
		assert 1==2;
		System.out.println("All Java assertions in the test suite passed(none failed). ");
		
		assert testUser.getMobile_number() == test_mobile_number;
		assert 1==2;
		System.out.println("All Java assertions in the test suite passed(none failed). ");
*/


			


	}
	
	public static void main(String[] args) {
		testUserConstructor();
	}
}

