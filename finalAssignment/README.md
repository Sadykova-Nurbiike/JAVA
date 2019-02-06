Final Assignment - First phase 

Willy Wonka

Willy Wonka got to the 21st century and decided to run again his factory, once again he will run an invitation for five lucky kids to join him.

You are requested to build up the system which will manage the kids registration, products manufacturing and of Course, the Oompa Loompas.

The software shall implement the following items:

1 - Register Prize tickets

2 - List all prize tickets

3 - List only raffled tickets

4 - Create a new Oompa Loompa song

5 - Register Beings

6 - Register Products

7 - Ruffle tickets

8 - Register sale

9 - List winners

The class GoldenTicket should have the following methods:

// public class GoldenTicket

//Constructors:

new GoldenTicket();

new GoldenTicket(String code, Date raffled)

// Getters and Setters

// If the current ticket has been already raffled

boolean isRaffled()

The class OompaLoompaSong should be initialized with an ArrayList of each line of an OompaLoompa song (example available in OompaLoompaSong.txt) and should implement the following methods:

// public class OompaLoompaSong

//Constructors:

// define how many lines  the song shall have

new OompaLoompaSong(int lines);        


// Return a String with the song

String sing()

The song should Return the lines randomly selected.

You are free to create other methods that are not listed above and may help your development. ( cof cof toString cof cof equals )

Beings registration

All beings that enter the factory must be registered, but, nobody should be registered as a generic being but as one of the following:

Kid (code, birthday, name, list of purchased products, place of birth)

OompaLoompa (code, name, height, favorite food (can be a String))

You are responsible for the typing of the attributes. All beings have a unique code from which they are referenced (when shopping for instance).

Product registration

All the products should be registered with the attributes:

description (String)

barcode (long)

serialNumber (String)

prizeTicket (GoldenTicket)

If the Prize Ticket has a GoldenTicket it means that the product has a prize, otherwise it should be null

These should be registered in a list (or file).

Register sale

This item shall ask for the user code and the product barcode (you can make it as simple as 123), then it randomly take one product from that barcode and adds it to the kids products list and removes it from the general list of products.

Ruffle tickets

Given a number of tickets to be ruffled, it creates the GoldenTickets (giving a random code and the current date) and ruffles it on the list of products.

The system asks how many GoldenTickets should be created and then ruffles the Golden Tickets into the list of products.

List winners

This goes through all the registered kids and check if they have bought any product with GoldenTicket in it, if that's the case, it prints out the name of the kid

Libraries

The following but not restricted to:

Use Java.text.SimpleDateFormat for the dates formatting and parsing (if necessary)

Use some library for creating the random Oompa Loompa song

Recommendations:

if for instance the number of tickets is bigger than the number of products, it is okay to simply add the tickets to the products and inform the user, you don't need to ask the user to inform another number (unless you want);

You can create a class on a separated file to populate the Arrays (it will be less messy for your Main).
