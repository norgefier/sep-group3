package models;

import java.util.Date;
import java.util.UUID;

public class TravelPlan {

	private UUID planID;
	private String planName;
	private Date startDate;
	private Date endDate;
	private String description;
	private Ticket[] ticketList;
	private Booking[] bookingList;
	private Activity[] activityList;
	
	public TravelPlan(String name)
	{
		planName = name;
		planID = UUID.randomUUID();
		ticketList = new Ticket[0];
		bookingList = new Booking[0];
		activityList = new Activity[0];
	}

	public Booking[] getBookingList()
	{
		return bookingList;
	}
	
	public Ticket[] getTicketList()
	{
		return ticketList;
	}
	
	public Activity[] getAccomodationList()
	{
		return activityList;
	}
	
	public UUID getPlanID() {
		return planID;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void addTicket(Ticket ticket)
	{
		if(ticket != null)
		{
			Ticket newTicketList[] = new Ticket[ticketList.length+1];
			for(int i=0; i<ticketList.length; i++)
			{
				newTicketList[i] = ticketList[i];
			}
			newTicketList[ticketList.length] = ticket;
			ticketList = newTicketList;
		}
		else
		{
			throw new IllegalArgumentException("invalid username or password");
		}
	}
	
	public Ticket getTicket(UUID ticketID)
	{
		Ticket retTicket = null;
		boolean found = false;
		for(Ticket ticket : ticketList)
		{
			if( ticket.getTicketID() == ticketID)
			{
				retTicket = ticket;
				found = true;
			}
		}
		if(!found)
		{
			throw new IllegalArgumentException("Ticket with ID " + ticketID + " not found");
		}
		return retTicket;
	}
	
	public void delTicket(UUID ticketID)
	{
		Ticket newList[];
		for(int i = 0; i < ticketList.length; i++)
		{
			if(ticketList[i].getTicketID() == ticketID)
			{
				newList = new Ticket[ticketList.length-1];
				for(int n = 0; n < i; n++)
				{
					newList[n] = ticketList[n];
				}
				for(int n = i; n < newList.length; n++)
				{
					newList[n] = ticketList[n+1];
				}
				ticketList = newList;
			}
		}
	}
	
	public void addBooking(Booking booking)
	{
		if(booking != null)
		{
			Booking newBookingList[] = new Booking[bookingList.length+1];
			for(int i=0; i<bookingList.length; i++)
			{
				newBookingList[i] = bookingList[i];
			}
			newBookingList[bookingList.length] = booking;
			bookingList = newBookingList;
		}
		else
		{
			throw new IllegalArgumentException("Invalid booking");
		}
	}
	
	public Booking getBooking(UUID bookingID)
	{
		Booking retBooking = null;
		boolean found = false;
		for(Booking booking : bookingList)
		{
			if(booking != null && booking.getBookingID() == bookingID)
			{
				retBooking = booking;
				found = true;
			}
		}
		if(!found)
		{
			throw new IllegalArgumentException("Booking with ID " + bookingID + " not found");
		}
		return retBooking;
	}
	
	public void delBooking(UUID bookingID)
	{
		Booking newList[];
		for(int i = 0; i < bookingList.length; i++)
		{
			if(bookingList[i].getBookingID() == bookingID)
			{
				newList = new Booking[bookingList.length-1];
				for(int n = 0; n < i; n++)
				{
					newList[n] = bookingList[n];
				}
				for(int n = i; n < newList.length; n++)
				{
					newList[n] = bookingList[n+1];
				}
				bookingList = newList;
			}
		}
	}
	
	public void addActivity(Activity act)
	{
		if(act != null)
		{
			Activity newActList[] = new Activity[activityList.length+1];
			for(int i=0; i<activityList.length; i++)
			{
				newActList[i] = activityList[i];
			}
			newActList[activityList.length] = act;
			activityList = newActList;
		}
		else
		{
			throw new IllegalArgumentException("invalid username or password");
		}
	}
	
	public Activity getActivity(UUID actID)
	{
		Activity retAct = null;
		boolean found = false;
		for(Activity act : activityList)
		{
			if( act.getActivityID() == actID)
			{
				retAct = act;
				found = true;
			}
		}
		if(!found)
		{
			throw new IllegalArgumentException("Activity with ID " + actID + " not found");
		}
		return retAct;
	}
	
	public void delActivity(UUID actID)
	{
		Activity newList[];
		for(int i = 0; i < activityList.length; i++)
		{
			if(activityList[i].getActivityID() == actID)
			{
				newList = new Activity[activityList.length-1];
				for(int n = 0; n < i; n++)
				{
					newList[n] = activityList[n];
				}
				for(int n = i; n < newList.length; n++)
				{
					newList[n] = activityList[n+1];
				}
				activityList = newList;
			}
		}
	}
}
