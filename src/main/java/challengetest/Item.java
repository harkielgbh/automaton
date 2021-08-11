package challengetest;

import java.util.ArrayList;
import helper.Helper;

/***
 * Purpose: a representation of a single product and how many of its color+sizes variants are in cart
 * @author harki
 *
 */
class Item {
	/*
	 * There is a variable for each field/property the product has
	 */
	public String name;
	public String price;
	public String old_price;
	public String discount;
	public boolean discounted = false;
	
	public String model = "";
	public String condition = "";
	public String description = "";
	public String size = "";
	public ArrayList<String> sizes = new ArrayList<String>();
	public ArrayList<String> colors = new ArrayList<String>();
	public int quantity = 0; // how many of this product are in cart (all colors and sizes counted)
	// count of how many of this product are in cart, grouping by color+size
	public ArrayList<String[]> size_color_qty = new ArrayList<String[]>();
	// stores the data-sheet section of the product detail page
	public ArrayList<String[]> datasheet = new ArrayList<String[]>();
	public String more_info = "";
	
	/***
	 * Purpose: update this object when a new product is added to cart
	 */
	public void addSizeColorQuantity(String size, String color, String quantity) {
		String []tmp = { size, color, quantity	};
		this.quantity += Integer.parseInt(quantity);
		size_color_qty.add(tmp);
	}
	
	/***
	 * Purpose: help read data-sheet into this object
	 */
	public void addDatasheet(String label, String value) {
		String []tmp = { label, value	};
		datasheet.add(tmp);
	}
	
	/***
	 * Purpose: simple constructor
	 */
	public Item(String name, String price, String old_price, String discount) {
		this.name = name;
		this.price = price;
		this.old_price = old_price;
		this.discount = discount;
		this.discounted = true;
	}
	public Item() {
		this.name = "";
		this.price = "";
		this.old_price = "";
		this.discount = "";
		this.discounted = false;
	}
	
	/***
	 * Purpose: print main fields of this product
	 */
	public void print() {
		Helper.pl(name + ", " + price + ", " + old_price + ", " + discount);
	}
	
	/***
	 * Purpose: validate main fields of product
	 */
	public boolean compare(String name, String price, String old_price, String discount) {
		return (this.name.equals(name) && this.price.equals(price) && this.old_price.equals(price) && this.discount.equals(discount));
	}
	
	/***
	 * Purpose: this to another product
	 */
	public boolean compare(Item item) {
		Helper.pl("====compare=====");
		print();
		item.print();
		return (this.name.equals(item.name) && this.price.equals(item.price) && this.old_price.equals(item.old_price) && this.discount.equals(item.discount));
	}
}

