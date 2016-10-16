package modelTests;

import static org.junit.Assert.*;

import org.junit.Test;

import models.TravelPlanner;
import models.User;

public class UpdateUserTest {

	@Test
	public void test() {
		String emailOne = "jai-robinson@hotmail.com";
		String passOne = "jai1234";
		String passTwo = "jai0987";
		String firstOne = "jai";
		String lastOne = "robinson";
		String noOne = "0498127843";
		
		TravelPlanner planner = new TravelPlanner();
		
		planner.addUser(emailOne, passOne, firstOne, lastOne, noOne);
		
		User loggedUser = planner.login(emailOne, passOne);
		
		//checks the login method on first User
		assertEquals(planner.login(emailOne, passOne).getEmailAddress(), emailOne);
		assertEquals(planner.login(emailOne, passOne).getPassword(), passOne);
		
		//changes the password of the user
		loggedUser.setPassword(passTwo);
		
		//updates the user in the planner
		planner.updateUser(loggedUser);
		
		//checks the login method for the user with the new password
		assertEquals(planner.login(emailOne, passTwo).getEmailAddress(), emailOne);
		assertEquals(planner.login(emailOne, passTwo).getPassword(), passTwo);
		
	}

}
