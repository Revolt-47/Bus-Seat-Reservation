package application;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
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
import javafx.scene.*;

public class CustomerController {

	@FXML
    public Label tripidl;
	@FXML
    public Label farel;
	@FXML
    public Label froml;
	@FXML
    public Label ticketConfirmation;
	@FXML
    public Label tol;
	@FXML
    public Label depl;
	@FXML
    public Label arrl;
	@FXML
    public Label tripSearch;
	@FXML
    public Label done;
	@FXML
    public TextField tripid;
	@FXML
    public TextField seat;
	@FXML
	public TextField find;
	@FXML
	public DatePicker date;
	@FXML
	public TextField arrival;
	@FXML
	public TextField seatNo;
	@FXML
	public TextField departure;
	@FXML
	public TextField bus;
	@FXML
	public TextField number;
	@FXML
    public TextField holder;
	@FXML
    public TextField cvc;
	@FXML
    public DatePicker expiry;
	@FXML
	public TextField arrivalt;
	@FXML
	public TextField departuret;
	@FXML
	public TextArea b2;
	@FXML
	public TextField edits;
	@FXML
	public ImageView image;
	@FXML
    public TextField name;
	@FXML
    public TextField phone;
	@FXML
    public TextField email;
	@FXML
	public TitledPane editbox;
	@FXML
    public TextField editingbox;
	@FXML
	public TextArea b1;
	@FXML
    public TextField namefield;
	@FXML
    public TextField phonefield1;
	@FXML
    public TextField cnicfield;
	@FXML
    public TextField emailfield;
	@FXML
    public TextField passwordfield;
	@FXML
    public TextField ticketno;
	@FXML
    public TextField tripIdf;
	@FXML
    public TextField namef;
	@FXML
    public TextField seatnof;
	@FXML
    public TextField faref;
	@FXML
    public TextField departTimef;
	@FXML
    public TextField departLocf;
	@FXML
    public TextField arrivalTime;
	@FXML
    public TextField arrivalLoc;
	
	int tripID=-2;
	String BusService="";
	Stage stage;
	Bus_service obj=new Bus_service();
	FXMLLoader loader = new FXMLLoader();
	bus_seat_reservation_system bobj=new bus_seat_reservation_system();
	
	public void gotoManageProfile(ActionEvent event) throws IOException {
	    
		String fxmlDocPath = "C:\\Users\\admin\\Documents\\Sda labs\\SDAProject\\src\\fxml\\ManageProfile.fxml";
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
		AnchorPane root1 = (AnchorPane) loader.load(fxmlStream);
		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root1,400,400);
		stage.setScene(scene);
		stage.show();
		
		 
	 }
public void gotoCustomermenu(ActionEvent event) throws IOException {
	    
		String fxmlDocPath = "C:\\Users\\admin\\Documents\\Sda labs\\SDAProject\\src\\fxml\\customerMenu.fxml";
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
		AnchorPane root1 = (AnchorPane) loader.load(fxmlStream);
		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root1,400,400);
		stage.setScene(scene);
		stage.show();
		
		 
	 }
	
public void gotoBookTicket1(ActionEvent event) throws IOException {
	    
		String fxmlDocPath = "C:\\Users\\admin\\Documents\\Sda labs\\SDAProject\\src\\fxml\\booking1.fxml";
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
		AnchorPane root1 = (AnchorPane) loader.load(fxmlStream);
		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root1,400,400);
		stage.setScene(scene);
		stage.show();
		
		 
	 }

public void gotoBookTicket2(ActionEvent event) throws IOException {
    
	String fxmlDocPath = "C:\\Users\\admin\\Documents\\Sda labs\\SDAProject\\src\\fxml\\booking2.fxml";
	FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
	AnchorPane root1 = (AnchorPane) loader.load(fxmlStream);
	stage=(Stage)((Node)event.getSource()).getScene().getWindow();
	Scene scene = new Scene(root1,400,400);
	stage.setScene(scene);
	stage.show();
	
	 
 }

