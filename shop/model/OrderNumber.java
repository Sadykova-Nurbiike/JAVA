package shop.model;

import shop.model.Order;
import java.util.ArrayList;

public interface OrderNumber{
	
	int getOrderNumber();
	void reOrder(ArrayList<Order> orders);
}