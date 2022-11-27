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
import javafx.scene.*;


public class AdminController {

	@FXML
	public Label confirmLabel;
	@FXML
	public Label error;
	@FXML
	public Label result;
	@FXML
	public TextField statusBusField; 
	@FXML
	public Label schlabel; 
	@FXML
	public TextField busServiceField; 
	@FXML
	public TextField sbusServiceField; 
	@FXML
	public TextField schedule_tripID; 
	@FXML
	public TextField s_deptTimefield; 
	@FXML
	public TextField s_arrivalTimefield; 	
	@FXML
	public TextField tripIdfield;
	@FXML
	public TextField busArrivalVenuefield;
	@FXML
	public TextField busdepartVenuefield;
	@FXML
	public TextField busIdField1;
	@FXML
	public TextField busIdField2;
	@FXML
	public TextField busIdField3;
	@FXML
	public TextField busIdField4;
	@FXML
	public TextField fromfield1;
	@FXML
	public TextField fromfield2;
	@FXML
	public TextField fromfield3;
	@FXML
	public TextField fromfield4;
	@FXML
	public TextField tofield1;
	@FXML
	public TextField tofield2;
	@FXML
	public TextField tofield3;
	@FXML
	public TextField tofield4;
	@FXML
	public TextField departfield1;
	@FXML
	public TextField departfield2;
	@FXML
	public TextField departfield3;
	@FXML
	public TextField departfield4;
	@FXML
	public TextField arrivalfield1;
	@FXML
	public TextField arrivalfield2;
	@FXML
	public TextField arrivalfield3;
	@FXML
	public TextField arrivalfield4;
	@FXML
	public TextField sbusIdField1;
	@FXML
	public TextField sbusIdField2;
	@FXML
	public TextField sbusIdField3;
	@FXML
	public TextField sbusIdField4;
	@FXML
	public TextField statusfield1;
	@FXML
	public TextField statusfield2;
	@FXML
	public TextField statusfield3;
	@FXML
	public TextField statusfield4;
	@FXML
	MenuButton paymentType;
	@FXML
	public TextField cardName;
	@FXML
	public TextField cardno;
	@FXML
	public DatePicker carddate;
	@FXML
	public TextField ticketNo;
	@FXML
	public TextField tripId;
	@FXML
	public TextField nameField;
	@FXML
	public TextField seatNo;
	@FXML
	public TextField fareAmount;
	@FXML
	public TextField departTime;
	@FXML
	public TextField departLoc;
	@FXML
	public TextField arrivalTime;
	@FXML
	public TextField arrivalLoc;
	@FXML
	MenuButton userType;
	@FXML
	public TextField Username;
	@FXML
	public TextField Password;
	@FXML
	public TextField SUsername;
	@FXML
	public TextField Spassword;
	@FXML
	public TextField SEmail;
	@FXML
	public TextField Sprofilepic;
	@FXML
	public TextField SCnic;
	@FXML
	public TextField SPhone;
	@FXML
	public TextField busServiceNameField; 
	@FXML
	public TextArea busDetailArea;
	@FXML
	public Button manageBusesViewBusesBtn;
	
	@FXML
	public Pane DeletePane;
	@FXML
	public Pane AddPane;
	@FXML
	public TextField paneDeleteField; 
	@FXML
	public Button paneDeleteBtn;
	@FXML
	public Button cancelbtn1;
	@FXML
	public TextField addBusNamefield;
	@FXML
	public TextField addBusRegField;
	@FXML
	public TextField addBusSeatsField;
	@FXML
	public Button addBusBtn;
	@FXML
	public Button cancelBtn;
	@FXML
	public Label myLabel5;

	bus_seat_reservation_system bobj=new bus_seat_reservation_system();
	Bus_service object=new Bus_service();
	Trip tobj=new Trip();
	String temp;
	static ArrayList<Bus_service> Bus_services = new ArrayList<Bus_service>();
	static ArrayList <Trip> t = new ArrayList <Trip>();
	static Connection c;
	int localvar=0;
	Stage stage;
	Bus_service obj=new Bus_service();
	FXMLLoader loader = new FXMLLoader();
	Admin admin=new Admin();
	ArrayList<bus> list =new ArrayList<bus>();
	
public void gotoLogin(ActionEvent event) throws IOException {
	    
		String fxmlDocPath = "C:\\Users\\admin\\Documents\\Sda labs\\SDAProject\\src\\fxml\\loginScreen.fxml";
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
		AnchorPane root1 = (AnchorPane) loader.load(fxmlStream);
		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root1,400,400);
		stage.setScene(scene);
		stage.show();
		
		 
	 }
	
