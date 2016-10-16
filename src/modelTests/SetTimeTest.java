package modelTests;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;

import models.Accomodation;
import models.Activity;
import models.Booking;
import models.Flight;

public class SetTimeTest {

	@Test
	public void test() {
		Accomodation newAccom = new Accomodation("hotel");
		Booking newBooking = new Booking(newAccom);
		
		try {
			newBooking.setCheckInDate("21/10/1991", "22:10:00");
		} catch (ParseException e) {
			assertTrue(e == null);
			
		}
		
		assertEquals(newBooking.getCheckInDate(), "21/10/1991 10:10 PM AEST");
		
		Flight flight = new Flight();
		try {
			flight.setArrDate("20/09/2020", "13:30:00");
		} catch (ParseException e) {
			assertTrue(e == null);
		}
		
		assertEquals(flight.getArrDate(), "20/09/2020 01:30 PM AEST");
		
		Activity act = new Activity("universal studios");
		try {
			act.setActivityStartTime("06/09/2013", "09:00:00");
		} catch (ParseException e) {
			assertTrue(e == null);
		}
		
		assertEquals(act.getActivityStartTime(), "06/09/2013 09:00 AM AEST");
		
	}

}
