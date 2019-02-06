package shop.model;

import java.util.Date;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import shop.model.Coffee;

public class Order implements OrderNumber {
	
	//Attributes
	private ArrayList<Coffee> coffees;
	private Date orderTime;
	private Date deliveredTime;
	
    static final SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
	private String islate = "";
	
	//Attribute GRADE 4
	private static Integer orderNumber;
	
	private int orderID;
	
	//Getters and Setters
	public  Date getOrderTime()
	{
		return this.orderTime;
	}
	public void setOrderTime(Date orderTime)
	{
		this.orderTime = orderTime;
	}
	public void setOrderTime(String orderTime) throws Exception
	{
		this.orderTime = formatter.parse(orderTime);
	}
	
	public  Date getDeliveredTime()
	{
		return this.deliveredTime;
	}
	public void setDeliveredTime(Date deliveredTime)
	{
		this.deliveredTime = deliveredTime;
	}
	public void setDeliveredTime(String deliveredTime) throws Exception
	{
		this.deliveredTime = formatter.parse(deliveredTime);
	}
	public void addCoffee(Coffee coffee)
	{
		this.coffees.add(coffee);
	}
	public int getOrderID()
	{
		return this.orderID;
	}	
	//Constructors
	public Order()
	{
		if(orderNumber==null)
		{
			orderNumber = 1;
			orderID = orderNumber;
		}else
		{
			orderNumber++;
			orderID = orderNumber;
		}
		coffees = new ArrayList<Coffee>();
		this.orderTime = null;
		this.deliveredTime = null;
		
	}
	
	public Order(Date orderTime, Date deliveredTime) {
		coffees = new ArrayList<>();
		this.orderTime = orderTime;
		this.deliveredTime = deliveredTime;
		if(orderNumber==null)
		{
			orderNumber = 1;
			orderID = orderNumber;
		}else
		{
			orderNumber++;
			orderID = orderNumber;
		}
	}
	
	public Order(String orderTime, String deliveredTime) throws Exception {
		coffees = new ArrayList<>();
		setOrderTime(orderTime);
		setDeliveredTime(deliveredTime);
		if(orderNumber==null)
		{
			orderNumber = 1;
			orderID = orderNumber;
		}else
		{
			orderNumber++;
			orderID = orderNumber;
		}
	}
	
	public Order(Coffee coffee, String orderTime, String deliveredTime) throws Exception {
		coffees = new ArrayList<>();
		coffees.add(coffee);
		setOrderTime(orderTime);
		setDeliveredTime(deliveredTime);
		if(orderNumber==null)
		{
			orderNumber = 1;
			orderID = orderNumber;
		}else
		{
			orderNumber++;
			orderID = orderNumber;
		}
	}
	
	public Order(ArrayList<Coffee> coffees, String orderTime, String deliveredTime) throws Exception {
		this.coffees = new ArrayList<>(coffees);
		setOrderTime(orderTime);
		setDeliveredTime(deliveredTime);
		if(orderNumber==null)
		{
			orderNumber = 1;
			orderID = orderNumber;
		}else
		{
			orderNumber++;
			orderID = orderNumber;
		}
	}
	
	
	//Methods
	public boolean wasLate(Date d)
	{
		if(this.deliveredTime == null || d.before(this.deliveredTime))
		{
			return true;
		}
		else{
			return false;
		}
	}
	
	public void isLate(Date d)
	{
		if(wasLate(d))
		{
			islate = "[late]" ;
		}
	}
	
	public double totalPrice(){
		double sum = 0.0;
		for(Coffee c : coffees)
		{
			sum = sum + c.getPrice();
		}
		return sum;
	}
	
	@Override
	public String toString()
	{
		
		String coffeesString = "";
		for(Coffee c: coffees)
		{
			coffeesString = coffeesString + c.toString() + "\n";
		}
		
		return "Order Output: \n" +
				"Ordered: " + formatter.format(this.orderTime) + "\n" +
				"Delivered: " + formatter.format(this.deliveredTime) + " " + islate+ "\n" +
				"Price: " + this.totalPrice() + "\n" +
				"Order: " + this.orderID + "\n" + 
				coffeesString;
	}
	
	
	//GRADE 4
	public  int getOrderNumber(){
		if(orderNumber.equals(null))return 0;
		return orderNumber;
	}
	
	public void reOrder(ArrayList<Order> orders) 
	{
		// make a bubble sort of the orders
		for(int i=0; i<orders.size(); i++){
			for (int j=i; j<orders.size(); j++){
				Date orderTime1 = orders.get(i).getOrderTime();
				Date orderTime2 = orders.get(j).getOrderTime();
				
				if(orderTime1.before(orderTime2)){
					Collections.swap(orders, i, j);					
				}
				else if (orderTime1.equals(orderTime2))
				{
					if(orders.get(i).totalPrice() > orders.get(j).totalPrice())
					{
						Collections.swap(orders, i, j);
					}
				}					
			}
		}
	}
	
	
}