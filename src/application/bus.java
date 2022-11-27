package application;

import java.util.ArrayList;

public class bus {


		String bus_name;
		String bus_reg_number;
		int seats;
		ArrayList <Trip> trips = new ArrayList <Trip>();
		public String servicename;
		
		
		
		public bus(String bus_name, String bus_reg_number, int seats) {
			super();
			this.bus_name = bus_name;
			this.bus_reg_number = bus_reg_number;
			this.seats = seats;
		}
		
		public bus(String bus_name, String bus_reg_number, int seats,String b) {
			super();
			this.bus_name = bus_name;
			this.bus_reg_number = bus_reg_number;
			this.seats = seats;
			this.servicename=b;
		}

		public bus() {
			// TODO Auto-generated constructor stub
		}
		
		
	
}
