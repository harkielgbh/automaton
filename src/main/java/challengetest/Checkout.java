package challengetest;

import helper.Helper;

/***
 * @author harki
 * Purpose: this class represents the checkout screen
 */
public class Checkout {
	/* Variables:
	 * If page contains iterable items, then you might see compound variables
	 * for example, if there is a table on screen, with many entries
	 * 		to reference the name of item 3 on the table we use the following system:
	 * 			the selector is split at index 3 in this case, and each part is stored in a variable
	 * 			itemname1 and itemname2 for example.
	 * 			Then, to click this item we invoke Click(itemname1 + index + itemname2);
	 * 			where index is the location is the entry in the table
	 * 
	 * 			(exception) some variables might not have a part 2, in this case
	 * 			simply add a closing parenthesis to "the nth-child" and ignore part 2
	 * 			example Click(itemname1 + index + ")");
	 * 			In this cases there is usually a comment to the right of the variable to identify it.
	 * 			example: String itemname1 = "selector:nth-child("; //) > div
	 * 			then the the comment is appended like so: Click(itemname1 + index + ") > div");
	 */
	public static String name1 = "#cart_summary > tbody > tr:nth-child(";
	public static String name2 = ") > td:nth-child(2) > p";
	public static String color_size1 = "#cart_summary > tbody > tr:nth-child(";
	public static String color_size2 = ") > td:nth-child(2) > small > a";
	public static String price1 = "#cart_summary > tbody > tr:nth-child(";
	public static String price2 = ") > td:nth-child(4) > span";
	public static String quantity1 = "#cart_summary > tbody > tr:nth-child(";
	public static String quantity2 = ") > td:nth-child(5) > input:nth-child(1)";
	public static String total1 = "#cart_summary > tbody > tr:nth-child(";
	public static String total2 = ") > td:nth-child(6) > span";
	public static String remove1 = "#cart_summary > tbody > tr:nth-child(";
	public static String remove2= ") > td:nth-child(7) > div > a";
	public static String total_products = "#total_product";
	
	/***
	 * Make sure cart has the right ammount of products and prices are calculated ok
	 */
	public static void compareCart () {
		//log location
		Helper.location("Shopping cart");
		// for each product in checkout screen
		for(int i = 1; Helper.isPresentCss(name1 + i + name2); ++ i) {
			// just printing for now TODO: compare to stored products
			Helper.pl(Helper.getTextCss(name1 + i + name2));
			Helper.pl(Helper.getTextCss(color_size1 + i + color_size2));
			Helper.pl(Helper.getTextCss(price1 + i + price2));
			Helper.pl(Helper.getTextCss(quantity1 + i + quantity2));
			Helper.pl(Helper.getTextCss(total1 + i + total2));
			Helper.pl("================================");
		}
		
		// print cart total
		Helper.pl("assert " + Cart.total + " == " + Double.parseDouble(Helper.getTextCss(total_products).substring(1)));
		// assert cart total is correct
		Helper.asserts(Cart.total == Double.parseDouble(Helper.getTextCss(total_products).substring(1)));
	}
}
