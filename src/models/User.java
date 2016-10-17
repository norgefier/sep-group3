package models;

import java.util.UUID;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "creator")
public class User {
	
	@XmlElement(name = "email")
	private String emailAddress;
	@XmlElement(name = "password")
	private String password;
	@XmlElement(name = "firstName")
	private String firstName;
	@XmlElement(name = "lastName")
	private String lastName;
	@XmlElement(name = "screenName")
	private String screenName;
	@XmlElement(name = "mobileNo")
	private String mobileNo;
	@XmlElement(name = "plan")
	private TravelPlan[] planList;
	@XmlElement(name = "sysAdmin")
	private boolean sysAdmin;
	
	public User()
	{
		
	}
	
	public User(String inEmail, String inPass, String firstName, String lastName, String mobileNo)
	{
		this.emailAddress = inEmail;
		this.password = inPass;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
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
	
	public boolean planExists(TravelPlan plan)
	{
		boolean exists = false;
		for(int i = 0; i < planList.length; i++)
		{
			if(plan.getPlanID() == planList[i].getPlanID())
			{
				exists = true;
			}
		}
		return exists;
	}
	
	public void addPlan(TravelPlan plan)
	{
		if(planExists(plan))
		{
			updatePlan(plan);
		}
		else
		{
			TravelPlan newList[] = new TravelPlan[planList.length+1];
			for(int i=0; i<planList.length; i++)
			{
				newList[i] = planList[i];
			}
			newList[planList.length] = plan;
			planList = newList;
		}
	}
	
	public void updatePlan(TravelPlan plan)
	{
		for(int i=0; i<planList.length; i++)
		{
			if(planList[i].getPlanID() == plan.getPlanID())
			{
				planList[i] = plan;
			}
		}
	}
	
	public void deletePlan(TravelPlan plan)
	{
		TravelPlan[] newPlanList = new TravelPlan[planList.length-1];
		for(int i = 0; i < planList.length; i++)
		{
			if(planList[i] != null && planList[i].getPlanID().equals(plan.getPlanID()))
			{
				for(int n = 0; n < i; n++)
				{
					newPlanList[n] = planList[n];
				}
				for(int n = i; n < newPlanList.length; n++)
				{
					newPlanList[i] = planList[n+1];
				}
				planList = newPlanList;
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
