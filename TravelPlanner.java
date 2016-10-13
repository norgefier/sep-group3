package models;

import java.io.FileInputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class TravelPlanner {
	//path and filename where the XML storing the users is saved.
	private String filePath;
	//
	private StoredUsers users;
	
	public TravelPlanner()
	{
		users = new StoredUsers();
	}
	
	public String getFilePath()
	{
		return filePath;
	}
	

	//sets the XML file path and unmarshalls the XML document into the stored User object.
	public void setFilePath(String filePath)
	{
		JAXBContext jc;
		try
		{
			jc = JAXBContext.newInstance(StoredUsers.class);
			Unmarshaller u = jc.createUnmarshaller();
			
			FileInputStream fIn = new FileInputStream(filePath);
			users = (StoredUsers) u.unmarshal(fIn);
			
			fIn.close();
			this.filePath = filePath;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public User login(String email, String pass)
	{
		User user = users.login(email, pass);
		return user;
	}
	
	public void addUser(String email, String pass)
	{
		users.newUser(email, pass);
	}
	
	public void updateUser(User user)
	{
		users.updateUser(user);
	}
	
	public User[] getUsers()
	{
		return users.getUsers();
	}
	
	public void passReset(String email)
	{
		
	}
}
