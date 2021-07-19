package challengetest;

import helper.H;

public class Checkout {
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
	
	public static void compareCart () { // make sure cart contains the right ammount of products and price is ok
		H.location("Shopping cart");
		for(int i = 1; H.isPresentCss(name1 + i + name2); ++ i) {
			H.pl(H.getTextCss(name1 + i + name2));
			H.pl(H.getTextCss(color_size1 + i + color_size2));
			H.pl(H.getTextCss(price1 + i + price2));
			H.pl(H.getTextCss(quantity1 + i + quantity2));
			H.pl(H.getTextCss(total1 + i + total2));
			H.pl("================================");
		}
		
		H.pl("assert " + Cart.total + " == " + Double.parseDouble(H.getTextCss(total_products).substring(1)));
		H.ass(Cart.total == Double.parseDouble(H.getTextCss(total_products).substring(1)));
		//H.clickCss(remove);
	}
}
