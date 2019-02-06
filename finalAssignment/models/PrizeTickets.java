package models;

import java.util.ArrayList;
import java.util.Random;

public class PrizeTickets {

    //Attributes:
    ArrayList<GoldenTicket> prizeTicketsList;
    ArrayList<GoldenTicket> raffledTicketsList;

    //Helper
    private Random random;

    public PrizeTickets() {
        System.out.println("Prize tickets registration is started.");

        prizeTicketsList = new ArrayList<GoldenTicket>();
        raffledTicketsList = new ArrayList<GoldenTicket>();

        random = new Random();
    }

    public void addPrizeTicket(GoldenTicket g) {
        prizeTicketsList.add(g);
    }

    public ArrayList<GoldenTicket> getPrizeTicketsList() {
        return this.prizeTicketsList;
    }

    public ArrayList<GoldenTicket> getRaffledTicketsList() {
        return this.raffledTicketsList;
    }

    public GoldenTicket getRandomPrizeTicketToRaffle() {
        GoldenTicket g = prizeTicketsList.get(random.nextInt(prizeTicketsList.size()));
        raffledTicketsList.add(g);
        prizeTicketsList.remove(g); //remove not to select raffled ticket next time
        return g;
    }
}

