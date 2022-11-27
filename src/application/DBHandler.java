package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import application.PersistanceHandler;


public class DBHandler implements PersistanceHandler{
	Connection con=null;
	@Override
	public
	Connection connectDB() {
		try {

			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bussystem","root","formula11");

			//System.out.println(" Database connected ...  ");

			Statement stmt=con.createStatement(); 

			System.out.println(" Connected ");

			return con;

		}
		catch(Exception e){ System.out.println(" Error..\n "+e);}  
		return null;

	}
	
	
	private static DBHandler database = null;
	
	public DBHandler() {}
	
	public static DBHandler getinstance()
	{
		if(database == null)
			database = new DBHandler();
		
		return database;
	}
	
	@Override
	public ArrayList<User> readLoginData(int type ) {
		DatabaseConnecter db=new DatabaseConnecter();
		Connection con = db.getCon();
		
		ArrayList<User> data=new ArrayList<User>();
		Statement stmt;
		if(type==0) {									 // admin

			try {
				stmt = con.createStatement();
				String sql="Select * from admin";
				ResultSet rs= stmt.executeQuery(sql);
				while(rs.next()) {
					User obj=new User(rs.getString(1),rs.getString(2));
					data.add(obj);
				}
			}
			catch (SQLException e) {
				System.out.println("exception: "+e);
			}

		}else if(type==1) { 								//customer

			try {
				stmt = con.createStatement();
				String sql="Select * from user";
				ResultSet rs= stmt.executeQuery(sql);
				while(rs.next()) {
					User obj=new User( Integer.toString( rs.getInt(4) ),rs.getString(5));
					data.add(obj);
				}
			}
			catch (SQLException e) {
				System.out.println("exception: "+e);
			}

		}

		return data;
	}
	
	@Override
	public ArrayList<Description> getSchedule(String name) {
		DatabaseConnecter db=new DatabaseConnecter();
		Connection con = db.getCon();
		ArrayList<Description> data=new ArrayList<Description>();
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql="select * from Description where id in ( select tripId from trip where busServiceId = (select id from BusService where name='"+name+"'));";
			ResultSet rs= stmt.executeQuery(sql);
			while(rs.next()) {
				Description obj=new Description(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
				data.add(obj);
			}
		}
		catch (SQLException e) {
			System.out.println("exception: "+e);
		}

		return data;

	}

	
	@Override
	public boolean editSchedule( String busId ,String tripId, String aTime,String dTime) {
		DatabaseConnecter db=new DatabaseConnecter();
		Connection con = db.getCon();
		int flag=1;
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql="Update Description set arrivalTime='"+aTime+"',departureTime='"+dTime+"' where id in ( select tripId from trip where busServiceId = (select id from BusService where name='"+busId+"') and tripId='"+tripId+"');";
			stmt.executeUpdate(sql);
			flag=0;
		}
		catch (SQLException e) {
			System.out.println("exception: "+e);
		}
		
		if(flag==0)
			return true;
		else
			return false;
	}

	@Override
	public boolean editRoute( String busId ,String tripId, String aVenue,String dVenue) {
		DatabaseConnecter db=new DatabaseConnecter();
		Connection con = db.getCon();
		int flag=1;
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql="Update Description set fromPlace='"+dVenue+"',toPlace='"+aVenue+"' where id in ( select tripId from trip where busServiceId = (select id from BusService where name='"+busId+"') and tripId='"+tripId+"');";
			stmt.executeUpdate(sql);
			flag=0;
		}
		catch (SQLException e) {
			System.out.println("exception: "+e);
		}
		
		if(flag==0)
			return true;
		else
			return false;
	}

	
	public ArrayList<Trip> getStatus( String busId ){
		DatabaseConnecter db=new DatabaseConnecter();
		Connection con = db.getCon();
		ArrayList<Trip> tripData=new ArrayList<Trip>();
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql="select tripId,status from Trip where busServiceId in(select id from BusService where name='"+busId+"') ;";
			ResultSet rs= stmt.executeQuery(sql);
			while(rs.next()) {
				Trip t=new Trip(rs.getString(1),rs.getString(2));
				tripData.add(t);
			}
		}
		catch (SQLException e) {
			System.out.println("exception: "+e);
		}

		return tripData;
		
	}

	public boolean registerNewCustomer(User user) {
		
		DatabaseConnecter db=new DatabaseConnecter();
		Connection con = db.getCon();
		Statement stmt;
		int flag=0;
		try {
			stmt = con.createStatement();
			String sql="insert into user(name,email,phone,cnic,password,path) values ('"+user.name+"','"+user.email+"','"+user.number+"',"+user.cnic+",'"+user.password+"','"+user.profile_picture+"');";
			flag=stmt.executeUpdate(sql);
			flag=1;
		}
		catch (SQLException e) {
			System.out.println("exception: "+e);
		}
		
		if(flag==1)
			return true;
		else
			return false;
	}
	
	
