package modelTests;

import static org.junit.Assert.*;

import org.junit.Test;

import models.Activity;
import models.TravelPlan;
import models.TravelPlanner;
import models.User;

public class AddActivityTest {

	@Test
	public void test() {
		String emailOne = "jai-robinson@hotmail.com";
		String passOne = "jai1234";
		String planName = "Japan2017";
		String first = "jai";
		String last = "robinson";
		String no = "0498127843";
		
		//creates a travel planner
		TravelPlanner planner = new TravelPlanner();
		
		//creates a travel plan
		TravelPlan plan = new TravelPlan(planName);
		
		//adds a user to the planner
		planner.addUser(emailOne, passOne, first, last, no);
		
		User user = new User(emailOne, passOne, first, last, no);
		
		//creates a new Activity
		Activity act = new Activity("Nara");
		
		//adds the activity to the travel plan
		plan.addActivity(act);
		
		//adds the TravelPlan to the user
		user.addPlan(plan);
		
		//updates the user in the planner.
		planner.updateUser(user);
		
		//checks to make sure the Activity was added to the user in the planner object.
		assertEquals(planner.login(emailOne, passOne).getPlanList()[0].getActivity(act.getActivityID()).getActivityID(), act.getActivityID());
		
	}

}
