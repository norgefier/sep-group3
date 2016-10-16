package models;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/*Initialises the xml data, or resets it to its starting state*/

public class XMLintialiser {
	
	public static final String storedDataPath = "WebContent/WEB-INF/stored_polls.xml";
	
	public static void main(String[] args) throws JAXBException, FileNotFoundException {
		String emailOne = "jai-robinson@hotmail.com";
		String passOne = "jai1234";
		String firstOne = "jai";
		String lastOne = "robinson";
		String noOne = "0498127843";
		
		String emailTwo = "ben.stiller@hotmail.com";
		String passTwo = "ben1234";
		String firstTwo = "ben";
		String lastTwo = "stiller";
		String noTwo = "0494527843";
		
		String emailThree = "greg.benson@hotmail.com";
		String passThree = "greg1234";
		String firstThree = "greg";
		String lastThree = "benson";
		String noThree = "0498125643";
		
		StoredUsers users = new StoredUsers();
		
		users.newUser(emailOne, passOne, firstOne, lastOne, noOne);
		users.newUser(emailTwo, passTwo, firstTwo, lastTwo, noTwo);
		users.newUser(emailThree, passThree, firstThree, lastThree, noThree);

		User jai = users.login(emailOne, passOne);
		User ben = users.login(emailTwo, passTwo);
		User greg = users.login(emailThree, passThree);
		
		TravelPlan planOne = new TravelPlan("Japan");
		TravelPlan planTwo = new TravelPlan("London");
		TravelPlan planThree = new TravelPlan("France");
		
		Activity actOne1 = new Activity("Nara");
		Activity actOne2 = new Activity("Universal");
		planOne.addActivity(actOne1);
		planOne.addActivity(actOne2);
		
		Activity actTwo1 = new Activity("big ben");
		Activity actTwo2 = new Activity("Palace");
		planTwo.addActivity(actTwo1);
		planTwo.addActivity(actTwo2);
		
		Activity actThree1 = new Activity("Eiffel tower");
		Activity actThree2 = new Activity("Musee d'Orsay");
		planThree.addActivity(actThree1);
		planThree.addActivity(actThree2);
		
		Flight flightOne1 = new Flight();
		Ticket ticketOne1 = new Ticket(flightOne1);
		Flight flightOne2 = new Flight();
		Ticket ticketOne2 = new Ticket(flightOne2);
		planOne.addTicket(ticketOne1);
		planOne.addTicket(ticketOne2);
		
		Flight flightTwo1 = new Flight();
		Ticket ticketTwo1 = new Ticket(flightTwo1);
		Flight flightTwo2 = new Flight();
		Ticket ticketTwo2 = new Ticket(flightTwo2);
		planTwo.addTicket(ticketTwo1);
		planTwo.addTicket(ticketTwo2);
		
		Flight flightThree1 = new Flight();
		Ticket ticketThree1 = new Ticket(flightThree1);
		Flight flightThree2 = new Flight();
		Ticket ticketThree2 = new Ticket(flightThree2);
		planThree.addTicket(ticketThree1);
		planThree.addTicket(ticketThree2);
		
		Accomodation accomOne1 = new Accomodation("hotelOne");
		Booking bookOne1 = new Booking(accomOne1);
		planOne.addBooking(bookOne1);
		
		Accomodation accomTwo1 = new Accomodation("hotelTwo");
		Booking bookTwo1 = new Booking(accomTwo1);
		planTwo.addBooking(bookTwo1);
		
		Accomodation accomThree1 = new Accomodation("hotelThree");
		Booking bookThree1 = new Booking(accomThree1);
		planThree.addBooking(bookThree1);
		
		jai.addPlan(planOne);
		ben.addPlan(planTwo);
		greg.addPlan(planThree);
		
		users.updateUser(jai);
		users.updateUser(ben);
		users.updateUser(greg);
		
		JAXBContext jc = JAXBContext.newInstance(StoredUsers.class);
		Marshaller m = jc.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.marshal(users, System.out);
		
		FileOutputStream fo = new FileOutputStream(storedDataPath);
		m.marshal(users, fo);
	}

}
