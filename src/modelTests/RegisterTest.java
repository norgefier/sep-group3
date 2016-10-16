package modelTests;

import static org.junit.Assert.*;

import org.junit.Test;

import models.TravelPlanner;

public class RegisterTest {

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
		
		//tests adding three users
		planner.addUser(emailOne, passOne, firstOne, lastOne, noOne);
		planner.addUser(emailTwo, passTwo, firstTwo, lastTwo, noTwo);
		planner.addUser(emailThree,passThree, firstThree, lastThree, noThree);
		
		//checks to make sure the three added users exist
		assertEquals(planner.login(emailOne, passOne).getEmailAddress(), emailOne);
		assertEquals(planner.login(emailTwo, passTwo).getEmailAddress(), emailTwo);
		assertEquals(planner.login(emailThree, passThree).getEmailAddress(), emailThree);
		
		//checks to make sure same user cannot be added twice
		try
		{
			planner.addUser(emailOne, passOne, firstOne, lastOne, noOne);
		}
		catch (Exception e)
		{
			assertEquals(e.getMessage(), "Email address is already in use");
		}
	}

}