public void gotoPaymentScreen(ActionEvent event) throws IOException {
    
	String fxmlDocPath = "C:\\Users\\admin\\Documents\\Sda labs\\SDAProject\\src\\fxml\\payment.fxml";
	FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
	AnchorPane root1 = (AnchorPane) loader.load(fxmlStream);
	stage=(Stage)((Node)event.getSource()).getScene().getWindow();
	Scene scene = new Scene(root1,400,400);
	stage.setScene(scene);
	stage.show();
	
	 
 }

public void gotoInvoiceScreen(ActionEvent event) throws IOException {
    
	String fxmlDocPath = "C:\\Users\\admin\\Documents\\Sda labs\\SDAProject\\src\\fxml\\invoice.fxml";
	FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
	AnchorPane root1 = (AnchorPane) loader.load(fxmlStream);
	stage=(Stage)((Node)event.getSource()).getScene().getWindow();
	Scene scene = new Scene(root1,400,400);
	stage.setScene(scene);
	stage.show();
	
	 
 }
	
	@FXML
	public void saveProfile(ActionEvent event) throws IOException {
		
		User updatedUser = new User(cnicfield.getText(),phonefield1.getText(),emailfield.getText(),passwordfield.getText());
		if(bobj.updateProfile(updatedUser))
			done.setText("Done");
		else
			done.setText("Error!");
			
	}
	
	@FXML
	public void showProfile(ActionEvent event) throws IOException {
		User u=new User();
		namefield.setText(User.currentUser.name);
		cnicfield.setText(User.currentUser.cnic);
		phonefield1.setText(User.currentUser.number);
		emailfield.setText(User.currentUser.email);
		passwordfield.setText(User.currentUser.password);
		
		
	}
	
	@FXML
	public void setBusService1(ActionEvent event) throws IOException {
		BusService="Bilal Travels";
	}
	
	@FXML
	public void searchTrip(ActionEvent event) throws IOException {
		
		Trip.currtrip = bobj.getTrip(arrival.getText(), departure.getText()); 
		if ( Trip.currtrip!=-2 && Trip.currtrip!=-1 ) {
			tripSearch.setText("Found a trip for you!");
			gotoBookTicket2(event);
		}else
			tripSearch.setText("Error!");
	}
	
	@FXML
	public void displayTrip(ActionEvent event) throws IOException {
		Trip.selectedTrip = bobj.searchTrip(Trip.currtrip);
		
		tripidl.setText(Trip.selectedTrip.tripId);
		froml.setText(Trip.selectedTrip.desc.departureVenue);
		tol.setText(Trip.selectedTrip.desc.arrivalVenue);
		farel.setText("100");
		depl.setText(Trip.selectedTrip.desc.departureTime);
		arrl.setText(Trip.selectedTrip.desc.arrivalTime);
		
	}
	
	
	@FXML
	public void doPayment(ActionEvent event) throws IOException {
		Ticket.selectedSeat = Integer.parseInt(seatNo.getText());
		gotoPaymentScreen(event);
	}
	
	@FXML
	public void generateInvoice(ActionEvent event) throws IOException {
		Random rand = new Random();
		int rand_int1 = rand.nextInt(1000);
		
		ticketno.setText(String.valueOf(rand_int1));
		tripIdf.setText(Trip.selectedTrip.tripId);
		seatnof.setText(""+Ticket.selectedSeat);
		faref.setText("100");
		departTimef.setText(Trip.selectedTrip.desc.departureTime);
		departLocf.setText(Trip.selectedTrip.desc.departureVenue);
		arrivalTime.setText(Trip.selectedTrip.desc.arrivalTime);
		arrivalLoc.setText(Trip.selectedTrip.desc.arrivalVenue);
		//namef.setText(User.currentUser.name);
	}
	
	@FXML
	public void BookTicket(ActionEvent event) throws IOException {
		User u=new User();
		if ( u.book_ticket("Bilal Travels",Trip.selectedTrip,Ticket.selectedSeat,User.currentUser) )
			ticketConfirmation.setText("Reservation Sucessful!");
		
	}
}
