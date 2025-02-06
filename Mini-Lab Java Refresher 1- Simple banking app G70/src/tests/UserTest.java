package tests;

import model.User;
import utils.TestUtils;

public class UserTest {

	public static void testUserConstructor() {
		
	String test_username = "mike";
	String test_password = "my_password";
	String test_first_name = "Mike";
	String test_last_name = "Smith";
	String test_mobile_number = "07771234567";
	
	User testUser = new User(test_username, test_password, test_first_name, test_last_name,
			test_mobile_number);
	
	System.out.println("Starting the assertions of the test method: test UserConstructor");
	String test_case_name = "TC1-getUsername";
	if (testUser.getUsername() == test_username)
		//System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-getUsername-Passed" + TestUtils.TEXT_COLOR_RESET);
		TestUtils.printTestPassed(test_case_name);
	else
		//System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getUsername-FAILED" + TestUtils.TEXT_COLOR_RESET);
		TestUtils.printTestFailed(test_case_name);
	
	 	test_case_name = "TC1-getPassword";
	if (testUser.getPassword() == test_password)
		//System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-Password-Passed" + TestUtils.TEXT_COLOR_RESET);
		TestUtils.printTestPassed(test_case_name);
	else
		//System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getPassword-FAILED" + TestUtils.TEXT_COLOR_RESET);
		TestUtils.printTestFailed(test_case_name);
	
		test_case_name = "TC1-getFirst_name";
	if (testUser.getFirst_name() == test_first_name)
		//System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-Password-Passed" + TestUtils.TEXT_COLOR_RESET);
		TestUtils.printTestPassed(test_case_name);
	else
		//System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getPassword-FAILED" + TestUtils.TEXT_COLOR_RESET);
		TestUtils.printTestFailed(test_case_name);
	
		test_case_name = "TC1-getLast_name";
	if (testUser.getLast_name() == test_last_name)
		//System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-Password-Passed" + TestUtils.TEXT_COLOR_RESET);
		TestUtils.printTestPassed(test_case_name);
	else
		//System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getPassword-FAILED" + TestUtils.TEXT_COLOR_RESET);
		TestUtils.printTestFailed(test_case_name);
	
		test_case_name = "TC1-getmobile_number";
	if (testUser.getMobile_number() == test_mobile_number)
		//System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-Password-Passed" + TestUtils.TEXT_COLOR_RESET);
		TestUtils.printTestPassed(test_case_name);
	else
		//System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getPassword-FAILED" + TestUtils.TEXT_COLOR_RESET);
		TestUtils.printTestFailed(test_case_name); }
	
	public static void main(String[] args) {
		testUserConstructor();
	}}
