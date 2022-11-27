package application;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
	
	String name;
	String cnic;
	String email;
	String password;
	String profile_picture;
	String number;
	
	DBHandler db= DBHandler.getinstance(); 
	
	public User(String a,String b) {
		this.name=a;
		this.password=b;
	}
	
	static User currentUser; 
	
	public HashMap<String,String> view_reservations()
	{
		return db.view_reservation(cnic);
	}
	
	public void remove_reservation(String trip_id)
	{
		db.remove_reservation(trip_id);
	}
	
	public User view_user_profile()
	{
		return db.view_profile(cnic);
	}
	
	public void edit_profile_picture(String path)
	{
		this.profile_picture = path;
		System.out.println("Profile picture updated");
	}
	
	
	public User(String cnic, String phone, String email, String password) {
		this.cnic=cnic;
		this.email=email;
		this.number=phone;
		this.password=password;
		
	}
	
	public User(String name, String cnic, String profile_picture) {
		super();
		this.name = name;
		this.cnic = cnic;
		this.profile_picture = profile_picture;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public void edit_email(String newemail)
	{
		this.email= newemail;
		db.edit_email(newemail, newemail);
	}
	
	public void edit_number(String number)
	{
		this.number = number;
		db.edit_number(cnic, number);
	}

	public boolean book_ticket(String servicename, Trip trip, int seat,User user) {
		int flag=0;
		Reservation reservation = new Reservation();
		Ticket ticket = new Ticket();
		int t= Integer.parseInt(trip.tripId);
		ticket = db.getticket(t,seat);
		
		if(ticket.status.equals("available"))
			{reservation.ticket = ticket;
			reservation.user = user;
			//if (db.createReservation(ticket,user.cnic))
			if (db.createReservation(ticket,"37401"))
				flag=1;
			
			}
	
		if(flag==0)
			return false;
		else
			return true;
	}

	public HashMap<String, ArrayList<String>> search_ticket(String servicename,String date, String time, String deptcity, String arrcity) {
	 return db.search_ticket(servicename, date, time, deptcity, arrcity);
	}

	public ArrayList<String> view_all_bus_services() {
		// TODO Auto-generated method stub
		return db.view_all_bus_services();
	}
	
	
	public boolean updateProfile(User user) {
		
		return (db.updateProfile(user));
		
		
	}
	
	
	

}
