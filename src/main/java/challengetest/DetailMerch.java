package challengetest;

import helper.Helper;

/***
 * Purpose: this class represents the product detail page
 * @author harki
 *
 */
public class DetailMerch {
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
	static String name = "#center_column > div > div > div.pb-center-column.col-xs-12.col-sm-4 > h1";
	static String model = "#product_reference";
	static String condition = "#product_condition";
	static String description = "#short_description_content > p";
	static String price = "#our_price_display";
	static String discount = "#reduction_percent_display";
	static String old_price = "#old_price_display";
	static String add_to_cart = "#add_to_cart > button";
	
	static String quantity = "#quantity_wanted";
	static String quantity_down = "#quantity_wanted_p > a.btn.btn-default.button-minus.product_quantity_down";
	static String quantity_up = "#quantity_wanted_p > a.btn.btn-default.button-plus.product_quantity_up";
	
	static String color =  "#color_to_pick_list > li:nth-child("; //1)
	static String image = "#bigpic";
	
	static String datasheet = "#center_column > div > section:nth-child(2) > h3";
	static String datachild1 = "#center_column > div > section:nth-child(2) > table > tbody > tr:nth-child(";
	static String datachild2 = ") > td:nth-child("; //) > a";
	
	/***
	 * Purpose: read all fields from a product and store them
	 * @param id is the index of the item you want to select from home screen
	 * @return Item, this contains all fields from the selected item id
	 */
	static public Item readDetails(int id) {
		// create item class
		Item item = new Item();
		// go to home screen
		HomeMerch.goHome();
		// click on product appearing at location {{id}} to open details page
		HomeMerch.clickItem(id);
		
		// read product properties into Item object
		item.name = Helper.getTextCss(name);
		item.model = Helper.getTextCss(model);
		item.condition = Helper.getTextCss(condition);
		item.description = Helper.getTextCss(description);
		item.price = Helper.getTextCss(price);
		
		// if there is a discount
		if (Helper.isPresentCss(discount)) {
			// read discount and old price
			item.discount =  Helper.getTextCss(discount);
			item.old_price = Helper.getTextCss(old_price);
			// TODO: make sure discount value is applied correclty
		}
		
		// read data-sheet label
		Helper.getTextCss(datasheet);
		
		// temporary array for passing data-sheet values to Item object
		String tmp[] = new String[2];
		// iterate data-sheet rows: while there is a next row -> loop
		for(int i = 1; Helper.isPresentCss(datachild1 + i + datachild2 + 1 +")"); ++ i) {
			//read column 1
			tmp[0] = Helper.getTextCss(datachild1 + i + datachild2 + 1 +")");
			// read column 2
			tmp[1] = Helper.getTextCss(datachild1 + i + datachild2 + 2 +")");
			// add columns to Item object, these are stored as a list of arrays
			item.datasheet.add(tmp);
		}
		// go to home page
		HomeMerch.goHome();
		return item;
	}
	
	/***
	 * Purpose: add x items to cart from the product detail screen
	 * @param ammount is how many items of this type you want to add to cart
	 */
	static public void addToCart(int amount) {
		Helper.waitCss(add_to_cart);
		// clear quantity field
		Helper.clearCss(quantity);
		// enter amount
		Helper.sendKeysbyCSS(quantity, amount + "");
		Helper.clickCss(add_to_cart);
	}
	
	
}