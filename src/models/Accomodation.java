package models;

import java.util.UUID;

public class Accomodation {

	private UUID accomID;
	private Booking booking;
	private String accomName;
	private String accomAddress;
	private String notes;
	
	public Accomodation()
	{
		
	}
	
	public Accomodation(String name)
	{
		this.accomName = name;
		this.accomID = UUID.randomUUID();
	}

	public UUID getAccomID() {
		return accomID;
	}

	public void setAccomID(UUID accomID) {
		this.accomID = accomID;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public String getAccomName() {
		return accomName;
	}

	public void setAccomName(String accomName) {
		this.accomName = accomName;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getAccomAddress() {
		return accomAddress;
	}

	public void setAccomAddress(String accomAddress) {
		this.accomAddress = accomAddress;
	}
	
	
	
}
