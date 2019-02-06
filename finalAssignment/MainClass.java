import java.io.FileNotFoundException;

public class MainClass {

    public static void main(String[] args) throws FileNotFoundException,Exception {
        /*1 - Register Prize tickets
          4 - Create a new Oompa Loompa song
          5 - Register Beings
          6 - Register Products
          4 - Create a new Oompa Loompa song*/
        Controller controller = new Controller();
        System.out.println(controller.oompaLoompaSong.sing());
        
        System.out.print( "\n\n\n" );
        
        //2 - List all prize tickets
        controller.listAllPrizeTickets();
        
        System.out.print( "\n\n\n" );
        
        //7 - Ruffle tickets
        controller.ruffleTickets();
        
        System.out.print( "\n\n\n" );
        
        //3 - List only raffled tickets
        controller.listOnlyRaffledTickets();
        
        System.out.print( "\n\n\n" );
        
        //8 - Register sale
        //Registering 3 sales
		System.out.println("Regitering 3 sales.");
        for (int i = 0; i < 3; i++) {
            controller.registerSale();
        }
        
        System.out.print( "\n\n\n" );
        
        //9 - List winners
        controller.listWinners();
    }
}
