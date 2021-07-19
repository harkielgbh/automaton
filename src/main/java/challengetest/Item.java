package challengetest;

import java.util.ArrayList;
import helper.H;

class Item {
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
	public int quantity = 0;
	public ArrayList<String[]> size_color_qty = new ArrayList<String[]>();
	public ArrayList<String[]> datasheet = new ArrayList<String[]>();
	public String more_info = "";

	public void addSizeColorQuantity(String size, String color, String quantity) {
		String []tmp = { size, color, quantity	};
		this.quantity += Integer.parseInt(quantity);
		size_color_qty.add(tmp);
	}
	
	public void addDatasheet(String label, String value) {
		String []tmp = { label, value	};
		datasheet.add(tmp);
	}
	
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
	
	public void print() {
		H.pl(name + ", " + price + ", " + old_price + ", " + discount);
	}
	
	public boolean compare(String name, String price, String old_price, String discount) {
		return (this.name.equals(name) && this.price.equals(price) && this.old_price.equals(price) && this.discount.equals(discount));
	}
	
	public boolean compare(Item item) {
		H.pl("====compare=====");
		print();
		item.print();
		return (this.name.equals(item.name) && this.price.equals(item.price) && this.old_price.equals(item.old_price) && this.discount.equals(item.discount));
	}
}

