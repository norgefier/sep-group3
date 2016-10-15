package models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Booking {

	private UUID bookingID;
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

	public String getCheckInDate() {
		String dateTime;
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm a zzz");
		dateTime = dateFormat.format(checkInTime);
		return dateTime;
	}

	public void setCheckInDate(String date, String time) throws ParseException
	{
		java.util.Calendar cal = java.util.Calendar.getInstance();
		String dateTimeString = new java.text.SimpleDateFormat("EEEE, "+date+time).format(cal.getTime());
		SimpleDateFormat formatter = new SimpleDateFormat("EEEE, dd/MM/yyyy/hh:mm:ss");
		Date dateTime = formatter.parse(dateTimeString);
		this.checkInTime = dateTime;
	}

	public String getCheckOutTime() {
		String dateTime;
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm a zzz");
		dateTime = dateFormat.format(checkOutTime);
		return dateTime;
	}

	public void setCheckOutDate(String date, String time) throws ParseException
	{
		java.util.Calendar cal = java.util.Calendar.getInstance();
		String dateTimeString = new java.text.SimpleDateFormat("EEEE, "+date+time).format(cal.getTime());
		SimpleDateFormat formatter = new SimpleDateFormat("EEEE, dd/MM/yyyy/hh:mm:ss");
		Date dateTime = formatter.parse(dateTimeString);
		this.checkOutTime = dateTime;
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
