package challengetest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import helper.H;
import helper.S;

public class Tests {
	
	   @BeforeTest
	   public void launchapp() {
	      // Puts an Implicit wait, Will wait for 10 seconds before throwing exception
	      
			System.setProperty("webdriver.chrome.driver", "chromedriver92.exe");
			String URL = "http://automationpractice.com/index.php";
			S.driver.get(URL);
	   }
	
	@Test
	public void testSpecials() {
		HomeMerch.goHome();
		Specials.onlySpecials();
	}
		
	@Test
	public void testLogin() {
		HomeMerch.goHome();
		LoginOut.loginInvalid();
		LoginOut.login();
		LoginOut.logout();
	}
	
	@Test
	public void testSections() {
		HomeMerch.goHome();
		Sections.visitSections();
		Sections.visitSubSections();
	}
	
	@Test
	public void testFooter() {
		HomeMerch.goHome();
		Footer.visitEachFooterElement();
		Footer.subscribeNewsletter();
	}
	
	@Test
	public void testHover() {
		HomeMerch.goHome();
		HomeMerch.hoverAllMerch();
	}
	
	@Test
	public void testItemDetails() {
		HomeMerch.goHome();
		DetailMerch.readDetails(1);
		DetailMerch.readDetails(3);
	}
	
	
	@Test
	public void testPurchaseMerch() {
		Item item;
		HomeMerch.goHome();
		item = HomeMerch.readQuickView(1,true);
		HomeMerch.viewAddToCart(1, item.sizes.get(H.randomInt(0, item.sizes.size()-1)), item.colors.get(H.randomInt(0, item.colors.size()-1)), 3, true);
		HomeMerch.goHome();
		
		item = HomeMerch.readQuickView(2,true);
		HomeMerch.viewAddToCart(2, item.sizes.get(H.randomInt(0, item.sizes.size()-1)), item.colors.get(H.randomInt(0, item.colors.size()-1)), 4, false);
		HomeMerch.goHome();
		
		item = HomeMerch.readQuickView(2,true);
		HomeMerch.viewAddToCart(2, item.sizes.get(H.randomInt(0, item.sizes.size()-1)), item.colors.get(H.randomInt(0, item.colors.size()-1)), 4, false);
		HomeMerch.goHome();
		
		item = HomeMerch.readQuickView(3,true);
		HomeMerch.viewAddToCart(3, item.sizes.get(H.randomInt(0, item.sizes.size()-1)), item.colors.get(H.randomInt(0, item.colors.size()-1)), 4, false);
		HomeMerch.goHome();
		
		item = HomeMerch.readQuickView(3,true);
		HomeMerch.viewAddToCart(3, item.sizes.get(H.randomInt(0, item.sizes.size()-1)), item.colors.get(H.randomInt(0, item.colors.size()-1)), 5, true);
		H.sleep(3);
		Checkout.compareCart();
	}
	   @AfterTest
	   public void terminatetest() {
	      S.driver.close();
	   }
	


}
