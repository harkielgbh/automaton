package challengetest;

import java.text.NumberFormat;
import java.util.HashMap;

public class Cart {
	static int items_in_cart = 0;
	static Double total = 0.0;
	static HashMap<String, CartItem> itemshistory = new HashMap<String, CartItem>();
	
	static public void addTotal(Double add) {
		NumberFormat nf= NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        total += add;
		total = Double.parseDouble(nf.format(total));
	}
	
}
class CartItem {
	HashMap<String, Integer> colorsize = new HashMap<String, Integer>();
}
