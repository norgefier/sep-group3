package modelTests;

import static org.junit.Assert.*;

import org.junit.Test;

import models.Accomodation;
import models.Booking;
import models.TravelPlan;
import models.TravelPlanner;
import models.User;

public class DeleteBookingTest {

	@Test
	public void test() {
		String emailOne = "jai-robinson@hotmail.com";
		String passOne = "jai1234";
		String planName = "Japan2017";
		String first = "jai";
		String last = "robinson";
		String no = "0498127843";
		
		//creates a TravelPlanner
		TravelPlanner planner = new TravelPlanner();
		
		//creates a TravelPlan
		TravelPlan plan = new TravelPlan(planName);
		
		//adds a User to the Planner
		planner.addUser(emailOne, passOne, first, last, no);
		
		User user = new User(emailOne, passOne, first, last, no);
		
		//creates a new Accommodation
		Accomodation accomOne = new Accomodation("hotel");
		Accomodation accomTwo = new Accomodation("hotel");
		Accomodation accomThree = new Accomodation("hotel");
		
		//creates a new Booking
		Booking bookingOne = new Booking(accomOne);
		Booking bookingTwo = new Booking(accomTwo);
		Booking bookingThree = new Booking(accomThree);
		
		//adds the Booking to the travel plan
		plan.addBooking(bookingOne);
		plan.addBooking(bookingTwo);
		plan.addBooking(bookingThree);
		
		//ensures all Bookings are added
		assertEquals(plan.getBookingList().length, 3);
		
		//adds the TravelPlan to the user
		user.addPlan(plan);
		
		//updates the User in the Planner.
		planner.updateUser(user);
		
		//ensures all Bookings where added to the planner object
		assertEquals(planner.login(emailOne, passOne).getPlan(plan.getPlanID()).getBookingList().length, 3);
		
		//checks to make sure the Bookings were added to the user in the planner object.
		assertEquals(planner.login(emailOne, passOne).getPlan(plan.getPlanID()).getBooking(bookingOne.getBookingID()).getBookingID(), bookingOne.getBookingID());
		assertEquals(planner.login(emailOne, passOne).getPlanList()[0].getBooking(bookingTwo.getBookingID()).getBookingID(), bookingTwo.getBookingID());
		assertEquals(planner.login(emailOne, passOne).getPlanList()[0].getBooking(bookingThree.getBookingID()).getBookingID(), bookingThree.getBookingID());
		
		//changes deletes one of the Bookings from the plan.
		plan.delBooking(bookingOne.getBookingID());
		
		//update the user
		user.updatePlan(plan.getPlanID(), plan);
		
		//update the planner
		planner.updateUser(user);
		
		//ensures that deleting a non existent Booking throws an appropriate error
		try
		{
			planner.login(emailOne, passOne).getPlanList()[0].getBooking(bookingOne.getBookingID());
		}
		catch (Exception e)
		{
			assertEquals(e.getMessage(),"Booking with ID " + bookingOne.getBookingID() + " not found");
		}
		
		//makes sure the other two added Bookings are sill there.
		assertEquals(planner.login(emailOne, passOne).getPlanList()[0].getBooking(bookingTwo.getBookingID()).getBookingID(), bookingTwo.getBookingID());
		assertEquals(planner.login(emailOne, passOne).getPlanList()[0].getBooking(bookingThree.getBookingID()).getBookingID(), bookingThree.getBookingID());
	}

}
