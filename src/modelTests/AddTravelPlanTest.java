package modelTests;

import static org.junit.Assert.*;

import org.junit.Test;

import models.TravelPlan;
import models.TravelPlanner;
import models.User;

public class AddTravelPlanTest {

	@Test
	public void test() {
		String emailOne = "jai-robinson@hotmail.com";
		String passOne = "jai1234";
		String planName = "Japan2017";
		String first = "jai";
		String last = "robinson";
		String no = "0498127843";
		
		//creates an instance of the application
		TravelPlanner planner = new TravelPlanner();
		
		//create a new Travel plan
		TravelPlan plan = new TravelPlan(planName);
		
		//adds a user to the application
		planner.addUser(emailOne, passOne, first, last, no);
		
		//gets the user from the planner
		User loggedUser = planner.login(emailOne, passOne);
		
		//adds the Travel Plan to the user
		loggedUser.addPlan(plan);
		
		//updates the users data in the application object
		planner.updateUser(loggedUser);
		
		//checks to make sure the data was saved to the application object.
		assertEquals(planner.login(emailOne, passOne).getPlanList()[0].getPlanName(), planName);
	}

}
