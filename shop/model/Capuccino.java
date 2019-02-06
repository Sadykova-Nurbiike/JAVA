package shop.model;

public class Capuccino  extends Coffee  {
	
	private String brand;
	private int coffeeDeciliters ;
	private int milkDeciliters ;
	
	public String getBrand()
	{
		return this.brand;
	}
	public void setBrand(String brand)
	{
		this.brand = brand;
	}
	public int getCoffeeDeciliters()
	{
		return this.coffeeDeciliters;
	}
	public void setCoffeeDeciliters(int coffeeDeciliters)
	{
		this.coffeeDeciliters = coffeeDeciliters;
	}
	public int getMilkDeciliters()
	{
		return this.milkDeciliters;
	}
	public void setMilkDeciliters(int milkDeciliters)
	{
		this.milkDeciliters = milkDeciliters;
	}
	
	public Capuccino(double price, String brand, int coffeeDeciliters, int milkDeciliters)
	{
		super(price);
		this.brand = brand;
		this.coffeeDeciliters = coffeeDeciliters;
		this.milkDeciliters = milkDeciliters;
	}
	
	//Methods
	@Override
	public String toString()
	{
		return super.toString() + ", "+this.brand+"," + this.coffeeDeciliters + " dl coffee, " + this.milkDeciliters + "dl milk \n";
	}
}