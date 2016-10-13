package models;

import java.util.Date;
import java.util.UUID;

public class Booking {

	private UUID bookingID;
	private UUID accomID;
	private Accomodation accomodation;
	private Date checkInTime;
	private Date checkOutTime;
	private double price;
	private String notes;
	private boolean paid;
	
	public Booking(Accomodation accom)
	{
		this.accomodation = accom;
		this.bookingID = UUID.randomUUID();
	}

	public UUID getBookingID() {
		return bookingID;
	}

	public void setBookingID(UUID bookingID) {
		this.bookingID = bookingID;
	}

	public UUID getAccomID() {
		return accomID;
	}

	public void setAccomID(UUID accomID) {
		this.accomID = accomID;
	}

	public Date getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(Date checkInTime) {
		this.checkInTime = checkInTime;
	}

	public Date getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(Date checkOutTime) {
		this.checkOutTime = checkOutTime;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	
	public Accomodation getAccomodation()
	{
		return accomodation;
	}
	
	
	
}
