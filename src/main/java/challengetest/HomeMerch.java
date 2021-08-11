package challengetest;

import java.text.NumberFormat;

import helper.Helper;
import helper.SharedResouces;

/***
 * Purpose: this class represents the cover home page, including quick view modal
 * @author harki
 *
 */
public class HomeMerch {
	public static String popular_item = "#homefeatured > li:nth-child("; //2);
	
	static String item_home = "#homefeatured > li:nth-child("; //1
	static String item_name2 = ") > div > div.right-block > h5 > a.product-name";
	
	static String item_price2 = ") > div > div.right-block > div.content_price > span.product-price";
	static String item_price_hover = ") > div > div.left-block > div > div.content_price > span.price.product-price";

	static String item_old_price2		= ") > div > div.right-block > div.content_price > span.old-price";
	static String item_old_price_hover 	= ") > div > div.left-block > div > div.content_price > span.old-price";

	static String item_discount2 = ") > div > div.right-block > div.content_price > span.price-percent-reduction";
	static String item_discount_hover = ") > div > div.left-block > div > div.content_price > span.price-percent-reduction";
	
	
	static String best_sellers = "#home-page-tabs > li:nth-child(2) > a";
	
	static String quick_view1 = "#homefeatured > li:nth-child(";
	static String quick_view2 = ") > div > div.left-block > div > a.quick-view";
	
	static String item_box1 = "#homefeatured > li:nth-child(";
	static String item_box2 = ") > div > div.left-block > div > a.product_img_link";
	
	static String logo = "#header_logo > a";
	//===========================================================================
	
	/***
	 * Hover over a product in home screen
	 */
	public static void hoverMerch(int i) {
		Helper.waitCss(popular_item + i + ")");
		Helper.hoverCss(popular_item + i + ")");
		Helper.sleep(1);
	}

	/***
	 * hover over each item, and make sure hover and un-hovered is same item
	 */
	public static void hoverAllMerch() {
		goHome();
		Helper.waitCss(item_home + 1 + item_name2);
		Helper.sleep(3);
		// for each item validate on hover and normal show same info
		for(int i = 1; Helper.isPresentCss(item_home + i + item_name2); ++ i) {
			validateItemHoverInfo(i);
		}

	}
	/***
	 * click product from home page at idex id
	 */
	public static void clickItem(int id) {
		Helper.waitCss(item_box1 + id + item_box2);
		Helper.clickCss(item_box1 + id + item_box2);
	}
	//===================================================================================
	
	public static String view_name = "#product > div > div > div.pb-center-column.col-xs-12.col-sm-4 > h1";
	public static String view_model = "#product_reference";
	public static String view_condition = "#product_condition";
	public static String view_description = "#short_description_content > p";
	public static String view_price = "#our_price_display";
	public static String view_addtocart = "#add_to_cart > button";
	public static String view_wishlist = "#buy_block > div > div.box-cart-bottom > p > a";
	public static String view_wishlist_added = "#product > div.fancybox-overlay.fancybox-overlay-fixed > div > div > div > div > p";
	public static String view_wishlist_added_close = "#product > div.fancybox-overlay.fancybox-overlay-fixed > div > div > a";
	
	public static String view_quantity = "#quantity_wanted";
	public static String view_minus = "#quantity_wanted_p > a.btn.btn-default.button-minus.product_quantity_down";
	public static String view_plus = "#quantity_wanted_p > a.btn.btn-default.button-plus.product_quantity_up";
	public static String view_color = "#color_to_pick_list > li:nth-child("; //)";
	public static String view_size = "#group_1";
	public static String view_size_options = "#group_1 > option:nth-child("; //)
	public static String view_close = "#index > div.fancybox-overlay.fancybox-overlay-fixed > div > div > a";
	

