package controller;

import java.util.List;
import model.User;

public class UserController {
	private List<User> users;
	
	public UserController(List<User> users) {
        this.users = users;
    }

	public void loadUserData() {
        User aUser = new User("mike", "my_passwd", "Mike", "Smith", "07771234567");
        users.add(aUser);
        
        aUser = new User("james.cameron@gmail.com", "angel", "James", "Cameron", "07777654321");
        users.add(aUser);
        
        aUser = new User("julia.roberts@gmail.com", "change_me", "Julia", "Roberts", "07770123456");
        users.add(aUser);
    }
	
	 public void printAllUsers() {
	        System.out.println("There are: " + users.size() + " users in the system.");
	        System.out.println(String.format("%-25s| %-15s| %-15s| %-15s| %-15s", 
	                "username", "password", "first_name", "last_name", "mobile_number"));
	        System.out.println("-------------------------------------------------------------------------------------------");
	        
	        for (User user : users) {
	            System.out.println(user.toString());
	        }
	        System.out.println();
	    }
	}