package helper;

import java.awt.AWTException;
import java.awt.Robot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class S {
	public static Robot robot;
	public static WebDriver driver;
	
	static {
		try {
			robot = new Robot();
		} catch (AWTException e) {
			H.pl("There is an issue with java robot class");
			e.printStackTrace();
		}
		//-----
		driver = new ChromeDriver();
	}
	

}