	/***
	 * CLick logo to go to home page
	 */
	public static void goHome() {
		SharedResouces.driver.get("http://automationpractice.com/index.php");
	}
	/***
	 * validate each product shows the same information normal and on hover
	 */
	public static Item validateItemHoverInfo(int id) {
		// create objects, one for normal product and one for on hover
		Item item = new Item();
		Item item_hover = new Item();
		
		// read product name
		item.name = Helper.getTextCss(item_home + id + item_name2);
		item.price = Helper.getTextCss(item_home + id + item_price2);
		// check if discounted and save information
		if(Helper.isPresentCss(item_home + id + item_discount2)) {
			item.old_price = Helper.getTextCss(item_home + id + item_old_price2);
			item.discount = Helper.getTextCss(item_home + id + item_discount2);
			item.discounted = true;
		}
		//-------------------------------------
		// hover item
		Helper.scrollCss(popular_item + id + ")");
		Helper.sleep(1);
		Helper.hoverCss(popular_item + id + ")");
		Helper.sleep(2);
		// get hovered item name & price
		item_hover.name = Helper.getTextCss(item_home + id + item_name2);
		item_hover.price = Helper.getTextCss(item_home + id + item_price_hover);
		// get discount & price & old-price for hovered
		if(Helper.isPresentCss(item_home + id + item_discount_hover)) {
			item_hover.old_price = Helper.getTextCss(item_home + id + item_old_price_hover);
			item_hover.discount = Helper.getTextCss(item_home + id + item_discount_hover);
			item_hover.discounted = true;
		}
		//---------------------------------------
		// compare hover & normal objects
		if(item.compare(item_hover)) {
			Helper.info("Hover informations is correct");
		} else {
			Helper.asserts("Hover informations is not equal to unhovered");
		}
		return item;
		
		//============================================================================================
	}

	
	static String modal_name = "#layer_cart_product_title";
	static String modal_color_size = "#layer_cart_product_attributes";
	static String modal_quantity = "#layer_cart_product_quantity";
	static String modal_total = "#layer_cart_product_price";
	static String modal_itemsincart = "#layer_cart > div.clearfix > div > h2 > span > span.ajax_cart_quantity";
	static String modal_totalproducts = "#layer_cart > div.clearfix > div > div:nth-child(2) > span";
	static String modal_totalshipping = "#layer_cart > div.clearfix > div > div:nth-child(3) > span";
	static String modal_totalprice = "#layer_cart > div.clearfix > div > div:nth-child(4) > span";
	static String modal_continue = "#layer_cart > div.clearfix > div.layer_cart_cart > div.button-container > span";
	static String modal_checkout = "#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a > span";
	
	/***
	 * Adds a product to cart
	 * @param id: index of product in table
	 * @param size: an available size
	 * @param color: an available color
	 * @param quantity: amount
	 * @param go_to_checkout: bool to decide if go home or go to checkout
	 */
	public static void viewAddToCart(int id, String size, String color, int quantity, boolean go_to_checkout) { // add products to cart
		// item to save product details
		Item item = new Item();
		Helper.waitCss(popular_item + id + ")");
		Helper.scrollCss(popular_item + id + ")");
		Helper.sleep(1);
		// hover
		Helper.hoverCss(popular_item + id + ")");
		Helper.sleep(2);
		//===============
		Helper.location("QuickView");
		// click quick view to see modal with product details
		Helper.clickCss(quick_view1 + id + quick_view2);
		Helper.sleep(3);
		// manage iframes
		Helper.pl("There are iframes: " + Helper.iframeCount());
		Helper.switchIframe(1);
		Helper.waitCss(view_name);
		// read price
		item.price = Helper.getTextCss(view_price);
		//size dropdown
		Helper.clickCss(view_size);
		boolean found = false;
		// for each size option
		for(int i = 1; Helper.isPresentCss(view_size_options + i + ")") ; ++ i) {
			Helper.pl(Helper.getTextCss(view_size_options + i + ")") + " --- " + size);
			// if desired size is found
			if(size.equals(Helper.getTextCss(view_size_options + i + ")"))) {
				found = true;
				// click desired size
				Helper.clickCss(view_size_options + i + ")");
				Helper.clickCss(view_size);
				break;
			}
		}
		// make sure size was found
		Helper.asserts(found, "Size " + size + " was not found");
		Helper.pl("===========================================");
		Helper.sleep(5);
		
		found = false;
		// for each color option in drop down
		for(int i = 1; Helper.isPresentCss(view_color + i + ")") ; ++ i) {
			// if desired color is found
			if(color.equals(Helper.getAttributeCss(view_color + i + ") > a", "name"))) {
				found = true;
				// click color
				Helper.clickCss(view_color + i + ")");
				break;
			}
		}
		// make sure desired color was found
		Helper.asserts(found, "Color" + color + "was not found");
		
		// clear, then enter a quantity
		Helper.clearCss(view_quantity);
		Helper.sendKeysbyCSS(view_quantity, quantity + "");
		// click add to cart
		Helper.clickCss(view_addtocart);
		//==============================================
		Helper.switchIframeDefault();
		Helper.sleep(2);
		Helper.waitCss(modal_name);
		// read name
		item.name = Helper.getTextCss(modal_name);
		// make sure product color/size is the color/size selected by user
		String[] parts = Helper.getTextCss(modal_color_size).split(", ");
		Helper.asserts(parts[0], color);
		Helper.asserts(parts[1], size);
		

		
		int other_quantity = 0; // this can be made simpler TODO: improve
		//boolean in_cart = false; // is the same item already in cart and we are just buying more of the same? TODO: add this functionality
		// if this product is already in cart
		if(Cart.itemshistory.containsKey(item.name)) {
			//if the same color and size is already on cart
			if ( Cart.itemshistory.get(item.name).colorsize.get(color + size) != null ) {
				//in_cart = true; TODO: add this functionality
				//get the amount of color + size of this product already in cart
				other_quantity = Cart.itemshistory.get(item.name).colorsize.get(color + size);
			}
		}
		// make sure the quantity fields accounts for other products already in cart
		Helper.asserts(Helper.getTextCss(modal_quantity), (quantity + other_quantity ) + "");
		// add current purchase to item object
		item.addSizeColorQuantity(size, color, Helper.getTextCss(modal_quantity));
		NumberFormat nf= NumberFormat.getInstance(); // format
        nf.setMaximumFractionDigits(2); // set precision 2 decimal places (avoid binary to base 10 remainders)
        // make sure total takes into account items previously added to cart
		Helper.pl("assert "  + Double.parseDouble(Helper.getTextCss(modal_total).substring(1)) + " == " + (quantity + other_quantity ) * Double.parseDouble(item.price.substring(1)));
		Helper.asserts(Double.parseDouble(Helper.getTextCss(modal_total).substring(1)) == Double.parseDouble(nf.format((quantity + other_quantity ) * Double.parseDouble(item.price.substring(1)))));
		// make sure amount of products in cart is correct
		Helper.asserts(Cart.items_in_cart + quantity == Integer.parseInt(Helper.getTextCss(modal_itemsincart)));
		// add current product
		Cart.items_in_cart += quantity;
		
		
		String tmp = Helper.getTextCss(modal_totalproducts).substring(1).replace(",", "");
		// add current price to total price
		Cart.addTotal( (quantity ) * Double.parseDouble(item.price.substring(1)));
		Helper.info("cart total is " + Cart.total);
		// make sure prices match expected values
		Helper.asserts( Cart.total + "", tmp);
		
		// new cart item
		CartItem cartitem = new CartItem();
		// add current product to cart item
		cartitem.colorsize.put(color + size, quantity + other_quantity);
		// add current product to cart
		Cart.itemshistory.put(item.name, cartitem);
		
		// click go to checkout or click continue based on > go_to_checkout
		if (go_to_checkout) {
			Helper.info("Checkout");
			Helper.clickCss(modal_checkout);
		} else {
			Helper.info("continue");
			Helper.clickCss(modal_continue);
		}
	}
	//=================================================================
	/***
	 *  need to be inside iframe to invoke this method
	 *  Click add to favorites button, then validate correct action based on login status.
	 *  @param loggedin: the behavior is different depending on login status
	 */
	public static void addToFavorites(boolean loggedin) { 
		Helper.waitCss(view_wishlist);
		Helper.clickCss(view_wishlist);
		Helper.waitCss(view_wishlist_added);
		if (loggedin) {
			Helper.asserts(Helper.getTextCss(view_wishlist_added), "You must be logged in to manage your wishlist.");
		} else {
			Helper.asserts(Helper.getTextCss(view_wishlist_added), "Added to your wishlist.");
		}
		Helper.waitCss(view_wishlist_added_close, 10);
		Helper.clickCss(view_wishlist_added_close);
	}
	