public boolean addNewBus(bus bus , String busServiceId) {
		
		DatabaseConnecter db=new DatabaseConnecter();
		Connection con = db.getCon();
		int flag=1;String Bid="";
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql="select id from BusService where name='"+busServiceId+"';";
			ResultSet rs= stmt.executeQuery(sql);
			while(rs.next()) {
				Bid=rs.getString(1);
			}
			
			String sql1="insert into Bus(busName,regNo,noOfSeats,busServiceId) values ('"+bus.bus_name+"','"+bus.bus_reg_number+"',"+bus.seats+",'"+Bid+"')";
			stmt.executeUpdate(sql1);
			flag=0;
		}
		catch (SQLException e) {
			System.out.println("exception: "+e);
		}
		
		if(flag==0)
			return true;
		else
			return false;
	}
	

 public boolean deleteBus(bus bus,String busServiceId) {
	 
	 	DatabaseConnecter db=new DatabaseConnecter();
		Connection con = db.getCon();
		int flag=1;
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql="delete from bus where regNo='"+bus.bus_reg_number+"';";
			stmt.executeUpdate(sql);
			flag=0;
		}
		catch (SQLException e) {
			System.out.println("exception: "+e);
		}
		
		if(flag==0)
			return true;
		else
			return false;
	 
 }


	public ArrayList<bus> getBusData(String busServiceId ){
		DatabaseConnecter db=new DatabaseConnecter();
		Connection con = db.getCon();
		ArrayList<bus> busData=new ArrayList<bus>();
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql="select * from Bus where busServiceId in (select id from BusService where name='"+busServiceId+"') ;";
			ResultSet rs= stmt.executeQuery(sql);
			while(rs.next()) {
				bus t=new bus(rs.getString(1),rs.getString(2),rs.getInt(3));
				busData.add(t);
			}
		}
		catch (SQLException e) {
			System.out.println("exception: "+e);
		}

		return busData;
		
	}
 
	
	
	public HashMap<String,ArrayList<String>> search_ticket(String busID ,String date , String time, String deptcity , String arrcity)
	{
		DatabaseConnecter db=new DatabaseConnecter();
		Connection con = db.getCon();
		ArrayList <String> seats = new ArrayList <String>();
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql_1 = "select tripid from Trip where busServiceId = '"+busID+"';";
			ResultSet rs = stmt.executeQuery(sql_1);
			String sql_2 = "select seatnumber from Tickets where tripid ='"+rs.getString(0)+"'and status = 'available';";
			ResultSet rs2 = stmt.executeQuery(sql_2);
			while(rs2.next())
			{
				seats.add(rs.getString(0));
			}
			HashMap<String,ArrayList<String>> hm = new HashMap<String,ArrayList<String>>();
			hm.put(rs.getString(0),seats);
			return hm;
			
		}
		catch(SQLException e) {
			System.out.println("exception: "+e);
			
		}
		return null;
		
	}
	
	public void edit_profile_picture(String cnic, String path)
	{
		
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql = "update users set picture = '"+path+"' where cnic = '"+cnic+"';";
			ResultSet rs= stmt.executeQuery(sql);
		}
		catch(SQLException e) {
			System.out.println("exception: "+e);
			
		}
		return;
		
	}
	
	public User view_profile(String cnic)
	{
		DatabaseConnecter db=new DatabaseConnecter();
		Connection con = db.getCon();
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql = "Select cnic,email,path,phone,password,name from user where cnic = "+cnic+";";
			ResultSet rs= stmt.executeQuery(sql);
			User user = new User();
			while(rs.next()) {
				user.cnic = rs.getString(1);
				user.email = rs.getString(2);
				user.profile_picture = rs.getString(3);
				user.number = rs.getString(4);
				user.password=rs.getString(5);
				user.name=rs.getString(6);
			}
			return user;
			
		}
		catch(SQLException e) {
			System.out.println("exception: "+e);
			
		}
		return null;
		
	}
	
	public void add_new_bus(bus bus)
	{
		DatabaseConnecter db=new DatabaseConnecter();
		Connection con = db.getCon();
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql = "Insert into buses(regNo,busName,busServiceId,noOfseats) values('"+bus.bus_reg_number+"','"+bus.bus_name+"','"+bus.servicename+"',"+bus.seats+");";
			ResultSet rs= stmt.executeQuery(sql);
		}
		catch(SQLException e) {
			System.out.println("exception: "+e);
			
		}
		return;
		
	}
	
	public int add_new_trip(String busservice, String dept, String arr, String dept_time , String arr_time , String route , String bus_reg_no, int price)
	{
		DatabaseConnecter db=new DatabaseConnecter();
		Connection con = db.getCon();
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql = "Insert into Description(arrivaltime,departuretime,fromplace,toplace) values('"+arr_time+"','"+dept_time+"','"+dept+"',"+arr+");";
			ResultSet rs= stmt.executeQuery(sql);
			String sql2 = "Select id from Description where arrivaltime = "+arr_time+" && departuretime = "+dept_time+" && fromplace = "+dept+" && toplace ="+arr+";";
			ResultSet rs2 = stmt.executeQuery(sql2);
			int id = (rs.getInt(0));
			String sql1 = "Insert into trip(busServiceId,busid,descriptionid,active) values('"+busservice+"','"+bus_reg_no+"','"+busservice+"',"+id+","+"active"+");";
			ResultSet rs3 = stmt.executeQuery(sql1);
			return id;
		}
		catch(SQLException e) {
			System.out.println("exception: "+e);
			
		}
		return 0;
	}
	
	public void edit_number(String cnic ,String number)
	{
		DatabaseConnecter db=new DatabaseConnecter();
		Connection con = db.getCon();
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql = "update users set phone = '"+number+"' where cnic = '"+cnic+"';";
			ResultSet rs= stmt.executeQuery(sql);
			 
		}
		catch(SQLException e) {
			System.out.println("exception: "+e);
			
		}
		return;
	}
	
	public void edit_email(String cnic ,String email)
	{
		DatabaseConnecter db=new DatabaseConnecter();
		Connection con = db.getCon();
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql = "update users set picture = '"+email+"' where cnic = '"+cnic+"';";
			ResultSet rs= stmt.executeQuery(sql);
			 
		}
		catch(SQLException e) {
			System.out.println("exception: "+e);
			
		}
		return;
	}
	
	public ArrayList<String> view_all_bus_services() {
		DatabaseConnecter db=new DatabaseConnecter();
		Connection con = db.getCon();
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql = "Select name from BusService;";
			ResultSet rs= stmt.executeQuery(sql);
			ArrayList<String> a = new ArrayList<String>();
			while(rs.next())
				a.add(rs.getString(0));
			return a;
		}
		catch(SQLException e) {
			System.out.println("exception: "+e);
			
		}
		return null;
	}
	
	public Bus_service search_service(String servicename)
	{
		DatabaseConnecter db=new DatabaseConnecter();
		Connection con = db.getCon();
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql = "Select * from BusService where name ='" +servicename+"';";
			ResultSet rs= stmt.executeQuery(sql);
			Bus_service service = new Bus_service();
			service.name = rs.getString(0);
			return service;
			 
		}
		catch(SQLException e) {
			System.out.println("exception: "+e);
			
		}
		return null;
	}
	
	public bus search_bus(String regno)
	{
		DatabaseConnecter db=new DatabaseConnecter();
		Connection con = db.getCon();
		
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql = "Select regNo, busName,noOfSeats from Bus where regNo ='"+regno+";'";
			ResultSet rs= stmt.executeQuery(sql);
			bus bus=new bus();
			while(rs.next()) {
				bus.bus_reg_number = rs.getString(1);
				bus.bus_name = rs.getString(2);
				bus.seats = rs.getInt(3);
			}
			return bus;
			 
		}
		catch(SQLException e) {
			System.out.println("exception: "+e);
			
		}
		return null;
	}
	
	public int getTrip( String arrival, String departure) {
		DatabaseConnecter db=new DatabaseConnecter();
		Connection con = db.getCon();
		int id=-2;
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql = "Select tripId from Trip where descriptionid=(Select id from Description where fromPlace='"+departure+"' and toPlace='"+arrival+"');";
			ResultSet rs1=stmt.executeQuery(sql);
			while(rs1.next()) {
				 id = Integer.parseInt(rs1.getString(1));
			}
			//System.out.println("id: "+id);
			return id;
		}
		catch(SQLException e) {
			System.out.println("exception: "+e);
			
		}
		
		return -1 ;
	}
	
	public Trip search_trip(int tripid)
	{
		//System.out.println("h: "+ tripid);
		
		Trip trip = new Trip();
		DatabaseConnecter db=new DatabaseConnecter();
		Connection con = db.getCon();
		Statement stmt;
		String busid="",id="";
		try {
			stmt = con.createStatement();
			String sql = "Select tripId,busServiceID,busid,status from Trip where tripId ="+tripid+";";
			ResultSet rs= stmt.executeQuery(sql);
			while(rs.next()) {
				trip.tripId=rs.getString(1);
				trip.busServiceid=rs.getString(2);
				trip.status=rs.getString(4);
				busid= rs.getString(3);
			}
			String sql2 = "Select descriptionId from Trip where tripId ='"+ tripid+"';";
			ResultSet rs1 = stmt.executeQuery(sql2);
			while(rs1.next()) 
				id = rs1.getString(1);
			
			String sql3 = "Select arrivalTime,departureTime,fromPlace,toPlace from Description where id = '"+id+"';";
			ResultSet rs2 = stmt.executeQuery(sql3);
			Description d = new Description();
			while(rs2.next()) {
				d.arrivalTime = rs2.getString(1);
				d.departureTime = rs2.getString(2);
				d.departureVenue = rs2.getString(3);
				d.arrivalVenue = rs2.getString(4);
			}
			trip.desc = d;
			trip.bus = search_bus(busid);
			
			
			//System.out.println("trip id: " + trip.tripId + " desc: "+ id);
			
			return trip;
			 
		}
		catch(SQLException e) {
			System.out.println("exception: "+e);
			
		}
		return null;
	}

	public void add_ticket(Ticket ticket) {
		DatabaseConnecter db=new DatabaseConnecter();
		Connection con = db.getCon();
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql = "Insert into Tickets (tripid,seatnumber,price,status) values("+ticket.trip_id+","+ticket.seat_number+""+ticket.price+","+ticket.status+")";
			ResultSet rs= stmt.executeQuery(sql);
			 
		}
		catch(SQLException e) {
			System.out.println("exception: "+e);
			
		}
		return ;
	 
		
	}

	public Ticket getticket(int trip_id, int seat) {
		
		DatabaseConnecter db=new DatabaseConnecter();
		Connection con = db.getCon();
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql = "Select id,price,status from ticket where tripid="+trip_id+" and seatno="+seat+";";
			ResultSet rs= stmt.executeQuery(sql);
			Ticket t= new Ticket();
			while(rs.next()) {
				t.ticket_id = rs.getString(1);
				t.price = Integer.parseInt(rs.getString(2));
				t.trip_id = String.valueOf(trip_id);
				t.seat_number = seat;
				t.status = rs.getString(3);
			}
			//System.out.println("ticked id: "+ t.ticket_id);
			return t;
		}
		catch(SQLException e) {
			System.out.println("exception: "+e);
			
		}
		return null;
	}

	public boolean createReservation(Ticket ticket, String cnic) {
		DatabaseConnecter db=new DatabaseConnecter();
		Connection con = db.getCon();
		Statement stmt;
		try {
			Random rand = new Random();
			int rand_int1 = rand.nextInt(1000);
			stmt = con.createStatement();
			String sql = "Insert into booking (bookingId,ticketid,customerid) values("+rand_int1+","+ticket.ticket_id+","+cnic+");";
			stmt.executeUpdate(sql);
			String sql1 = "Update ticket set status = 'not available' where id = '"+ticket.ticket_id+"'";
			stmt.executeUpdate(sql1); 
			return true;
		}
		catch(SQLException e) {
			System.out.println("exception: "+e);
			
		}
		return false;
		
	}

	public HashMap<String, String> view_reservation(String cnic) {
		HashMap<String,String> hash = new HashMap<String,String>();
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql = "Select id, seatno from Ticket inner join Booking ON booking.ticketId = ticket.id where customerid ='"+cnic+"';";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				hash.put(rs.getString(0),rs.getString(1));
			}
		}
		catch(SQLException e) {
			System.out.println("exception: "+e); 
			
		}
		return null;
	}

	public void remove_reservation(String trip_id) {
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql = "Select id from ticket where tripid='"+trip_id+"';";
			ResultSet rs= stmt.executeQuery(sql);
			int ticket_id = rs.getInt(sql);
			String sql1 = "Delete from booking where ticketid ='"+ticket_id+"';";
			ResultSet rs2 = stmt.executeQuery(sql1);
			String sql3 = "Update ticket set status = 'available' where ticket_id = '"+ticket_id+"';";
			ResultSet rs3 = stmt.executeQuery(sql3);
		}
		catch(SQLException e) {
			System.out.println("exception: "+e);
			
		}
		return ;
		
	}
 
	
	public boolean updateProfile(User user) {
		DatabaseConnecter db=new DatabaseConnecter();
		Connection con = db.getCon();
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql = "Update User set email='"+user.email+"', phone='"+user.number+"', password='"+user.password+"' where cnic='"+user.cnic+"';";
			stmt.executeUpdate(sql);
			return true;
		}
		catch(SQLException e) {
			System.out.println("exception: "+e);
			
		}
		return false;
		
	}
}


