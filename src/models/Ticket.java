package models;

import java.util.UUID;

public class Ticket {

	private UUID ticketID;
	private Flight flight;
	private String seatNo;
	private String notes;
	
	public Ticket(Flight flight)
	{
		this.flight = flight;
		this.ticketID = UUID.randomUUID();
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public UUID getTicketID()
	{
		return ticketID;
	}
	
	
}
