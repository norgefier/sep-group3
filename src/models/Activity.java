package models;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "activity")
public class Activity implements Serializable {
	
	@XmlElement(name = "ID")
	private UUID activityID;
	@XmlElement(name = "name")
	private String activityName;
	@XmlElement(name = "address")
	private String activityAddress;
	@XmlElement(name = "startTime")
	private Date activityStartTime;
	@XmlElement(name = "endTime")
	private Date activityEndTime;
	@XmlElement(name = "price")
	private int activityPrice;
	@XmlElement(name = "paid")
	private boolean activityPaid;
	
	public Activity()
	{
		
	}
	
	public Activity(String name)
	{
		this.activityName = name;
		this.activityID = UUID.randomUUID();
	}

	public UUID getActivityID() {
		return activityID;
	}

	public void setActivityID(UUID activityID) {
		this.activityID = activityID;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getActivityAddress() {
		return activityAddress;
	}

	public void setActivityAddress(String activityAddress) {
		this.activityAddress = activityAddress;
	}

	public String getActivityStartTime() {
		String dateTime;
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm a zzz");
		dateTime = dateFormat.format(activityStartTime);
		return dateTime;
	}

	public void setActivityStartTime(String date, String time) throws ParseException {
		java.util.Calendar cal = java.util.Calendar.getInstance();
		String dateTimeString = new java.text.SimpleDateFormat("EEEE, "+date+"/"+time).format(cal.getTime());
		SimpleDateFormat formatter = new SimpleDateFormat("EEEE, dd/MM/yyyy/hh:mm:ss");
		Date dateTime = formatter.parse(dateTimeString);
		this.activityStartTime = dateTime;
	}

	public String getActivityEndTime() {
		String dateTime;
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm a zzz");
		dateTime = dateFormat.format(activityEndTime);
		return dateTime;
	}

	public void setActivityEndTime(String date, String time) throws ParseException {
		java.util.Calendar cal = java.util.Calendar.getInstance();
		String dateTimeString = new java.text.SimpleDateFormat("EEEE, "+date+"/"+time).format(cal.getTime());
		SimpleDateFormat formatter = new SimpleDateFormat("EEEE, dd/MM/yyyy/hh:mm:ss");
		Date dateTime = formatter.parse(dateTimeString);
		this.activityEndTime = dateTime;
	}

	public int getActivityPrice() {
		return activityPrice;
	}

	public void setActivityPrice(int activityPrice) {
		this.activityPrice = activityPrice;
	}

	public boolean isActivityPaid() {
		return activityPaid;
	}

	public void setActivityPaid(boolean activityPaid) {
		this.activityPaid = activityPaid;
	}

}
