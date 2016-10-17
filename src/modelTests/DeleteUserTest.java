package modelTests;

import static org.junit.Assert.*;

import org.junit.Test;

import models.TravelPlanner;

public class DeleteUserTest {

	@Test
	public void test() {
		String emailOne = "jai.robinson@hotmail.com";
		String passOne = "jai1234";
		String firstOne = "jai";
		String lastOne = "robinson";
		String noOne = "0498127843";
		
		//creates planer
		TravelPlanner planner = new TravelPlanner();
		
		//adds the user
		planner.addUser(emailOne, passOne, firstOne, lastOne, noOne);
		
		//makes sure the user is there
		assertEquals(planner.login(emailOne, passOne).getEmailAddress(), emailOne);
		
		//deletes the user
		planner.getStoredUsers().deleteUser(emailOne);
		
		//makes sure the user is gone.
		try
		{
			planner.login(emailOne, passOne);
		}
		catch (Exception e)
		{
			assertEquals(e.getMessage(), "Email address or password is incorrect");
		}
	}

}
