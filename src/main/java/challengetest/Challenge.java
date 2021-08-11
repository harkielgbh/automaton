package challengetest;

import helper.SharedResouces;
import helper.Helper;


/***
 * 
 * @author harki
 * Purpose: Use this class to test methods and classes, simply call methods here and run this class as java application
 *
 */
public class Challenge {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver92.exe");
		String URL = "http://automationpractice.com/index.php";
		SharedResouces.driver.get(URL);
		
//		LoginOut.loginInvalid();
//		LoginOut.login();
//		LoginOut.logout();
//		
//		Sections.visitSections();
//		Sections.visitSubSections();
//		
//		Footer.visitEachFooterElement();
//		Footer.subscribeNewsletter();
//		
//		HomeMerch.hoverAllMerch();
//		
//		DetailMerch.readDetails(1);
//		DetailMerch.readDetails(3);
		
		Footer.subscribeNewsletter();
		
		
//		Item item;
//		HomeMerch.goHome();
//		item = HomeMerch.readQuickView(1,true);
//		HomeMerch.viewAddToCart(1, item.sizes.get(H.randomInt(0, item.sizes.size()-1)), item.colors.get(H.randomInt(0, item.colors.size()-1)), 3, true);
//		HomeMerch.goHome();
//		
//		item = HomeMerch.readQuickView(2,true);
//		HomeMerch.viewAddToCart(2, item.sizes.get(H.randomInt(0, item.sizes.size()-1)), item.colors.get(H.randomInt(0, item.colors.size()-1)), 4, false);
//		HomeMerch.goHome();
//		
//		item = HomeMerch.readQuickView(2,true);
//		HomeMerch.viewAddToCart(2, item.sizes.get(H.randomInt(0, item.sizes.size()-1)), item.colors.get(H.randomInt(0, item.colors.size()-1)), 4, false);
//		HomeMerch.goHome();
//		
//		item = HomeMerch.readQuickView(3,true);
//		HomeMerch.viewAddToCart(3, item.sizes.get(H.randomInt(0, item.sizes.size()-1)), item.colors.get(H.randomInt(0, item.colors.size()-1)), 4, false);
//		HomeMerch.goHome();
//		
//		item = HomeMerch.readQuickView(3,true);
//		HomeMerch.viewAddToCart(3, item.sizes.get(H.randomInt(0, item.sizes.size()-1)), item.colors.get(H.randomInt(0, item.colors.size()-1)), 5, true);
//		H.sleep(3);
//		Checkout.compareCart();
//		
		
		
	}
}


/*
press add a product with a blanc field = ammunt != expected
















*/