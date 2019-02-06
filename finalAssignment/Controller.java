import models.*;

import java.text.ParseException;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Controller {

    //Attributes
    BeingsRegistration beingsRegistration;
    ProductRegistration productRegistration;
    PrizeTickets prizeTicketsRegistration;

    OompaLoompaSong oompaLoompaSong;

    //Helper attributes
    Scanner scanner;
    private static SimpleDateFormat my_format;
    private static Random random;

    //Constructor
    public Controller() throws Exception {
        //Helper 
        scanner = new Scanner(System.in);
        my_format = new SimpleDateFormat("yyyyMMdd");
        random = new Random();

        System.out.println("Willy Wonka's factory start running again!");

        //Registration
        productRegistration = new ProductRegistration();
        startProductRegistration();
        prizeTicketsRegistration = new PrizeTickets();
        startPrizeTicketsRegistration();
        beingsRegistration = new BeingsRegistration();
        startBeingsRegistration();

        //4 - Create a new Oompa Loompa song
        System.out.println();
        int number = -1;
        System.out.println("Inform how many lines  the OompaLoompa Song shall have: ");
        do {
            System.out.print("Please enter a positive integer number: ");
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
            } else {
                System.out.println("I need an int, please try again.");
                scanner.nextLine();
            }
        } while (number <= 0);

        oompaLoompaSong = new OompaLoompaSong(number);

    }

    //Getters:
    public OompaLoompaSong getOompaLoompaSong() {
        return this.oompaLoompaSong;
    }

    //1 - Register Prize tickets
    private void startPrizeTicketsRegistration() {
        for (int i = 0; i < 7; i++) {
            prizeTicketsRegistration.addPrizeTicket(new GoldenTicket(generateRandomString(), null));
        }
    }

    //2 - List all prize tickets
    public void listAllPrizeTickets() {
        System.out.println("All prize tickets are : ");
        for (GoldenTicket ticket : prizeTicketsRegistration.getPrizeTicketsList()) {
            System.out.println(ticket);
        }
    }

    //3 - List only raffled tickets
    public void listOnlyRaffledTickets() {
        System.out.println("All raffled prize tickets are : ");
        for (GoldenTicket ticket : prizeTicketsRegistration.getRaffledTicketsList()) {
            System.out.println(ticket);
        }
    }

    //5 - Register Beings
    private void startBeingsRegistration() throws Exception {
        //Kids
        Date date = my_format.parse("20001231");
        beingsRegistration.addKid(new Kid("k100", date, "Mary", new ArrayList<Product>(), "London"));

        Date date1 = my_format.parse("20020412");
        beingsRegistration.addKid(new Kid("k120", date1, "John", new ArrayList<Product>(), "California"));

        Date date2 = my_format.parse("20051111");
        beingsRegistration.addKid(new Kid("k400", date2, "Katya", new ArrayList<Product>(), "Moskow"));

        Date date3 = my_format.parse("20021209");
        beingsRegistration.addKid(new Kid("k560", date3, "Ali", new ArrayList<Product>(), "Istanbul"));

        Date date4 = my_format.parse("20070515");
        beingsRegistration.addKid(new Kid("k680", date4, "Bora", new ArrayList<Product>(), "Seul"));

        Date date5 = my_format.parse("20000304");
        beingsRegistration.addKid(new Kid("k101", date5, "Nurbiike", new ArrayList<Product>(), "Bishkek"));

        //Oompaloompas
        beingsRegistration.addOompaLoompa(new OompaLoompa("oo105", "Coco", 95.0, "lollypop"));
        beingsRegistration.addOompaLoompa(new OompaLoompa("oo133", "Momo", 93.7, "marmalade"));
        beingsRegistration.addOompaLoompa(new OompaLoompa("oo107", "Kiki", 95.1, "ice cream"));
    }

    //dealing with KID 
    public void addKid() {
        System.out.println("Inform the kid's code: ");
        String code = scanner.next();

        boolean isValidBD = true;
        Date birthDate = null;
        do {

            try {
                System.out.println("Inform the kid's birthday(yyyyMMDD): ");
                String birthday = scanner.next();
                birthDate = my_format.parse(birthday);

            } catch (ParseException ex) {
                isValidBD = false;
            }

        } while (!isValidBD);

        System.out.println("Inform the kid's name: ");
        String name = scanner.next();

        //purchasedProducts of kid
        System.out.println("How many products did kid purchase? : ");

        int n = -1;
        do {
            System.out.print("Please enter a nonnegative integer number: ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
            } else {
                scanner.nextLine();
            }
        } while (n < 0);

        ArrayList<Product> purchasedProducts = new ArrayList<Product>();
        for (int i = 0; i < n; i++) {
            System.out.println("Product " + i + " :");

            System.out.println("description: ");
            String description = scanner.next();

            System.out.println("barcode: ");
            int barcodeN = -1;
            boolean isNotNum = true;
            do {
                System.out.print("Please enter a long number: ");
                if (scanner.hasNextInt()) {
                    barcodeN = scanner.nextInt();
                    isNotNum = false;
                } else {
                    scanner.nextLine();
                }
            } while (isNotNum);
            long barcode = barcodeN;

            System.out.println("serial number: ");
            String serialNumber = scanner.next();

            System.out.println("Does kid's product " + i + " have GoldenTicket(Please type Y - for yes, N - for no) : ");
            String yes = scanner.next();
            GoldenTicket goldenTicket = new GoldenTicket();
            if (yes.equalsIgnoreCase("Y")) {
                System.out.println("code of GoldenTicket: ");
                String codeG = scanner.next();
                isValidBD = true;
                String raffledS = null;
                Date raffled = null;
                do {

                    try {

                        System.out.println("raffled date of GoldenTicket (yyyyMMdd): ");
                        raffledS = scanner.next();
                        raffled = my_format.parse(raffledS);

                    } catch (ParseException ex) {
                        isValidBD = false;
                    }

                } while (!isValidBD);

                goldenTicket = new GoldenTicket(codeG, raffled);
            } else if (yes.equalsIgnoreCase("N")) {
                goldenTicket = null;
            }

            Product product = new Product(description, barcode, serialNumber, goldenTicket);
            purchasedProducts.add(product);

        }

        //Place of birth
        System.out.println("Inform the kid's place of birth: ");
        String placeOfBirth = scanner.next();

        //Adding kid to kidsList
        beingsRegistration.addKid(new Kid(code, birthDate, name, purchasedProducts, placeOfBirth));

    }

    public void removeKid() {
        System.out.println("Inform kid's code");
        String code = scanner.next();

        if (beingsRegistration.removeKid(code)) {
            System.out.println("Kid removed");
        } else {
            System.out.println("Kid not found");
        }

    }

    //dealing with OOMPALOOMPA
    public void addOompaLoompa() throws Exception {
        System.out.println("Inform the oompaLoompa's code: ");
        String code = scanner.next();

        System.out.println("Inform the oompaLoompa's name: ");
        String name = scanner.next();

        double number = -1.0;
        System.out.println("Inform the oompaLoompa's height: ");
        do {
            System.out.print("Please enter a positive real number: ");
            if (scanner.hasNextDouble()) {
                number = scanner.nextDouble();
            } else {
                System.out.println("I need a real number, please try again.");
                scanner.nextLine();
            }
        } while (number <= 0.0);

        double height = number;

        System.out.println("Inform the oompaLoompa's favorite food: ");
        String favoriteFood = scanner.next();

        //Adding oompaloompa to oompaloompasList
        beingsRegistration.addOompaLoompa(new OompaLoompa(code, name, height, favoriteFood));

    }

    public void removeOompaLoompa() {
        System.out.println("Inform oompaLoompa's code");
        String code = scanner.next();

        if (beingsRegistration.removeOompaLoompa(code)) {
            System.out.println("OompaLoompa removed");
        } else {
            System.out.println("OompaLoompa not found");
        }

    }

    //6 - Register Products
    private void startProductRegistration() {
        productRegistration.addProduct(new Product("highly enjoyable marmalade", 12345, "22222", null));
        productRegistration.addProduct(new Product("highly enjoyable marmalade", 12345, "22212", null));
        productRegistration.addProduct(new Product("highly enjoyable marmalade", 12345, "21222", null));
        productRegistration.addProduct(new Product("easy-to-love lollypop", 11111, "22112", null));
        productRegistration.addProduct(new Product("honeyed magical chocolate", 54321, "23674", null));
        productRegistration.addProduct(new Product("honeyed magical chocolate", 54321, "21111", null));
        productRegistration.addProduct(new Product("Flat cake, splat cake, not a fat cake – that’s a Pancake!", 14445, "33333", null));
        productRegistration.addProduct(new Product("Flat cake, splat cake, not a fat cake – that’s a Pancake!", 14445, "88888", null));
        productRegistration.addProduct(new Product("Flat cake, splat cake, not a fat cake – that’s a Pancake!", 14445, "77777", null));
        productRegistration.addProduct(new Product(" light-as-air vanilla macarons", 12321, "77722", null));
        productRegistration.addProduct(new Product(" light-as-air vanilla macarons", 12321, "22777", null));
    }

    //Dealing with PRODUCT
    public void addProduct() throws Exception {

        System.out.println("Inform the product's description: ");
        String description = scanner.next();

        System.out.println("Inform the product's barcode: ");
        int barcodeN = -1;
        boolean isNotNum = true;
        do {
            System.out.print("Please enter a long number: ");
            if (scanner.hasNextInt()) {
                barcodeN = scanner.nextInt();
                isNotNum = false;
            } else {
                scanner.nextLine();
            }
        } while (isNotNum);
        long barcode = barcodeN;

        System.out.println("Inform the product's serial number: ");
        String serialNumber = scanner.next();

        //Adding product to productList
        productRegistration.addProduct(new Product(description, barcode, serialNumber, null));

    }

    //7 - Ruffle tickets
    public void ruffleTickets() {
        System.out.println("Ruffle tickets start! ");

        int n = -1; //n - number of tickets to be ruffled
        System.out.println("How many GoldenTickets should be created: ");
        do {
            System.out.print("Please enter a nonnegative integer number: ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
            } else {
                System.out.println("I need an int, please try again.");
                scanner.nextLine();
            }
        } while (n < 0);

        ArrayList<Product> productsList = productRegistration.getProductsList();
        ArrayList<GoldenTicket> prizeTicketsList = prizeTicketsRegistration.getPrizeTicketsList();

        int smallest = Math.min(n, Math.min(prizeTicketsList.size(), productsList.size()));

        if (smallest < n) {
            System.out.println("Since the number of tickets is bigger than the number of products/prize tickets, \n factory will create less tickets than the amount you want.");
        }
        for (int i = 0; i < smallest; i++) {

            Date date = new Date();
            GoldenTicket goldenTicket = prizeTicketsRegistration.getRandomPrizeTicketToRaffle();
            goldenTicket.setRaffledDate(date); //today's day

            //ruffles it on the list of products
            productRegistration.getRandomProductToRaffle().setPrizeTicket(goldenTicket);

        }

    }

    //8 - Register sale
    public void registerSale() {

        System.out.println();
        System.out.println("Registering sale : ");
        // ask for the user code and the product barcode

        System.out.println("Kids' names: kids'(customer) code : ");
        beingsRegistration.printKidDataForRegisterSale();

        Kid kid;
        do {
            System.out.println("Inform the kid's(customer) code: ");
            String code = scanner.next();
            kid = beingsRegistration.getKidByCode(code);
        } while (kid == null);

        System.out.println("Available products: ");
        System.out.println("product's description : product's barcode ");
        productRegistration.printProductDataForRegisterSale();

        Product product = null;
        System.out.println("Inform the product's barcode: ");
        int barcodeN = -1;
        boolean isNotNum = true;
        do {
            System.out.print("Please enter a long number: ");
            if (scanner.hasNextInt()) {
                barcodeN = scanner.nextInt();
                long barcode = barcodeN;
                //then it randomly take one product from that barcode(if barcode is not valid then it will return null), and removes it from the general list of products
                product = productRegistration.getRandomProductByBarcodeForSale(barcode);
                isNotNum = false;
            } else {
                scanner.nextLine();
            }
        } while (isNotNum || product == null);

        //adds it to the kids products list
        kid.getPurchasedProducts().add(product);

    }

    //9 - List winners
    public void listWinners() {
        ArrayList<Kid> kids = beingsRegistration.getKidsList();
        System.out.println("Lucky winners : ");
        for (Kid kid : kids) {
            ArrayList<Product> products = kid.getPurchasedProducts();
            for (Product product : products) {
                if (product.hasPrize()) {
                    System.out.println(kid);
                }
            }
        }
    }

    //Other helper methods
    //STATIC METHOD
    //generates random code with length 6
    private static String generateRandomString() {
        String aToZ = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String newString = "";
        for (int i = 0; i < 6; i++) {
            newString = newString + aToZ.charAt(random.nextInt(aToZ.length()));
        }
        return newString;
    }

}