public void gotoManageBuss(ActionEvent event) throws IOException {
    
	String fxmlDocPath = "C:\\Users\\admin\\Documents\\Sda labs\\SDAProject\\src\\fxml\\ManageBuses.fxml";
	FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
	AnchorPane root1 = (AnchorPane) loader.load(fxmlStream);
	stage=(Stage)((Node)event.getSource()).getScene().getWindow();
	Scene scene = new Scene(root1,400,400);
	stage.setScene(scene);
	stage.show();
	
	 
 }

	public void gotoSignUp(ActionEvent event) throws IOException {
	    
		String fxmlDocPath = "C:\\Users\\admin\\Documents\\Sda labs\\SDAProject\\src\\fxml\\SignUp.fxml";
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
		AnchorPane root1 = (AnchorPane) loader.load(fxmlStream);
		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root1,400,400);
		stage.setScene(scene);
		stage.show();
		
		 
	 }
	
	public void gotoViewBusSchedule(ActionEvent event) throws IOException {
		    String fxmlDocPath = "C:\\Users\\admin\\Documents\\Sda labs\\SDAProject\\src\\fxml\\viewBusSchedule.fxml";
			FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
			AnchorPane root1 = (AnchorPane) loader.load(fxmlStream);
			stage=(Stage)((Node)event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root1,600,600);
			stage.setScene(scene);
			stage.show();
			
			 
		 }
	
	 
	 public void gotoViewBusStatus(ActionEvent event) throws IOException {
		    
		 	String fxmlDocPath = "C:\\Users\\admin\\Documents\\Sda labs\\SDAProject\\src\\fxml\\viewBusStatus.fxml";
			FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
			AnchorPane root2 = (AnchorPane) loader.load(fxmlStream);
			stage=(Stage)((Node)event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root2,500,600);
			stage.setScene(scene);
			stage.show();
			
			
			 
	}
	 

	 public void gotoViewChangeRoute(ActionEvent event) throws IOException {
		 	
		   
		   // busLabel.setText(object.getBusService());
		 	String fxmlDocPath = "C:\\Users\\admin\\Documents\\Sda labs\\SDAProject\\src\\fxml\\changeRoute.fxml";
			FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
			AnchorPane root1 = (AnchorPane) loader.load(fxmlStream);
			stage=(Stage)((Node)event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root1,600,600);
			stage.setScene(scene);
			stage.show();
			
			
			 
	} 
	
	 public void gotoViewChangeSchedule(ActionEvent event) throws IOException {
			
			String fxmlDocPath = "C:\\Users\\admin\\Documents\\Sda labs\\SDAProject\\src\\fxml\\changeSchedule.fxml";
			FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
			AnchorPane root1 = (AnchorPane) loader.load(fxmlStream);
			stage=(Stage)((Node)event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root1,600,600);
			stage.setScene(scene);
			stage.show();
		
			
			 
	} 
	 
	 @FXML
	 public void gotoManageBuses(ActionEvent event) throws IOException {
		 
			String fxmlDocPath = "C:\\Users\\admin\\Documents\\Sda labs\\SDAProject\\src\\fxml\\mngBuses.fxml";
			FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
			AnchorPane root1 = (AnchorPane) loader.load(fxmlStream);
			stage=(Stage)((Node)event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root1,600,600);
			stage.setScene(scene);
			stage.show();
		
			
			 
	}  
	
	 @FXML
	 public void gotoInvoiceScreen(ActionEvent event) throws IOException {
		 
			String fxmlDocPath = "C:\\Users\\admin\\Documents\\Sda labs\\SDAProject\\src\\fxml\\viewInvoice.fxml";
			FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
			AnchorPane root1 = (AnchorPane) loader.load(fxmlStream);
			stage=(Stage)((Node)event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root1,400,400);
			stage.setScene(scene);
			stage.show();
		
			
			 
	 } 
	 
	 @FXML
	 public void gotoPaymentScreen(ActionEvent event) throws IOException {
		 
			String fxmlDocPath = "C:\\Users\\admin\\Documents\\Sda labs\\SDAProject\\src\\fxml\\paymentScreen.fxml";
			FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
			AnchorPane root1 = (AnchorPane) loader.load(fxmlStream);
			stage=(Stage)((Node)event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root1,400,400);
			stage.setScene(scene);
			stage.show();
		
			
			 
	}  
	
	 @FXML
		public void goToViewSchedule(ActionEvent event) throws IOException
		{
			gotoViewBusSchedule(event);
						
		} 
		
		@FXML
		public void goto_Schedule(ActionEvent event) throws IOException
		{
			gotoViewChangeSchedule(event);
						
		} 	
		
		@FXML
		public void edit_Route(ActionEvent event) throws IOException
		{
			gotoViewChangeRoute(event);
			
		}
		
		@FXML
		public void goToInvoiceScreen(ActionEvent event) throws IOException
		{
			gotoInvoiceScreen(event);
							
		}
		@FXML
		public void goToStatusScreen(ActionEvent event) throws IOException
		{
			 	gotoViewBusStatus(event);
							
		} 
	
	
	@FXML
	public void addBusClicked(ActionEvent event) throws IOException {
		 
		 
		 bus b=new bus(addBusNamefield.getText(), addBusRegField.getText() , Integer.parseInt(addBusSeatsField.getText()));
		 
		 if( bobj.addBus(b,busServiceNameField.getText())) 
			 myLabel5.setText("Operation Sucessfull! Click Referesh to view changes");
		 AddPane.setVisible(false);		 
	 }
	
	 @FXML
	 public void deleteBusClicked(ActionEvent event) throws IOException {
		 String id=paneDeleteField.getText();
		 int temp=Integer.parseInt(id);
		 temp-=1;
		 bus b=new bus(null, list.get(temp).bus_reg_number , 0);
		 if( bobj.deleteBusClicked(b,null))
		 myLabel5.setText("Operation Sucessful! Click Refresh to view changes");
		 DeletePane.setVisible(false);		 
		 
	 }  
	
	 @FXML
	 public void viewBusDetailsClicked(ActionEvent event) throws IOException {
		 myLabel5.setText("");
		 list = bobj.viewBusDetails(busServiceNameField.getText());
		 busDetailArea.setText("");
		 for(int i=0;i<list.size();i++)
			 busDetailArea.appendText("\n\t"+(i+1)+"\t\t\t\t"+list.get(i).bus_name+"\t\t\t\t\t"+list.get(i).bus_reg_number+"\t\t\t\t\t"+list.get(i).seats+"\n");
		 	 
	 }
	 
	 @FXML
	 public void gotoMngBsesDeleteScreen(ActionEvent event) throws IOException {
		 
		 DeletePane.setVisible(true);		 
	 }  
	 @FXML
	 public void gotoMngBsesAddScreen(ActionEvent event) throws IOException {
		 
		 AddPane.setVisible(true);		 
	 }
	 @FXML
	 public void cancelBtnClicked(ActionEvent event) throws IOException {
		 
		AddPane.setVisible(false);		 
	 }  
	 @FXML
	 public void cancelBtn1Clicked(ActionEvent event) throws IOException {
		 
		DeletePane.setVisible(false);		 
	 }  
	 
	 
	 @FXML
	 public void afterLogin(ActionEvent event) throws IOException, InterruptedException {
		 
		 CustomerController c=new CustomerController();
		 if(localvar==1) {
			 gotoManageBuses(event);
		 }else if(localvar==2) {
			 c.gotoCustomermenu(event);
		 } else
			 error.setText("Incorrect Credentials! Try Again");
			 
		 localvar=0;	 
		 
	 }	
	 
	
	@FXML
	public void AdminLogin(ActionEvent event) throws IOException
	{
		
		DBHandler obj=new DBHandler();
		ArrayList<User> data=obj.readLoginData(0);
		for(int i=0;i<data.size();i++) {
				
				if(data.get(i).name.equals(Username.getText())  &&  data.get(i).password.equals(Password.getText())){
					localvar=1;
				}
			}
			
			
		
			
	}
	@SuppressWarnings("static-access")
	@FXML
	public void CustomerLogin(ActionEvent event) throws IOException
	{
		DBHandler obj=new DBHandler();
		
		ArrayList<User> data=obj.readLoginData(1);
		for(int i=0;i<data.size();i++) {
				if(data.get(i).name.equals(Username.getText())  &&  data.get(i).password.equals(Password.getText())){
					User.currentUser = obj.view_profile(Username.getText());
					localvar=2;
				}
			}
		
			
	}
	
	@SuppressWarnings("static-access")
	@FXML
	public void CustomerRegsiter(ActionEvent event) throws IOException
	{
		DBHandler obj=new DBHandler();
		User objct=new User();
		objct.cnic=SCnic.getText();
		objct.name=SUsername.getText();
		objct.password=Spassword.getText();
		objct.email=SEmail.getText();
		objct.profile_picture=Sprofilepic.getText();
		objct.number=SPhone.getText();	
		
		if(obj.registerNewCustomer(objct)) {
			result.setText("Regsiteration successful! Please Login now....");
			User.currentUser=objct;
		}else
			result.setText("Error!");
			
	}
	
	
	@FXML
	public void displaySchedule(ActionEvent event) throws IOException
	{
		 
		 object.setBusService(sbusServiceField.getText());
		
		 ArrayList<Description> data=new ArrayList<Description>(); 
		 data= bobj.getAllDescriptions(sbusServiceField.getText());		 		
		int i=0;			
		busIdField1.setText(Integer.toString(data.get(i).id)); fromfield1.setText(data.get(i).departureVenue); tofield1.setText(data.get(i).arrivalVenue); departfield1.setText(data.get(i).departureTime); arrivalfield1.setText(data.get(i).arrivalTime);i++;
		busIdField2.setText(Integer.toString(data.get(i).id)); fromfield2.setText(data.get(i).departureVenue); tofield2.setText(data.get(i).arrivalVenue); departfield2.setText(data.get(i).departureTime); arrivalfield2.setText(data.get(i).arrivalTime);i++;
		busIdField3.setText(Integer.toString(data.get(i).id)); fromfield3.setText(data.get(i).departureVenue); tofield3.setText(data.get(i).arrivalVenue); departfield3.setText(data.get(i).departureTime); arrivalfield3.setText(data.get(i).arrivalTime);i++;
		busIdField4.setText(Integer.toString(data.get(i).id)); fromfield4.setText(data.get(i).departureVenue); tofield4.setText(data.get(i).arrivalVenue); departfield4.setText(data.get(i).departureTime); arrivalfield4.setText(data.get(i).arrivalTime);i++;
				
	}  
	 
	
	
	
	@FXML
	public void save_Route(ActionEvent event) throws IOException
	{
		object.setBusService(busServiceField.getText());
		boolean status=false;
				
		String tripId,departV,arrivalV;
		tripId=tripIdfield.getText();
		departV=busdepartVenuefield.getText();
		arrivalV=busArrivalVenuefield.getText();
		status=bobj.editRoute(object.getBusService(), tripId, departV, arrivalV);
		// sbusServiceField.setText(busServiceField.getText());		
		
		if(status)
			confirmLabel.setText("Data has been updated! Go to back screen, enter bus service name and click view");
		else
			confirmLabel.setText("Error updating data!");
	}
	
	public void edit_Schedule(ActionEvent event) throws IOException
	{
		object.setBusService(busServiceField.getText());
		boolean status=false;
				
	    String tripId,departTime,arrivalTime;

		tripId=schedule_tripID.getText();
		departTime=s_deptTimefield.getText();
		arrivalTime=s_arrivalTimefield.getText();	
		
		status= bobj.editTripSchedule(busServiceField.getText(), tripId, departTime, arrivalTime);
			
		if(status)
			schlabel.setText("Schedule has been updated, Go to back screen, enter bus service name and click view");
		else
			schlabel.setText("Error");
		
		
	}
	
	
	@FXML
	public void view_BusStatus(ActionEvent event) throws IOException
	{
		
		object.setBusService(statusBusField.getText());
		ArrayList<Trip> data=new ArrayList<Trip>();
		data=bobj.getStatus( object.getBusService());
		int i=0;
		sbusIdField1.setText(data.get(i).tripId);statusfield1.setText(data.get(i).status);i++;
		sbusIdField2.setText(data.get(i).tripId);statusfield2.setText(data.get(i).status);i++;
		sbusIdField3.setText(data.get(i).tripId);statusfield3.setText(data.get(i).status);i++;
		sbusIdField4.setText(data.get(i).tripId);statusfield4.setText(data.get(i).status);i++;
				
						
	}
	
	
}
