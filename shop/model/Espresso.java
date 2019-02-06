package shop.model;

public class Espresso extends Coffee  {
	
	private String brand;
	private int coffeeDeciliters ;
	
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
	
	
	public Espresso(double price, String brand, int coffeeDeciliters)
	{
		super(price);
		this.brand = brand;
		this.coffeeDeciliters = coffeeDeciliters;
	}
	
	//Methods
	@Override
	public String toString()
	{
		return super.toString() + ", "+this.brand+"," + this.coffeeDeciliters + "dl coffee\n";
	}
	
}