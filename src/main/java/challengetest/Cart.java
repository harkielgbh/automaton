package challengetest;

import java.text.NumberFormat;
import java.util.HashMap;

/***
 * @author harki
 * Purpose: keep track of the cart's state
 */
public class Cart {
	// amount of items in cart
	static int items_in_cart = 0;
	// total price of items in cart // tax not included
	static Double total = 0.0; 
	
	// A map of items in cart: Key = item name, Value = CartItem
	// CartItem -> Key = color + size, Value = amount in cart
	static HashMap<String, CartItem> itemshistory = new HashMap<String, CartItem>();
	
	/***
	 * Purpose: increment total price limiting to 2 decimal places
	 * Used when adding a new item to cart to update price
	 */
	static public void addTotal(Double add) {
		// create a 2 decimal precision formatter
		NumberFormat nf= NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        // add to total
        total += add;
        // apply precision formatter
		total = Double.parseDouble(nf.format(total));
	}
}

/***
 * Purpose: To store each size + color combination added to cart
 * CartItem.colorsize --> HashMap: Key = color + size, Value = amount in cart
 */
class CartItem {
	HashMap<String, Integer> colorsize = new HashMap<String, Integer>();
}
