package challengetest;

import helper.S;

public class DriverTest {

	public static void start() {

		
		System.setProperty("webdriver.chrome.driver", "chromedriver90.exe");
		String URL = "http://automationpractice.com/index.php";
		S.driver.get(URL);
		

	}

}
