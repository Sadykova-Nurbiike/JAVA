package models;


import java.util.Date;
import java.text.SimpleDateFormat;

public class GoldenTicket {

    //Attributes:
    private String code;
    private Date raffled;

    //Constructors:
    public GoldenTicket() {
        this.code = "";
        this.raffled = null;
    }

    public GoldenTicket(String code, Date raffled) {
        this.code = code;
        this.raffled = raffled;
    }

    // Getters and Setters:
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getRaffledDate() {
        return raffled;
    }

    public void setRaffledDate(Date raffled) {
        this.raffled = raffled;
    }

    // If the current ticket has been already raffled
    public boolean isRaffled() {
        return this.raffled != null;
    }

    //Custom methods
    @Override
    public String toString() {
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy/MM/dd");
        if (this.isRaffled()) {
            return "\n code: " + this.code
                    + "\n raffled date: " + myFormat.format(this.raffled);
        } else {
            return "\n code: " + this.code;
        }

    }

}

