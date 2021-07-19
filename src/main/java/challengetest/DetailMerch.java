package challengetest;

import helper.H;

public class DetailMerch {
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
	
	static public Item readDetails(int id) { // read details from item details
		Item item = new Item();
		HomeMerch.goHome();
		HomeMerch.clickItem(id);
		
		item.name = H.getTextCss(name);
		item.model = H.getTextCss(model);
		item.condition = H.getTextCss(condition);
		item.description = H.getTextCss(description);
		item.price = H.getTextCss(price);
		
		if (H.isPresentCss(discount)) {
			item.discount =  H.getTextCss(discount);
			item.old_price = H.getTextCss(old_price);
		}
		
		H.getTextCss(datasheet);
		String tmp[] = new String[2];
		for(int i = 1; H.isPresentCss(datachild1 + i + datachild2 + 1 +")"); ++ i) {
			tmp[0] = H.getTextCss(datachild1 + i + datachild2 + 1 +")");
			tmp[1] = H.getTextCss(datachild1 + i + datachild2 + 2 +")");
			item.datasheet.add(tmp);
		}
		HomeMerch.goHome();
		return item;
	}
	
	static public void addToCart(int ammount) {
		H.waitCss(add_to_cart);
		H.clearCss(quantity);
		H.sendKeysbyCSS(quantity, ammount + "");
		H.clickCss(add_to_cart);
	}
	
	
}