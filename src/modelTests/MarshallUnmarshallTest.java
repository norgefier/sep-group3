package modelTests;

import static org.junit.Assert.*;

import org.junit.Test;

import models.TravelPlanner;
import models.User;

public class MarshallUnmarshallTest {

	@Test
	public void test() {
		String emailOne = "jai-robinson@hotmail.com";
		String passOne = "jai1234";
		
		String emailTwo = "ben.stiller@hotmail.com";
		String passTwo = "ben1234";
		
		String emailThree = "greg.benson@hotmail.com";
		String passThree = "greg1234";
		
		TravelPlanner planner = new TravelPlanner();
		planner.setFilePath("WebContent/WEB-INF/stored_polls.xml");
		
		//tests to see if the user is there
		assertEquals(planner.login(emailOne, passOne).getEmailAddress(), emailOne);
		
		//checks to make sure all the users loaded from the default population file
		assertEquals(planner.getUsers().length, 3);
		
		//grabs a copy of the user before its deleted, so it can be replaced
		User delUser = planner.login(emailOne, passOne);
		
		//deletes the user from the planner
		planner.getStoredUsers().deleteUser(emailOne);
		
		//checks to make sure one of the users was deleted
		assertEquals(planner.getUsers().length, 2);
		
		//checks to make sure the correct user was removed and no others.
		planner.login(emailTwo, passTwo);
		planner.login(emailThree, passThree);
		
		//checks to make sure the user is deleted
		try
		{
			planner.login(emailOne, passOne);
		}
		catch (Exception e)
		{
			assertEquals(e.getMessage(), "Email address or password is incorrect");
		}
		
		//writes the new data to XML
		planner.save();
		
		//creates another planner.
		TravelPlanner plannerTwo = new TravelPlanner();
		//loads the data from the XML file into the planner.
		plannerTwo.setFilePath("WebContent/WEB-INF/stored_polls.xml");
		
		//makes sure the user is still deleted
		try
		{
			plannerTwo.login(emailOne, passOne);
		}
		catch (Exception e)
		{
			assertEquals(e.getMessage(), "Email address or password is incorrect");
		}
		
		//adds the user back to the planner
		planner.addUser(delUser.getEmailAddress(), delUser.getPassword(), delUser.getFirstName(), delUser.getLastName(), delUser.getMobileNo());
		planner.updateUser(delUser);
		
		//makes sure the user is there
		User user = planner.login(emailOne, passOne);
		
		//saves the information to XML
		planner.save();
		
		//reloads the XML into the second planner
		plannerTwo.setFilePath("WebContent/WEB-INF/stored_polls.xml");
		
		//checks to see if the user is now in the planner
		assertEquals(user.getEmailAddress(), plannerTwo.login(emailOne, passOne).getEmailAddress());
		
		
	}

}
