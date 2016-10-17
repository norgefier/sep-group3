package modelTests;

import static org.junit.Assert.*;

import org.junit.Test;

import models.Activity;
import models.TravelPlan;
import models.TravelPlanner;
import models.User;

public class UpdateTravelPlanTest {

	@Test
	public void test() {
		String emailOne = "jai-robinson@hotmail.com";
		String passOne = "jai1234";
		String planName = "Japan2017";
		String firstOne = "jai";
		String lastOne = "robinson";
		String noOne = "0498127843";
		
		//creates an instance of the application object
		TravelPlanner planner = new TravelPlanner();
		
		//create a new travel plan
		TravelPlan plan = new TravelPlan(planName);
		
		//adds a user to the application object
		planner.addUser(emailOne, passOne, firstOne, lastOne, noOne);
		
		//gets the user back from the application object
		User loggedUser = planner.login(emailOne, passOne);
		
		//adds the plan to the user
		loggedUser.addPlan(plan);
		
		//updates the application object with the users data.
		planner.updateUser(loggedUser);
		
		//checks to make sure the plan has been stored in the application object
		assertEquals(planner.login(emailOne, passOne).getPlanList()[0].getPlanName(), planName);
		
		//creates a new activity
		Activity act = new Activity("Nara");
		
		//adds the activity to the plan
		plan.addActivity(act);
		
		//updates the plan in the user object
		loggedUser.updatePlan(plan);
		
		//updates the users information in the application object
		planner.updateUser(loggedUser);
		
		//checks to make sure the activity was properly updated in the application object.
		assertEquals(planner.login(emailOne, passOne).getPlanList()[0].getActivity(act.getActivityID()).getActivityID(), act.getActivityID());
		
	}

}
