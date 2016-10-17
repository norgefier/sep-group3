package models;

import java.io.Serializable;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "users")
public class StoredUsers implements Serializable {
	
	@XmlElement(name = "user")
	private User[] users;
	
	public StoredUsers()
	{
		users = new User[0];
	}

	public User login(String email, String password)
	{
		User user = null;
		boolean found = false;
		for(int i=0; i<users.length; i++)
		{
			if(users[i].getEmailAddress().equals(email) && users[i].getPassword().equals(password))
			{
				user = users[i];
				found = true;
			}
		}
		if (!found)
		{
			throw new IllegalArgumentException("Email address or password is incorrect");
		}
		return user;
	}
	
	public void newUser(String email, String password, String firstName, String lastName, String mobileNo)
	{
		User user = null;
		for(User currUser : users)
		{
			if(currUser.getEmailAddress().equals(email))
			{
				throw new IllegalArgumentException("Email address is already in use");
			}
		}
		if(email.length() < 50 && password.length() < 50)
		{
			user = new User(email, password, firstName, lastName, mobileNo);
			User newUsers[] = new User[users.length+1];
			for(int i=0; i<users.length; i++)
			{
				newUsers[i] = users[i];
			}
			newUsers[users.length] = user;
			users = newUsers;
		}
		else
		{
			throw new IllegalArgumentException("username or password is too long");
		}
	}
	
	public void updateUser(User user)
	{
		boolean success = false;
		for(int i=0; i<users.length; i++)
		{
			if(users[i].getEmailAddress() == user.getEmailAddress())
			{
				users[i] = user;
				success = true;
			}
		}
		if(!success)
		{
			throw new IllegalArgumentException("user does not exist "+user.getFirstName()+" "+user.getLastName());
		}
	}
	
	public void deleteUser(String email)
	{
		User[] newUsers = new User[users.length-1];
		for(int i = 0; i < users.length; i++)
		{
			if(users[i] != null && users[i].getEmailAddress().equals(email))
			{
				for(int n = 0; n < i; n++)
				{
					newUsers[n] = users[n];
				}
				for(int n = i; n < newUsers.length; n++)
				{
					newUsers[n] = users[n+1];
				}
				users = newUsers;
			}
		}
	}
	
	public User[] getUsers() {
		return users;
	}

	public void setUsers(User[] users) {
		this.users = users;
	}
	
}
