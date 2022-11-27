package application;

import java.sql.Connection;
import java.util.*;

public interface PersistanceHandler {

	abstract Connection connectDB();
	abstract ArrayList<User> readLoginData(int type);
	abstract ArrayList<Description> getSchedule(String name);
	abstract boolean editSchedule( String busId ,String tripId, String aTime,String dTime);
	abstract boolean editRoute( String busId ,String tripId, String aTime,String dTime);
	abstract public ArrayList<Trip> getStatus( String busId );
	abstract public boolean registerNewCustomer( User user );
	abstract public boolean addNewBus(bus bus,String busServiceId);
	abstract public boolean deleteBus(bus bus,String busServiceId);
	abstract public ArrayList<bus> getBusData(String busServiceId);
	abstract public boolean updateProfile(User user);

}