	/***
	 * @param id: Index of product in home
	 * @param setfavorite: click favorite button?
	 * @return: Item
	 * Purpose: opens quick view for item and clicks set favorite
	 */
	public static Item readQuickView(int id, boolean setfavorite) {
		goHome();
		Helper.waitCss(LoginOut.login_btn);
		boolean loggedin = Helper.isPresentCss(LoginOut.login_btn);
		
		// hover
		Helper.waitCss(popular_item + id + ")");
		Helper.scrollCss(popular_item + id + ")");
		Helper.sleep(1);
		Helper.hoverCss(popular_item + id + ")");
		Helper.sleep(2);
		
		//click quickview
		Helper.location("QuickView");
		Helper.clickCss(quick_view1 + id + quick_view2);
		Helper.sleep(3);
		Helper.pl("There are iframes: " + Helper.iframeCount());
		
		Helper.switchIframe(1);
		Helper.waitCss(view_name);
		Item item = new Item();
		
		// read fields
		item.name = Helper.getTextCss(view_name);
		item.model = Helper.getTextCss(view_model);
		item.condition = Helper.getTextCss(view_condition);
		item.description = Helper.getTextCss(view_description);
		item.price = Helper.getTextCss(view_price);
		
		// get all sizes for this product
		Helper.clickCss(view_size);
		String tmp;
		for(int i = 1; Helper.isPresentCss(view_size_options + i + ")") ; ++ i) {
			tmp = Helper.getTextCss(view_size_options + i + ")");
			item.sizes.add(tmp);
		}
		Helper.clickCss(view_size);
		
		// get all colors for this item
		for(int i = 1; Helper.isPresentCss(view_color + i + ")") ; ++ i) {
			tmp = Helper.getAttributeCss(view_color + i + ") > a", "name");
			item.colors.add(tmp);
		}
		
		// set favorite
		if (setfavorite) {
			addToFavorites(loggedin);
		}
		
		//TODO: add function to add to cart
		Helper.switchIframeDefault();
		Helper.clickCss(view_close);
		goHome();
		return item;
	}
	//====================================
	
}







