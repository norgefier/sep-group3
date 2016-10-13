package models;

import java.util.Date;
import java.util.UUID;

public class Activity {
	
	private UUID activityID;
	private String activityName;
	private String activityAddress;
	private Date activityStartTime;
	private Date activityEndTime;
	private int activityPrice;
	private boolean activityPaid;
	
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

	public Date getActivityStartTime() {
		return activityStartTime;
	}

	public void setActivityStartTime(Date activityStartTime) {
		this.activityStartTime = activityStartTime;
	}

	public Date getActivityEndTime() {
		return activityEndTime;
	}

	public void setActivityEndTime(Date activityEndTime) {
		this.activityEndTime = activityEndTime;
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
