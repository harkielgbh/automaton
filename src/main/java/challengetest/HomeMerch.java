package challengetest;

import java.text.NumberFormat;

import helper.H;
import helper.S;

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
	public static void hoverMerch(int i) {
		H.waitCss(popular_item + i + ")");
		H.hoverCss(popular_item + i + ")");
		H.sleep(1);
	}

	public static void hoverAllMerch() { // hover over each item, and make sure hover and un-hovered is same item
		goHome();
		H.waitCss(item_home + 1 + item_name2);
		H.sleep(3);
		for(int i = 1; H.isPresentCss(item_home + i + item_name2); ++ i) {
			validateItemHoverInfo(i);
		}

	}
	
	public static void clickItem(int id) { // click merch item from home page
		H.waitCss(item_box1 + id + item_box2);
		H.clickCss(item_box1 + id + item_box2);
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
	

	
	public static void goHome() { // click main logo
		S.driver.get("http://automationpractice.com/index.php");
	}
	
	public static Item validateItemHoverInfo(int id) {
		Item item = new Item();
		Item item_hover = new Item();
		
		item.name = H.getTextCss(item_home + id + item_name2);
		item.price = H.getTextCss(item_home + id + item_price2);
		
		if(H.isPresentCss(item_home + id + item_discount2)) {
			item.old_price = H.getTextCss(item_home + id + item_old_price2);
			item.discount = H.getTextCss(item_home + id + item_discount2);
			item.discounted = true;
		}
		//-------------------------------------
		H.scrollCss(popular_item + id + ")");
		H.sleep(1);
		H.hoverCss(popular_item + id + ")");
		H.sleep(2);
		item_hover.name = H.getTextCss(item_home + id + item_name2);
		item_hover.price = H.getTextCss(item_home + id + item_price_hover);
		
		if(H.isPresentCss(item_home + id + item_discount_hover)) {
			item_hover.old_price = H.getTextCss(item_home + id + item_old_price_hover);
			item_hover.discount = H.getTextCss(item_home + id + item_discount_hover);
			item_hover.discounted = true;
		}
		//---------------------------------------
		if(item.compare(item_hover)) { // for logging, if is not vital
			H.info("Hover informations is correct");
		} else {
			H.ass("Hover informations is not equal to unhovered");
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
	
	public static void viewAddToCart(int id, String size, String color, int quantity, boolean go_to_checkout) { // add products to cart

        
		Item item = new Item();
		H.waitCss(popular_item + id + ")");
		H.scrollCss(popular_item + id + ")");
		H.sleep(1);
		H.hoverCss(popular_item + id + ")");
		H.sleep(2);
		//===============
		H.location("QuickView");
		H.clickCss(quick_view1 + id + quick_view2);
		H.sleep(3);
		H.pl("There are iframes: " + H.iframeCount());
		
		H.switchIframe(1);
		H.waitCss(view_name);
		item.price = H.getTextCss(view_price);
		//===================
		H.clickCss(view_size);
		
		boolean found = false;
		for(int i = 1; H.isPresentCss(view_size_options + i + ")") ; ++ i) {
			H.pl(H.getTextCss(view_size_options + i + ")") + " --- " + size);
			if(size.equals(H.getTextCss(view_size_options + i + ")"))) {
				found = true;
				H.clickCss(view_size_options + i + ")");
				H.clickCss(view_size);
				break;
			}
		}
		H.ass(found, "Size " + size + " was not found");
		H.pl("===========================================");
		H.sleep(5);
		found = false;
		for(int i = 1; H.isPresentCss(view_color + i + ")") ; ++ i) {
			if(color.equals(H.getAttributeCss(view_color + i + ") > a", "name"))) {
				found = true;
				H.clickCss(view_color + i + ")");
				break;
			}
		}
		H.ass(found, "Color" + color + "was not found");
		
		H.clearCss(view_quantity);
		H.sendKeysbyCSS(view_quantity, quantity + "");
		H.clickCss(view_addtocart);
		//==============================================
		H.switchIframeDefault();
		H.sleep(2);
		H.waitCss(modal_name);
		
		item.name = H.getTextCss(modal_name);
		
		String[] parts = H.getTextCss(modal_color_size).split(", ");
		H.ass(parts[0], color);
		H.ass(parts[1], size);
		

		
		int other_quantity = 0; // this can be made simpler
		boolean in_cart = false; // is the same item already in cart and we are just buying more of the same?
		if(Cart.itemshistory.containsKey(item.name)) {
			if ( Cart.itemshistory.get(item.name).colorsize.get(color + size) != null ) {
				in_cart = true;
				other_quantity = Cart.itemshistory.get(item.name).colorsize.get(color + size);
			}
		}
		
		
		H.ass(H.getTextCss(modal_quantity), (quantity + other_quantity ) + "");
		item.addSizeColorQuantity(size, color, H.getTextCss(modal_quantity));
		NumberFormat nf= NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
		H.pl("assert "  + Double.parseDouble(H.getTextCss(modal_total).substring(1)) + " == " + (quantity + other_quantity ) * Double.parseDouble(item.price.substring(1)));
		H.ass(Double.parseDouble(H.getTextCss(modal_total).substring(1)) == Double.parseDouble(nf.format((quantity + other_quantity ) * Double.parseDouble(item.price.substring(1)))));
		H.ass(Cart.items_in_cart + quantity == Integer.parseInt(H.getTextCss(modal_itemsincart)));
		Cart.items_in_cart += quantity;
		
		
		String tmp = H.getTextCss(modal_totalproducts).substring(1).replace(",", "");
		Cart.addTotal( (quantity ) * Double.parseDouble(item.price.substring(1)));
		H.info("cart total is " + Cart.total);
		H.ass( Cart.total + "", tmp);
		
		CartItem cartitem = new CartItem();
		cartitem.colorsize.put(color + size, quantity + other_quantity);

		Cart.itemshistory.put(item.name, cartitem);
		
		if (go_to_checkout) {
			H.info("Checkout");
			H.clickCss(modal_checkout);
		} else {
			H.info("continue");
			H.clickCss(modal_continue);
		}
	}
	//=================================================================
	
	public static void addToFavorites(boolean loggeddin) { // need to be inside iframe to invoke
		H.waitCss(view_wishlist);
		H.clickCss(view_wishlist);
		H.waitCss(view_wishlist_added);
		if (loggeddin) {
			H.ass(H.getTextCss(view_wishlist_added), "You must be logged in to manage your wishlist.");
		} else {
			H.ass(H.getTextCss(view_wishlist_added), "Added to your wishlist.");
		}
		H.waitCss(view_wishlist_added_close, 10);
		H.clickCss(view_wishlist_added_close);
	}
	
	public static Item readQuickView(int id, boolean setfavorite) {
		goHome();
		H.waitCss(LoginOut.login_btn);
		boolean loggedin = H.isPresentCss(LoginOut.login_btn);
		
		H.waitCss(popular_item + id + ")");
		H.scrollCss(popular_item + id + ")");
		H.sleep(1);
		H.hoverCss(popular_item + id + ")");
		H.sleep(2);
		
		H.location("QuickView");
		H.clickCss(quick_view1 + id + quick_view2);
		H.sleep(3);
		H.pl("There are iframes: " + H.iframeCount());
		
		H.switchIframe(1);
		H.waitCss(view_name);
		Item item = new Item();
		
		item.name = H.getTextCss(view_name);
		item.model = H.getTextCss(view_model);
		item.condition = H.getTextCss(view_condition);
		item.description = H.getTextCss(view_description);
		item.price = H.getTextCss(view_price);
		
		H.clickCss(view_size);
		String tmp;
		for(int i = 1; H.isPresentCss(view_size_options + i + ")") ; ++ i) {
			tmp = H.getTextCss(view_size_options + i + ")");
			item.sizes.add(tmp);
		}
		H.clickCss(view_size);
		
		for(int i = 1; H.isPresentCss(view_color + i + ")") ; ++ i) {
			tmp = H.getAttributeCss(view_color + i + ") > a", "name");
			item.colors.add(tmp);
		}
		
		if (setfavorite) {
			addToFavorites(loggedin);
		}
		
		//TODO: add buy merch here with function paramer as triger
		H.switchIframeDefault();
		H.clickCss(view_close);
		goHome();
		return item;
	}
	//====================================
	
}







