package models;


import java.util.ArrayList;

public class BeingsRegistration {

    //Attributes:
    ArrayList<Kid> kidsList;
    ArrayList<OompaLoompa> oompaLoompasList;

    //Constructors:
    public BeingsRegistration() {

        System.out.println("Beings registration is started.");
        kidsList = new ArrayList<Kid>();
        oompaLoompasList = new ArrayList<OompaLoompa>();
    }

    //Methods for KidsList
    public void addKid(Kid k) {
        kidsList.add(k);
    }

    public ArrayList<Kid> getKidsList() {
        return this.kidsList;
    }

    // Return the index of the kid according to code 
    public int findKidByCode(String code) {

        for (int i = 0; i < kidsList.size(); i++) {
            Kid k = kidsList.get(i);
            if (k.getCode().equalsIgnoreCase(code)) {
                return i;
            }

        }
        return -1;
    }

    public Kid getKidByCode(String code) {

        int index = findKidByCode(code);
        if (index >= 0) {
            return kidsList.get(index);
        }
        return null;
    }

    public boolean removeKid(String code) {

        int index = findKidByCode(code);
        if (index <= 0) {
            return false;
        }

        kidsList.remove(index);
        return true;

    }

    //Methods for OompaLoompasList
    public void addOompaLoompa(OompaLoompa oo) {
        oompaLoompasList.add(oo);
    }

    public ArrayList<OompaLoompa> getOompaLoompasList() {
        return this.oompaLoompasList;
    }

    // Return the index of the OompaLoompa according to code 
    public int findOompaLoompaByCode(String code) {

        for (int i = 0; i < oompaLoompasList.size(); i++) {
            OompaLoompa oo = oompaLoompasList.get(i);
            if (oo.getCode().equalsIgnoreCase(code)) {
                return i;
            }

        }
        return -1;
    }

    public boolean removeOompaLoompa(String code) {

        int index = findOompaLoompaByCode(code);
        if (index <= 0) {
            return false;
        }

        oompaLoompasList.remove(index);
        return true;

    }

    //Other auxilary methods
    public void printKidDataForRegisterSale() {
        for (Kid k : kidsList) {
            System.out.println(k.getName() + ":" + k.getCode());
        }
    }

}



