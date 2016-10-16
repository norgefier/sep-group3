package modelTests;

import static org.junit.Assert.*;

import org.junit.Test;

import models.Accomodation;
import models.Booking;
import models.TravelPlan;
import models.TravelPlanner;
import models.User;

public class AddBookingTest {

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
		
		//creates a new Accommodation
		Accomodation accom = new Accomodation("hotel");
		
		//creates a new Booking
		Booking booking = new Booking(accom);
		
		//adds the Booking to the travel plan
		plan.addBooking(booking);
		
		//adds the TravelPlan to the user
		user.addPlan(plan);
		
		//updates the user in the planner.
		planner.updateUser(user);
		
		//checks to make sure the Booking was added to the user in the planner object.
		assertEquals(planner.login(emailOne, passOne).getPlanList()[0].getBooking(booking.getBookingID()).getBookingID(), booking.getBookingID());
		
		assertEquals(planner.login(emailOne, passOne).getPlan(plan.getPlanID()).getBookingList().length, 1);
	}

}
