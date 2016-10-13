package models;

public class Accomodation {

	private int accomID;
	private Booking booking;
	private String accomName;
	private String notes;
	
	public Accomodation()
	{}

	public int getAccomID() {
		return accomID;
	}

	public void setAccomID(int accomID) {
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
	
	
	
}
