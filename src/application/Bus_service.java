package application;

import java.sql.Connection;
import java.util.*;

public class Bus_service {
	String id;
	String name;
	private String busService;
	ArrayList <Trip> trips = new ArrayList <Trip>();
	Trip trip;
	Bus_service( String id, String name, ArrayList<Trip> t ){
		
		this.id=id;
		this.name=name;
		this.trips=t;
	}
	Bus_service(){}
	/*
	public void edit_timing(Trip trip_id, String dept_time , String arr_time)
	{
		
	}
	
	public void view_reservation(Trip trip_id)
	{
		
	}
	
	public void cancel_reservation(Trip trip_id, Ticket ticket_id)
	{
		
	}
	
	
	
	public void view_bus_status(Trip trip_id)
	{
		
	}
	
	public void edit_route(Trip trip_id, String route)
	{
		
	}
	
	public void search_ticket(String date , String time, String deptcity , String arrcity)
	{
		
	}
	
	public void book_ticket(Trip trip_id , int seat)
	{
		
	}
	
	public void generate_ticket(int price,int seat_number,String bus_reg_no,String trip_id)
	{
		
	}
	
	public void create_reservation(Ticket id , User user)
	{
		
	}
	*/
	
	public ArrayList<Description> getAllDescriptions(String id)
	{
		
		Trip obj=new Trip();
		ArrayList <Description> fetchedTrips = new ArrayList <Description>();
		fetchedTrips=obj.getAllDescriptions(id);		
		return fetchedTrips;
		
	}
	
	
	public ArrayList<Trip> getStatus(String id)
	{
		
		Trip obj=new Trip();
		ArrayList <Trip> fetchedTrips = new ArrayList <Trip>();
		
		DBHandler db=new DBHandler();
		fetchedTrips=db.getStatus( id);
		
		return fetchedTrips;
		
	}
	
	
	public boolean editTripRoute( String busServiceid  ,String id,String dVenue, String aVenue)
	{
		
		
		Trip obj=new Trip();
		boolean status=true;
		
		status=obj.editTrip( busServiceid, id, dVenue, aVenue, 0);
		
		if(status)
			return true;
		else
			return false;
		
	}
	
	public boolean editTripSchedule( String busServiceid ,String id,String dtime, String atime )
	{
		
		Trip obj=new Trip();
		boolean status=true;
		
		status=obj.editTrip( busServiceid, id, dtime, atime, 1);
		
		if(status)
			return true;
		else
			return false;
		
	}
	
	public boolean addNewBus(bus bus, String busServiceid) {
		
		DBHandler d = new DBHandler();
		if( d.addNewBus(bus, busServiceid) )
			return true;
		else
			return false;
	}
	
	
	public boolean deleteBus(bus bus, String busServiceid) {
		
		DBHandler d = new DBHandler();
		if( d.deleteBus(bus, busServiceid) )
			return true;
		else
			return false;
	}
	
	public ArrayList<bus> getBusDetails(String busServiceid) {
		
		DBHandler d = new DBHandler();
		return (d.getBusData(busServiceid));
		
	} 
	
	public void generate_ticket(int trip_id,int price)
	{
		DBHandler d = new DBHandler();
		trip = d.search_trip(trip_id);
		if(trip!=null)
		for(int i=0;i<trip.bus.seats;i++)
		{
			Ticket ticket = new Ticket();
			ticket.trip_id = String.valueOf(trip_id);
			ticket.price = price;
			ticket.seat_number= i+1;
			ticket.status = "available";
			d.add_ticket(ticket);
		}
		
	}
	
	public Trip searchTrip(int tripid) {
		
		Trip t=new Trip();
		return(t.searchTrip(tripid));
	}
	
	public String getBusService() {
		return busService;
	}
	public void setBusService(String busService) {
		this.busService = busService;
	}
}
