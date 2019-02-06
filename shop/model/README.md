Description

The Coffee shop ultimate vending control.
Your task is to create a software able to manage sales of a coffee shop.

GRADE 2:
The Coffee basis:
First of all we would like to manage the basic coffee sales, for such we will have one generic class of coffee and two specializations for it.

Let's first create a class shop.model.Coffee with the attribute price, which will store the price of a certain coffee.

Create the setters and getters as well as a constructor with arguments, make the price field visible for all the other classes inside the package.

Create a static method called coffeesAmount that returns an integer, this method should belong to the class and would count how many coffees have been sold (from any kind). Feel free to create new variables to support your function.

Create a class shop.model.Espresso which extends Coffee and has one String attribute brand and one integer coffeeDeciliters, create the getters and setters for those. Also, create the constructor method with arguments.

Create a class shop.model.Capuccino which extends Coffee and has one String attribute brand, one integer coffeeDeciliters and another milkDeciliters, create the getters and setters for those. Also, create the constructor method with arguments.

Create a class shop.model.Order, this class should have a list of Coffee, one attribute called orderTime and another deliveredTime which are both Dates, representing the time of order and the time the order was delivered.

create a class shop.model.Counter, in this class, create your main method, instantiate two Espresso coffees and one Capuccino, put them inside an order.

Override the toString methods of Cofee, Espresso and Capuccino and print it on the screen like the following:

TIP: depending on how you call the toString method due to the static method it may print coffees with the same value, that's okay

coffees: 1, price: 1,50, Capuccino, 3dl coffee, 3dl milk
coffees: 2, price: 0,75, Espresso, 3dl coffee
coffees: 3, price: 0,75, Espresso, 2dl coffee
Where the "coffee: n" represents the output of coffeesAmount function.

Suggestion: use SimpleDateFormat with the parameter "HH:mm" for the order and delivery time.

GRADE 3
First, make sure that you've finished everything in the exercise for GRADE 2.

If you haven't, stop, and go back.
 

Inside Order create a boolean function called wasLate with one Date as argument, this function returns true if the time of delivery is null and the time of arrival is later than the Date received by argument.

Create a toString method in the Order that calls the toString methods from all coffees with a starting line saying "Order Output" and the other information regarding the current order.

Create and implement a method totalPrice to calculate the total price of the current Order.

In your main method now, Create a new Order with one Capuccino and set deliveredTime as 20:55 , put the order time and call the isLate function with hardcoded time of 20:51. The output should have the following information:

Order Output:
Ordered: 20:50
Delivered: 20:55 [late]
Price: 1,50
coffees: 4,  price: 1,50, Capuccino, 3dl coffee, 3dl milk

GRADE 4
There is a new system in the coffee shop to schedule the orders, your colleague is implementing the Brownies system and asked if you could create an Interface so that you could use the same method signatures and guarantee the success of the implementation of the scheduler.

So implement an Interface inside the models package called OrderNumber, this should have the signature of a method called getOrderNumber and another method called reOrder this second one takes a list of Order as parameter and doesn't return anything.

Implement the Interface in the class Order, and implement an attribute orderNumber. In the function getOrderNumber if orderNumber is null you shall return 0 (zero integer), otherwise you return orderNumber.

Implement the reOrder function, this should take the list of Orders and order them by orderTime. If they have the same time, the first shall be the more expensive. The order is defined by the orderNumber which can start from 1 or according to your convenience.

Add the tree coffees created on the first part of the exercise to an Order with orderTime as 20:49 and in your main, add the two Orders into an ArrayList orders, send this ArrayList and call the function reOrder, remember to add the OrderNumber into the toString method.

Call the two orders toString, the output should look more or less like the following:

Order Output:
Ordered: 20:50
Delivered: 20:55 [late]
Price: 1,50
Order: 1
coffees: 4, price: 1,50, Capuccino, 3dl coffee, 3dl milk
Order Output:
Ordered: 20:49
Delivered: 20:55 [late]
Price: 3
Order: 1
coffees: 4, price: 1,50, Capuccino, 3dl coffee, 3dl milk,  
coffees: 4, price: 0,75, Espresso, 3dl coffee
coffees: 4, price: 0,75, Espresso, 3dl coffee

GRADE 5
Create a function called PrintOrder, that takes an Order as argument and prints out the Order into a file called with the Order Number with the information like seen on the toString method inside the files.

After all the execution ask the user if he/she wants to print out the orders, if the answer is "Y", call the PrintOrder function for all the orders inside the ArrayList orders.
