package models;


import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

//INHERITANCE
public class Kid extends Being {

    //Attributes
    private Date birthday;
    private ArrayList<Product> purchasedProducts;
    private String placeOfBirth;

    //Constructors:
    //Constructor without arguments	
    public Kid() {
        this.purchasedProducts = new ArrayList<Product>();
    }

    //Constructor with arguments	
    public Kid(String code, Date birthday, String name, ArrayList<Product> purchasedProducts, String placeOfBirth) {

        super(name, code);
        this.birthday = birthday;
        this.purchasedProducts = purchasedProducts;
        this.placeOfBirth = placeOfBirth;
    }

    //Getters and Setters
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public ArrayList<Product> getPurchasedProducts() {
        return purchasedProducts;
    }

    public void setPurchasedProducts(ArrayList<Product> purchasedProducts) {
        this.purchasedProducts = purchasedProducts;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    //custom methods
    @Override
    public String toString() {
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy/MM/dd");
        return super.toString()
                + " birthday: " + myFormat.format(this.birthday)
                + "\n place of birth: " + this.placeOfBirth;

    }

}
