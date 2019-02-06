package models;


//INHERITANCE
public class OompaLoompa extends Being {

    //Attributes
    private double height;
    private String favoriteFood;

    //Constructors:
    //Constructor with arguments	
    public OompaLoompa(String code, String name, double height, String favoriteFood) {
        super(name, code);
        this.height = height;
        this.favoriteFood = favoriteFood;
    }

    //Getters and Setters:
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    //custom methods
    @Override
    public String toString() {

        return super.toString()
                + " height: " + this.height
                + "\n favorite food: " + this.favoriteFood;

    }

}
