package shop.model;


public abstract class Coffee {
	
	double price;
	private static int amount = 0;
	
	public void setPrice(double price){
		this.price = price;
	}
	public double getPrice(){
		return this.price;
	}
	
	public Coffee ()
	{
		amount++;
		this.price = 0;
	}
	public Coffee (double price)
	{
		amount++; 
		this.price = price;
	}
	
	public static int coffeesAmount ()
	{ 
		return amount;
	}
	
	//Methods
	@Override
	public String toString()
	{
		return "coffee: " + this.amount + ", price: " + this.price;
	}
}