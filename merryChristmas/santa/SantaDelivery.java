package santa;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SantaDelivery extends SantaSaying{
	
	//Attributes
	private Kid kid;
	private Date deliveryTime;
	private String address;
	private SimpleDateFormat myFormat;
	
	//Constructor
	public SantaDelivery(Kid kid, String deliveryTime, String address) throws Exception{
	    myFormat = new SimpleDateFormat("HH:mm");
		this.kid = kid;
		this.deliveryTime = myFormat.parse(deliveryTime);
		this.address = address;
	}
	
	//Getters and setters
	public Kid getKid(){
		return kid;
	}
	
	public void setKid(Kid kid){
		this.kid = kid;
	}
	
	public Date getDeliveryTime(){
		return deliveryTime;
	}
	
	public void setDeliveryTime(String deliveryTime) throws ParseException{
		this.deliveryTime = myFormat.parse(deliveryTime);
	}
	
	public String getAddress(){
		return address;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	
	//Methods	
	//@Override
	public static String  hoHoHo(){
		 return "Ho Ho Ho, the traffic is crazy today";
	}
	
	@Override
	public String  toString(){
		if(kid.isGoodKid()){
		return "Delivery to "+ this.address + " for " + this.kid + " at " + myFormat.format(this.deliveryTime);
		}
		return "No delivery for " + this.kid + ", because he was bad";
	}
} 