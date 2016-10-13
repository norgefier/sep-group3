package models;

import java.util.UUID;

public class User {

	private String emailAddress;
	private String password;
	private String firstName;
	private String lastName;
	private String screenName;
	private String mobileNo;
	private TravelPlan[] planList;
	private boolean sysAdmin;
	
	public User(String inEmail, String inPass)
	{
		emailAddress = inEmail;
		password = inPass;
		planList = new TravelPlan[0];
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public TravelPlan[] getPlanList() {
		return planList;
	}

	public void setPlanList(TravelPlan[] planList) {
		this.planList = planList;
	}

	public boolean isSysAdmin() {
		return sysAdmin;
	}

	public void setSysAdmin(boolean sysAdmin) {
		this.sysAdmin = sysAdmin;
	}
	
	public void addPlan(TravelPlan plan)
	{
		TravelPlan newList[] = new TravelPlan[planList.length+1];
		for(int i=0; i<planList.length; i++)
		{
			newList[i] = planList[i];
		}
		newList[planList.length] = plan;
		planList = newList;
	}
	
	public void updatePlan(UUID planID, TravelPlan plan)
	{
		for(int i=0; i<planList.length; i++)
		{
			if(planList[i].getPlanID() == planID)
			{
				planList[i] = plan;
			}
		}
	}
	
	public TravelPlan getPlan(UUID ID)
	{
		TravelPlan retPlan = null;
		boolean found = false;
		for(TravelPlan plan : planList)
		{
			if(plan.getPlanID().equals(ID))
			{
				retPlan =  plan;
				found = true;
			}
		}
		if(found == false)
		{
			throw new IllegalArgumentException("Travel plan with id: " + ID + " not found");
		}
		else
		{
			return retPlan;
		}
	}
	
}
