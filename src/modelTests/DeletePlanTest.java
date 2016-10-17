package modelTests;

import static org.junit.Assert.*;

import org.junit.Test;

import models.TravelPlan;
import models.TravelPlanner;
import models.User;

public class DeletePlanTest {

	@Test
	public void test() {
		String emailOne = "jai-robinson@hotmail.com";
		String passOne = "jai1234";
		String firstOne = "jai";
		String lastOne = "robinson";
		String noOne = "0498127843";
		
		TravelPlanner planner = new TravelPlanner();
		
		planner.addUser(emailOne, passOne, firstOne, lastOne, noOne);
		
		User user = planner.login(emailOne, passOne);
		
		TravelPlan planOne = new TravelPlan("Japan");
		TravelPlan planTwo = new TravelPlan("London");
		
		user.addPlan(planOne);
		user.addPlan(planTwo);
		
		assertEquals(user.getPlan(planOne.getPlanID()).getPlanName(), planOne.getPlanName());
		assertEquals(user.getPlan(planTwo.getPlanID()).getPlanName(), planTwo.getPlanName());
		
		user.deletePlan(planOne);
		
		try
		{
			user.getPlan(planOne.getPlanID());
		}
		catch (Exception e)
		{
			assertEquals(e.getMessage(), "Travel plan with id: "+planOne.getPlanID()+" not found");
		}
	}

}
