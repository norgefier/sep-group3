package modelTests;

import static org.junit.Assert.*;

import org.junit.Test;

import models.Activity;
import models.TravelPlan;
import models.TravelPlanner;
import models.User;

public class DeleteActivityTest {

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
		Activity actOne = new Activity("Nara");
		Activity actTwo = new Activity("Universal Studios");
		Activity actThree = new Activity("Parasite Museum");
		
		//adds the activity to the travel plan
		plan.addActivity(actOne);
		plan.addActivity(actTwo);
		plan.addActivity(actThree);
		
		//adds the TravelPlan to the user
		user.addPlan(plan);
		
		//updates the user in the planner.
		planner.updateUser(user);
		
		//checks to make sure the Activities were added to the user in the planner object.
		assertEquals(planner.login(emailOne, passOne).getPlanList()[0].getActivity(actOne.getActivityID()).getActivityID(), actOne.getActivityID());
		assertEquals(planner.login(emailOne, passOne).getPlanList()[0].getActivity(actTwo.getActivityID()).getActivityID(), actTwo.getActivityID());
		assertEquals(planner.login(emailOne, passOne).getPlanList()[0].getActivity(actThree.getActivityID()).getActivityID(), actThree.getActivityID());
		
		//delete one of the activities
		plan.delActivity(actOne.getActivityID());
		
		//update the user
		user.updatePlan(plan.getPlanID(), plan);
		
		//update the planner
		planner.updateUser(user);
		
		//ensure that the deleted Activity is gone
		try
		{
			planner.login(emailOne, passOne).getPlan(plan.getPlanID()).getActivity(actOne.getActivityID());
		}
		catch (Exception e)
		{
			assertEquals(e.getMessage(), "Activity with ID " + actOne.getActivityID() + " not found");
		}
		
		//makes sure the other two added Activities are still there
		assertEquals(planner.login(emailOne, passOne).getPlanList()[0].getActivity(actTwo.getActivityID()).getActivityID(), actTwo.getActivityID());
		assertEquals(planner.login(emailOne, passOne).getPlanList()[0].getActivity(actThree.getActivityID()).getActivityID(), actThree.getActivityID());
	}

}
