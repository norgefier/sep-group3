package modelTests;
import static org.junit.Assert.*;

import org.junit.Test;

import models.Flight;
import models.Ticket;
import models.TravelPlan;
import models.TravelPlanner;
import models.User;

public class DeleteTicketTest {

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
		Flight flightOne = new Flight();
		Flight flightTwo = new Flight();
		Flight flightThree = new Flight();
		
		//creates a new Ticket
		Ticket ticketOne = new Ticket(flightOne);
		Ticket ticketTwo = new Ticket(flightTwo);
		Ticket ticketThree = new Ticket(flightThree);
		
		//adds the Ticket to the travel plan
		plan.addTicket(ticketOne);
		plan.addTicket(ticketTwo);
		plan.addTicket(ticketThree);
		
		//adds the TravelPlan to the user
		user.addPlan(plan);
		
		//updates the user in the planner.
		planner.updateUser(user);
		
		//makes sure there are 3 tickets in the stored plan
		assertEquals(planner.login(emailOne, passOne).getPlan(plan.getPlanID()).getTicketList().length, 3);
		
		//checks to make sure the Tickets were added to the user in the planner object.
		assertEquals(planner.login(emailOne, passOne).getPlanList()[0].getTicket(ticketOne.getTicketID()).getTicketID(), ticketOne.getTicketID());
		assertEquals(planner.login(emailOne, passOne).getPlanList()[0].getTicket(ticketTwo.getTicketID()).getTicketID(), ticketTwo.getTicketID());
		assertEquals(planner.login(emailOne, passOne).getPlanList()[0].getTicket(ticketThree.getTicketID()).getTicketID(), ticketThree.getTicketID());
		
		//changes deletes one of the tickets from the plan.
		plan.delTicket(ticketOne.getTicketID());
		
		//update the user
		user.updatePlan(plan.getPlanID(), plan);
		
		//update the applciaiton object
		planner.updateUser(user);
		
		//ensures that deleting a non existent ticket throws an appropriate error
		try
		{
			planner.login(emailOne, passOne).getPlanList()[0].getTicket(ticketOne.getTicketID());
		}
		catch (Exception e)
		{
			assertEquals(e.getMessage(),"Ticket with ID " + ticketOne.getTicketID() + " not found");
		}
		
		//makes sure the other two added tickets are sill there.
		assertEquals(planner.login(emailOne, passOne).getPlanList()[0].getTicket(ticketTwo.getTicketID()).getTicketID(), ticketTwo.getTicketID());
		assertEquals(planner.login(emailOne, passOne).getPlanList()[0].getTicket(ticketThree.getTicketID()).getTicketID(), ticketThree.getTicketID());

	}

}
