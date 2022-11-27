package application;

public class Description {

	
	String arrivalTime,departureTime,arrivalVenue,departureVenue;
	int id;
	Description(){
		
		
	}

	Description(int id,String art,String dpt,String dpv, String arv){
		this.id=id;
		this.arrivalTime=art;
		this.arrivalVenue=arv;
		this.departureTime=dpt;
		this.departureVenue=dpv;
		
	}
}
