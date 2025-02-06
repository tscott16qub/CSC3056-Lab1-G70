package utils;

public class TestUtils {
	
	public static final String TEXT_COLOR_GREEN = "\u001B[32m"; // from https://www.geeksforgeeks.org/how-to-print-colored-text-in-java-console/
    public static final String TEXT_COLOR_RED = "\u001B[31m"; 
    public static final String TEXT_COLOR_RESET = "\u001B[0m";
    
	public static void printTestPassed(String test_case_name) {
		System.out.println(TestUtils.TEXT_COLOR_GREEN + test_case_name + TestUtils.TEXT_COLOR_RESET);
		
	}
	public static void printTestFailed(String test_case_name) {
		System.out.println(TestUtils.TEXT_COLOR_RED + test_case_name + TestUtils.TEXT_COLOR_RESET);
		
	} 
	
}
