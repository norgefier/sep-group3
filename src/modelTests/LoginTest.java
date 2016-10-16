package modelTests;

import static org.junit.Assert.*;

import org.junit.Test;

import models.TravelPlanner;

public class LoginTest {

	@Test
	public void test() {
		
		String emailOne = "jai-robinson@hotmail.com";
		String passOne = "jai1234";
		String firstOne = "jai";
		String lastOne = "robinson";
		String noOne = "0498127843";
		
		String emailTwo = "ben.stiller@hotmail.com";
		String passTwo = "ben1234";
		String firstTwo = "ben";
		String lastTwo = "stiller";
		String noTwo = "0494527843";
		
		String emailThree = "greg.benson@hotmail.com";
		String passThree = "greg1234";
		String firstThree = "greg";
		String lastThree = "benson";
		String noThree = "0498125643";
		
		TravelPlanner planner = new TravelPlanner();
		
		planner.addUser(emailOne, passOne, firstOne, lastOne, noOne);
		planner.addUser(emailTwo, passTwo, firstTwo, lastTwo, noTwo);
		planner.addUser(emailThree,passThree, firstThree, lastThree, noThree);
		
		//Checks the planner object
		assertNotNull(planner);
		
		//checks the login method on first User
		assertEquals(planner.login(emailOne, passOne).getEmailAddress(), emailOne);
		assertEquals(planner.login(emailOne, passOne).getPassword(), passOne);
		
		//checks the login method for second User
		assertEquals(planner.login(emailTwo, passTwo).getEmailAddress(), emailTwo);
		assertEquals(planner.login(emailTwo, passTwo).getPassword(), passTwo);
		
		//checks the login method for third User
		assertEquals(planner.login(emailThree, passThree).getEmailAddress(), emailThree);
		assertEquals(planner.login(emailThree, passThree).getPassword(), passThree);
		
		//checks the login method throws the correct exception when given an incorrect password and email combination
		try
		{
			planner.login(emailThree, passTwo);
		}
		catch (Exception e)
		{
			assertEquals(e.getMessage(), "Email address or password is incorrect");
		}
		
		
		//checks the login method throws the correct exception when given no input as a password
		try
		{
			planner.login(emailThree, "");
		}
		catch (Exception e)
		{
			assertEquals(e.getMessage(), "Email address or password is incorrect");
		}
		
		//checks the login method throws the correct exception when given no input as a email
		try
		{
			planner.login("", passTwo);
		}
		catch (Exception e)
		{
			assertEquals(e.getMessage(), "Email address or password is incorrect");
		}
	}

}
