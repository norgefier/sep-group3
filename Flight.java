package models;
import java.util.*;

public class Flight {

	private UUID flightID;
	private String flightNo;
	private String airline;
	private Date depdate;
	private String depLoc;
	private Date arrDate;
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


	public Date getDepdate() {
		return depdate;
	}


	public void setDepdate(Date depdate) {
		this.depdate = depdate;
	}



	public String getDepLoc() {
		return depLoc;
	}


	public void setDepLoc(String depLoc) {
		this.depLoc = depLoc;
	}


	public Date getArrDate() {
		return arrDate;
	}


	public void setArrDate(Date arrDate) {
		this.arrDate = arrDate;
	}


	public String getArrLoc() {
		return arrLoc;
	}


	public void setArrLoc(String arrLoc) {
		this.arrLoc = arrLoc;
	}
	
	
}
