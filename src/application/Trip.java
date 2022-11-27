package application;

import java.sql.Connection;
import java.util.ArrayList;

public class Trip {

	String busServiceid;
	String tripId;
	String status;
	Description desc;
	//Ticket ticket;
	bus bus;
	public static Trip selectedTrip;
	
	
	static int currtrip=-2;
	Trip(){}
	Trip(String bid,String tid,Description desc ){
		this.busServiceid=bid;
		this.tripId=tid;
		this.desc=desc;
	}
	
	Trip(String tid,String status ){
		
		this.tripId=tid;
		this.status=status;
	}
	
	
	void printDescription(  ) {
		
		
		
	}
	
	boolean editSchedule( String dTime, String aTime, String busid,String tripid) {
		
		
		DBHandler obj=new DBHandler();
		obj.editSchedule(busid,tripid, aTime,dTime);
		return true;
	}
	
	
	boolean editRoute( String dV, String aV, String busid,String tripid) {
		
		DBHandler obj=new DBHandler();
		obj.editRoute(busid,tripid,aV,dV);
		return true;
		
	}
	
	
	ArrayList<Description> getAllDescriptions(String name) {
		
		ArrayList<Description> desc= new ArrayList<Description>();
		 DBHandler obj=new DBHandler();
		 desc=obj.getSchedule(name);
		 return desc;
		 
		 
		
	}
	
	boolean editTrip(String busId ,String id,String dept,String Arrival, int identifier) {
		
		
		if(identifier==0) {
				editRoute(dept,Arrival,busId,id);
				return true;
		}else if((identifier==1)) {
				editSchedule(dept,Arrival,busId,id);
				return true;
		}	
			
		return false;
	}
	
	int getTrip(String arrival,String departure) {
		
		DBHandler db=new DBHandler();
		return (db.getTrip( arrival, departure));
		
	}
	
	
	public Trip searchTrip(int trippid) {
		
		DBHandler db=new DBHandler();
		return (db.search_trip(trippid));
	}
	
	/*
	public void create_new_reservation(int seat,User user)
	{
		// t = t.seatr  = seat
		
		Reservation res = new Reservation(ticket,user);
		
		ticket.status = "booked";
	}
	
	public void generate_ticket(int price)
	{
		for(int i=0; i<bus.seats ; i++)
		{
			Ticket t = new Ticket();
			t.bus_reg_no = bus.bus_reg_number;
			t.price = price;
			t.status = "Available";
			t.seat_number = i+1;
			//add data to database
		}
	}
	
	*/
	
}
