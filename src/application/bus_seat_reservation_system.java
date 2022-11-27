package application;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import application.DBHandler;
import application.PersistanceHandler;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.*;

public class bus_seat_reservation_system  extends Application  {
	
	
	static Connection c;
	Stage stage;
	FXMLLoader loader = new FXMLLoader();
	Admin admin=new Admin();
	User userObj=new User();
	Bus_service busserviceobj=new Bus_service();
	String path = "C:\\Users\\admin\\Documents\\Sda labs\\SDAProject\\src\\"; 
	@Override
	public void start(Stage stage) throws Exception {
		
		try {
			
			String fxmlDocPath = path+"fxml\\loginScreen.fxml" ;
			FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
			AnchorPane root = (AnchorPane) loader.load(fxmlStream);
			Scene scene = new Scene(root,600,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);			
			stage.show();
						
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	
/*
	
	@FXML
	public void confirmPayment(ActionEvent event) throws IOException
	{

		 
		
	}
	
	@FXML
	public void goToInvoiceScreen(ActionEvent event) throws IOException
	{
		gotoInvoiceScreen(event);
						
	}
	
	public void printInvoice(ActionEvent event) throws IOException
	{
		
		ticketNo.setText("001");
		
	}
	
	*/
	
	@FXML
	 public void gotoMngBsesScreen(ActionEvent event) throws IOException {
		 
			String fxmlDocPath = "C:\\Users\\admin\\Documents\\Sda labs\\SDAProject\\src\\fxml\\ManageBuses.fxml";
			FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
			AnchorPane root1 = (AnchorPane) loader.load(fxmlStream);
			stage=(Stage)((Node)event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root1,400,400);
			stage.setScene(scene);
			stage.show();		 
	}  
	
	 
	 
	 public boolean addBus( bus bus, String busServiceid ) {
		 
		
		 if( admin.addNewBus(bus, busServiceid))
			return true;
		 else
			 return false;
		 		 
	 }
	 
	 public boolean deleteBusClicked(bus bus, String busServiceid) {
		
		 if( admin.deleteBus(bus, busServiceid))
				return true;
			 else
				 return false;
			 		 		 
		 
	 }
	 
	
	 public ArrayList<bus> viewBusDetails(String busServiceid) {
		
		 return (admin.ViewBusDetails(busServiceid));
	 }
	 
	 public ArrayList<Description> getAllDescriptions(String id){
			
			return ( admin.getAllDescriptions(id) );
	}

	public boolean editTripSchedule( String busServiceid ,String id,String dtime, String atime )
	{
			return ( admin.editTripSchedule(busServiceid, id, dtime, atime));  
	} 
	 
	public boolean editRoute(String busServiceid  ,String id,String dVenue, String aVenue) {
			return( admin.editRoute(busServiceid, id, dVenue, aVenue) );
	}
	 
	 public ArrayList<Trip> getStatus(String id)
	{
		 return(admin.getStatus(id));
	} 
	
	 public boolean updateProfile(User user) {
			
			return (userObj.updateProfile(user));
				
	}
	 
	 Trip searchTrip(int r) {
		 
		 return (busserviceobj.searchTrip(r));
	 }
	 
	 int getTrip(String arrival,String departure) {
		 Trip t=new Trip();
		 return (t.getTrip(arrival, departure));
	 } 
	 
	 public static void main(String[] args) {
			
			PersistanceHandler handler=new DBHandler();
			c = handler.connectDB();
			DatabaseConnecter db=new DatabaseConnecter();
			db.setCon(c);
			
			launch(args);
	}

	
}

