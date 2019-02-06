package models;


public class Product {

    //Attributes:
    private String description;
    private long barcode;
    private String serialNumber;
    private GoldenTicket prizeTicket;

    //Constructor
    //Constructor with arguments	
    public Product(String description, long barcode, String serialNumber, GoldenTicket prizeTicket) {
        this.description = description;
        this.barcode = barcode;
        this.serialNumber = serialNumber;
        this.prizeTicket = prizeTicket;
    }

    //Getters and Setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getBarcode() {
        return barcode;
    }

    public void setBarcode(long barcode) {
        this.barcode = barcode;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public GoldenTicket getPrizeTicket() {
        return prizeTicket;
    }

    public void setPrizeTicket(GoldenTicket prizeTicket) {
        this.prizeTicket = prizeTicket;
    }

    //methods
    public Boolean hasPrize() {
        return prizeTicket != null;
    }

    //custom methods
    @Override
    public String toString() {
        return "\n description: " + this.description
                + "\n barcode: " + this.barcode
                + "\n serial number: " + this.serialNumber
                + "\n prize ticket: " + this.prizeTicket;

    }

}

