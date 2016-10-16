package models;

import java.io.Serializable;
import java.util.UUID;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ticket")
public class Ticket implements Serializable {

	@XmlElement(name = "ID")
	private UUID ticketID;
	@XmlElement(name = "flight")
	private Flight flight;
	@XmlElement(name = "seatNo")
	private String seatNo;
	@XmlElement(name = "notes")
	private String notes;
	
	public Ticket()
	{
		
	}
	
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
