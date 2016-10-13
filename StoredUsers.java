package models;

public class StoredUsers {

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
			if(email.equals(users[i].getEmailAddress()) && password.equals(users[i].getPassword()))
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
	
	public void newUser(String email, String password)
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
			user = new User(email, password);
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
		for(int i=0; i<users.length; i++)
		{
			if(users[i].getEmailAddress() == user.getEmailAddress())
			{
				users[i] = user;
			}
			else
			{
				throw new IllegalArgumentException("user does not exist "+user.getFirstName()+" "+user.getLastName());
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
