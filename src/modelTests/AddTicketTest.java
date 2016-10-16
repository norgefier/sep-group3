package modelTests;
import static org.junit.Assert.*;

import org.junit.Test;

import models.Flight;
import models.Ticket;
import models.TravelPlan;
import models.TravelPlanner;
import models.User;

public class AddTicketTest {

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
		
		//creates a new Flight
		Flight flight = new Flight();
		
		//creates a new Ticket
		Ticket ticket = new Ticket(flight);
		
		//adds the Ticket to the travel plan
		plan.addTicket(ticket);
		
		//adds the TravelPlan to the user
		user.addPlan(plan);
		
		//updates the user in the planner.
		planner.updateUser(user);
		
		//checks to make sure the Ticket was added to the user in the planner object.
		assertEquals(planner.login(emailOne, passOne).getPlanList()[0].getTicket(ticket.getTicketID()).getTicketID(), ticket.getTicketID());
	}

}
