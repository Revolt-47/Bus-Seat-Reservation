package application;

import java.util.ArrayList;

public class Admin {

	Bus_service busService=new Bus_service(); 
	
	public boolean addNewBus(bus bus,String busServiceId) {
		
		if(busService.addNewBus(bus, busServiceId))
			return true;
		else
			return false;
	} 
	
	public boolean deleteBus(bus bus,String busServiceId) {
		
		if(busService.deleteBus(bus, busServiceId))
			return true;
		else
			return false;
	} 
	
	public ArrayList<bus> ViewBusDetails(String busServiceId) {
		
		return ( busService.getBusDetails(busServiceId) );
	} 

	public ArrayList<Description> getAllDescriptions(String id){
		
		return (busService.getAllDescriptions(id));
	}
	
	public boolean editRoute(String busServiceid  ,String id,String dVenue, String aVenue) {
		return(busService.editTripRoute(busServiceid, id, dVenue, aVenue));
	}
	
	public boolean editTripSchedule( String busServiceid ,String id,String dtime, String atime )
	{
		return ( busService.editTripSchedule(busServiceid, id, dtime, atime) );  
	}
	
	public ArrayList<Trip> getStatus(String id)
	{
		return (busService.getStatus(id));
		
	}
	
	//call i6 fm cnroler
	public void generate_tickets(String servicename,String trip_id, int price)
	{
		DBHandler d = new DBHandler();
		busService = d.search_service(servicename); 
		busService.generate_ticket(Integer.parseInt(servicename),price);
	}
}
