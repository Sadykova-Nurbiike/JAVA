package shop.model;

import java.util.Date;
import java.text.SimpleDateFormat;
import shop.model.Coffee;
import shop.model.Espresso;
import shop.model.Capuccino;
import shop.model.Order;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;
import java.text.ParseException;


public class Counter{
	
	private static FileWriter fw = null;
	
	public static void main(String[] args) throws Exception {
		
		//Grade 2
		System.out.println("GRADE 2");
		
		Capuccino capuccino = new Capuccino(1.50, "Capuccino", 3, 3);
		System.out.println(capuccino);
		
		Espresso espresso1 = new Espresso(0.75,"Espresso",3);
		System.out.println(espresso1);
		Espresso espresso2 = new Espresso(0.75,"Espresso",2);
		System.out.println(espresso2);
		
		Order order1 = new Order();
		order1.addCoffee(espresso1);
		order1.addCoffee(espresso2);
		order1.addCoffee(capuccino);
		
		//Grade 3
		System.out.println("GRADE 3");
		
		Order order2 = new Order();
		Capuccino capuccino2 = new Capuccino(1.50, "Capuccino", 3, 3);
		order2.addCoffee(capuccino2);
		order2.setOrderTime("20:50");
		order2.setDeliveredTime("20:55");
		Date d = Order.formatter.parse("20:51");
		order2.isLate(d);
		System.out.println(order2);
		
		//Grade 4
		System.out.println("GRADE 4");
		
		Order order3 = new Order();
		order3.setOrderTime("20:49");
		order3.setDeliveredTime("20:55");
		order3.isLate(d);
		order3.addCoffee(capuccino);
		order3.addCoffee(espresso1);
		order3.addCoffee(espresso2);
		
		ArrayList<Order> orders = new ArrayList<>();
		orders.add(order3);
		orders.add(order2);
		
		order1.reOrder(orders);
		
		for(Order o : orders)
		{
			System.out.println(o);
		}
		
		//GRADE 5
		System.out.println("GRADE 5");
		
		Counter c = new Counter();
		Scanner sc = new Scanner(System.in);
		System.out.println("Do you want to print out the orders?");
		String answer = sc.next();
		if(answer.equalsIgnoreCase("y"))
		{
			for(Order o : orders)
			{
				c.printOrder(o);
			}
		}
		
	} 
	
			public void printOrder(Order order)
		{
			try{
				fw = new FileWriter(order.getOrderID() + ".txt" );
				fw.write(order.toString());
				fw.close();
			}catch(Exception e)
			{
				System.out.println("Error while writing to a file");
			}
		}
	
	
}