package models;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "flight")
public class Flight implements Serializable {
	
	@XmlElement(name = "ID")
	private UUID flightID;
	@XmlElement(name = "flightNo")
	private String flightNo;
	@XmlElement(name = "airline")
	private String airline;
	@XmlElement(name = "depDate")
	private Date depDate;
	@XmlElement(name = "depLLoc")
	private String depLoc;
	@XmlElement(name = "arrDate")
	private Date arrDate;
	@XmlElement(name = "arrLoc")
	private String arrLoc;
	
	
	public Flight()
	{
		this.flightID = UUID.randomUUID();
	}


	public UUID getFlightID() {
		return flightID;
	}


	public void setFlightID(UUID flightID) {
		this.flightID = flightID;
	}


	public String getFlightNo() {
		return flightNo;
	}


	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}


	public String getAirline() {
		return airline;
	}


	public void setAirline(String airline) {
		this.airline = airline;
	}


	public String getDepDate() {
		String dateTime;
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm a zzz");
		dateTime = dateFormat.format(depDate);
		return dateTime;
	}


	public void setDepDate(String date, String time) throws ParseException {
		java.util.Calendar cal = java.util.Calendar.getInstance();
		String dateTimeString = new java.text.SimpleDateFormat("EEEE, "+date+"/"+time).format(cal.getTime());
		SimpleDateFormat formatter = new SimpleDateFormat("EEEE, dd/MM/yyyy/hh:mm:ss");
		Date dateTime = formatter.parse(dateTimeString);
		this.depDate = dateTime;
	}



	public String getDepLoc() {
		return depLoc;
	}


	public void setDepLoc(String depLoc) {
		this.depLoc = depLoc;
	}


	public String getArrDate() {
		String dateTime;
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm a zzz");
		dateTime = dateFormat.format(arrDate);
		return dateTime;
	}


	public void setArrDate(String date, String time) throws ParseException {
		java.util.Calendar cal = java.util.Calendar.getInstance();
		String dateTimeString = new java.text.SimpleDateFormat("EEEE, "+date+"/"+time).format(cal.getTime());
		SimpleDateFormat formatter = new SimpleDateFormat("EEEE, dd/MM/yyyy/hh:mm:ss");
		Date dateTime = formatter.parse(dateTimeString);
		this.arrDate = dateTime;
	}


	public String getArrLoc() {
		return arrLoc;
	}


	public void setArrLoc(String arrLoc) {
		this.arrLoc = arrLoc;
	}
	
	
}
