package helper;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;





public class H {
	
	

	/*****************************************************
	 * This will print "This is a test 3 times"
	 * This was made out of laziness
	 * ****************************************************/
	public static String thisISTest()
	{
		String rep = "This is a test";
		for (int i = 0; i == 1; ++i)
		{
			rep += rep;
		}
		return rep;
	}
	
	public static void ass(boolean condition) {
		if(!condition) {
		    throw new IllegalArgumentException("Condition is not true");
		}
	}
	
	public static void ass(boolean condition, String msj) {
		if(!condition) {
		    throw new IllegalArgumentException(msj);
		}
	}
	
	public static void ass(String msg) {
		throw new IllegalArgumentException(msg);
	}
	
	public static void ass(String a, String b) {
		pl("<assert>: " + a + " == " + b);
		ass(a.equals(b));
	}
	
	public static void ass(int a, int b) {
		pl("<assert>: " + a + " == " + b);
		ass(a == b);
	}
	
	
	public static void switchIframe(String id) {
		S.driver.switchTo().frame(id);
	}
	
	public static void switchIframe(int id) {
		S.driver.switchTo().frame(id);
	}
	
	public static void switchIframeDefault() {
		S.driver.switchTo().defaultContent();
	}
	
	public static int iframeCount() {
		return S.driver.findElements(By.tagName("iframe")).size();
	}

	
	
	//##############################################################################  Under work
	// TODO: this clicks on the previous cell if the current cell has such text
	/*S.driver.findElement(By.xpath("//td[contains(text(),'OrderPro Test Customer')]/preceding-sibling::td/input[@type='radio']")).click();*/
	//##############################################################################  Under work
	
	
	
	
	//##############################################################################  Start Drop Down
	
	/*****************************************************
	 * Return:  the text from the FIRST SELECTED OPTION in a drop-down menu
	 * Takes :  X-Path of the drop-down
	 * ****************************************************/
	public static boolean switchWindow( String title) {

		try {
			String currentWindow = S.driver.getWindowHandle();
			Set<String> availableWindows = S.driver.getWindowHandles();
			if (!availableWindows.isEmpty()) {
				for (String windowId : availableWindows) {
					if (S.driver.switchTo().window(windowId).getTitle().equals(title)) {
						return true;
					} else {
						S.driver.switchTo().window(currentWindow);
					}
				}
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return false;
		}

	
	
	public static void writeThenEnterEnter(String css, String msj) {
		S.driver.findElement(By.cssSelector(css)).sendKeys(msj,Keys.ENTER);
	}
	
	
	public static String getDropDownSelectedoption(String xpath)
	{
		String selectedOption = new Select(S.driver.findElement(By.xpath(xpath))).getFirstSelectedOption().getText();
		return selectedOption;
	}
	
	
	/*****************************************************
	 * Returns : The number of options in a drop-down menu
	 * Takes   : X path of the drop-down
	 * 
	 * IMPORTANT: Depending on the drop-down type
	 * 		this may return more elements than there are in the drop-down      //TODO: IMPORTANT NOTE
	 * 		in such case it is safe to subtract the extra "Not Real" elements
	 * ****************************************************/
	public static Integer dropDownNoOfOptions(String xpath) 			// by x-path
	{
		String[] options = S.driver.findElement(By.xpath(xpath)).getText().split("\n");
		return options.length;
	}
	
	/*****************************************************
	 * Returns : The number of options in a drop-down menu
	 * Takes   : Name attribute of the drop-down
	 * 
	 * IMPORTANT: Depending on the drop-down type
	 * 		this may return more elements than there are in the drop-down      //TODO: IMPORTANT NOTE
	 * 		in such case it is safe to subtract the extra "Not Real" elements
	 * ****************************************************/
	public static Integer dropDownNoOfOptionsByName(String name) 		 // by name
	{
		String[] options = S.driver.findElement(By.name(name)).getText().split("\n");
		return options.length;
	}
	//------------------------------------------------------------------------------------------------------------
	/*****************************************************
	 * Select an option in a drop-down
	 * Takes :  X-Path of the drop-down, and the value of the option. See -->  <option value="samsung">Samsung</option>
	 * ****************************************************/
	public static void dropdownSelectByValue(String xpath, String value)
	{
		WebElement element=S.driver.findElement(By.xpath(xpath));
		Select se=new Select(element);
		
		se.selectByValue(value);
	}
	
	/*****************************************************
	 * Select an option in a drop-down
	 * Takes :  name of the drop-down, and the value of the option. See -->  <option value="samsung">Samsung</option>
	 * ****************************************************/
	public static void dropdownSelectByNameAndValue(String name, String value)
	{
		WebElement element=S.driver.findElement(By.name(name));
		Select se=new Select(element);
		
		se.selectByValue(value);
	}
	
	/*****************************************************
	 * Remove Selection of option in a drop-down
	 * Takes :  X-Path of the drop-down, and the value of the option. See -->  <option value="samsung">Samsung</option>
	 * ****************************************************/
	public static void dropdown_DE_SelectByValue(String xpath, String value)
	{
		WebElement element=S.driver.findElement(By.xpath(xpath));
		Select se=new Select(element);

		se.deselectByValue(value);
	}


	/*****************************************************
	 * Selects an item from a drop-down
	 * Takes :  X-Path of the drop-down, and the VISIBLE TEXT
	 * ****************************************************/
	public static void dropdownSelect(String xpath, String text)
	{
		WebElement element=S.driver.findElement(By.xpath(xpath));
		Select se=new Select(element);

		se.selectByVisibleText(text);
	}
	
	/*****************************************************
	 * Selects an item from a drop-down
	 * Takes :  X-Path of the drop-down, and the NAME attribute, and VISIBLE TEXT of the option
	 * ****************************************************/
	public static void dropdownSelectByName(String name, String text)
	{
		WebElement element=S.driver.findElement(By.name(name));
		Select se=new Select(element);

		se.selectByVisibleText(text);
	}
	
	
	/*****************************************************
	 * Selects an item from a drop-down
	 * Takes :  X-Path of the drop-down, and the NAME attribute
	 * ****************************************************/
	public static void dropdownSelectByName(String name, int index)
	{
		WebElement element=S.driver.findElement(By.name(name));
		Select se=new Select(element);
		se.selectByIndex(index);
	}
	

	//----------------------------------------------------------------------------
	/*****************************************************
	 * Selects an item from a drop-down
	 * Takes :  X-Path of the drop-down, and Index of the option
	 * ****************************************************/
	public static void dropdownSelect(String xpath, int index)
	{
		WebElement element=S.driver.findElement(By.xpath(xpath));
		Select se=new Select(element);
		se.selectByIndex(index);
	}
	
	/*****************************************************
	 * Remove Selection of an item from a drop-down
	 * Takes :  X-Path of the drop-down, and VISIBLE TEXT
	 * ****************************************************/
	public static void dropdown_DE_Select(String xpath, String text)
	{
		WebElement element=S.driver.findElement(By.xpath(xpath));
		Select se=new Select(element);
		
		// select based on text displayed
		se.deselectByVisibleText(text);
	}
	
	/*****************************************************
	 * Remove Selection of an item from a drop-down
	 * Takes :  X-Path of the drop-down, and INDEX of the option
	 * ****************************************************/
	public static void dropdown_DE_Select(String xpath, int index)
	{
		WebElement element=S.driver.findElement(By.xpath(xpath));
		Select se=new Select(element);
		se.deselectByIndex(index);
	}

	/*****************************************************
	 * Remove ALL selected options in a drop-down
	 * Takes :  X-Path of the drop-down
	 * ****************************************************/
	public static void dropdownDeselectAll(String xpath)
	{
		WebElement element=S.driver.findElement(By.xpath(xpath));
		Select se=new Select(element);
		
		se.deselectAll();
	}

	//#################################################################################### End Drop Down
	
	
	//################################################################################## Start Random
	
	/*****************************************************
	 * Return : a random boolean (Approximately 50% chance)
	 * ****************************************************/
	public static boolean randomBool()
	{
		return Math.random() < 0.5;
	}
	
	/*****************************************************
	 * Return : A random string of a given length
	 * Takes  : Length of the random string
	 * 
	 * NOTE: The string returned will be generated based on "String AB"
	 * ****************************************************/
	public static String randomStr( int len ){
		String AB = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		SecureRandom rnd = new SecureRandom();
		
	   StringBuilder sb = new StringBuilder( len );
	   for( int i = 0; i < len; i++ ) 
	      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
	   return sb.toString();
	}
	
	/*****************************************************
	 * Return : A random string NO WHITE-SPACE of a given length
	 * Takes  : Length of the random string NO WHITE-SPACE
	 * 
	 * NOTE: The string returned will be generated based on "String AB"
	 * ****************************************************/
	public static String randomStrNoSpace( int len ){
		String AB = "abcdefghijklmnopqrstuvwxyz";
		SecureRandom rnd = new SecureRandom();
		
	   StringBuilder sb = new StringBuilder( len );
	   for( int i = 0; i < len; i++ ) 
	      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
	   return sb.toString();
	}
	
	/*Send keys by CSS Selector*/
	public static void sendKeysbyCSS(String css, String text){
		
		
		S.driver.findElement(By.cssSelector(css)).sendKeys(text); 
		
		
		
	}
	
	/*****************************************************
	 * Return : A random Integer within a given inclusive interval
	 * Takes  : The inclusive interval (minimum, maximum)
	 * ****************************************************/
	public static Integer randomInt(int min, int max) {     // interval is INCLUSIVE
		
		if(max < 0){ max = max * -1;}
		if(max == 0){max = 1;}
		if (min > max) {H.pl("Error: min > max; at: a.randomInt(); returning 0;"); return 0;}
		// All inclusive
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    
	    return randomNum;
	}
	//################################################################################## End Random
	
	//################################################################################## Start Delete Cookies
	//Question: Are flash cookies deleted? I do not think so
	
	/*****************************************************
	 * Deletes a cookie by its name
	 * Takes : Cookie Name
	 * ****************************************************/
	public static void deleteCookie(String cookieName)
	{
		S.driver.manage().deleteCookieNamed(cookieName);
	}	
	
	/*****************************************************
	 * Deletes all cookies in the browser
	 * ****************************************************/
	public static void deleteAllCookies()
	{
		S.driver.manage().deleteAllCookies();
	}
	//################################################################################## End Delete Cookies
	
	//################################################################################## Start Scroll
	
	/*****************************************************
	 * Scroll to a given element in the page
	 * Takes : Element X-path
	 * ****************************************************/
	public static void scrollTo(String xpath)
	{
       WebElement element = S.driver.findElement(By.xpath(xpath));
       JavascriptExecutor jse = (JavascriptExecutor)S.driver;
       jse.executeScript("arguments[0].scrollIntoView();", element);
       
	}
	
	public static void scrollCss(String css)
	{
       WebElement element = S.driver.findElement(By.cssSelector(css));
       JavascriptExecutor jse = (JavascriptExecutor)S.driver;
       jse.executeScript("arguments[0].scrollIntoView();", element);
       
	}

	/*****************************************************
	 * Scroll to the bottom of the page
	 * ****************************************************/
	public static void scrollBottom()
	{
	    JavascriptExecutor jse = (JavascriptExecutor)S.driver;
       jse.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
       
	}
	
	/*****************************************************
	 * Scroll horizontally, vertically, or a combination of both directions in the page
	 * Takes : Horizontal and Vertical
	 * 
	 * NOTE: Units are in PIXELS
	 * LR : Positive values will scroll to the left, while negative values will scroll to the right
	 * UD : Positive values will scroll down, while negative values scroll up
	 * ****************************************************/
	public static void scroll(int LR, int UD)
	{
       JavascriptExecutor jse = (JavascriptExecutor)S.driver;
       String scroll = "window.scrollBy(" + LR + "," + UD + ")";
       jse.executeScript(scroll, "");
	}
	//################################################################################## End Scroll
	
	
	//################################################################################## Start Get Page Info
	/*****************************************************
	 * Return : Current URL
	 * ****************************************************/
	public static String getUrl()
	{
		  //Get current page URL
		  String CurrentURL = S.driver.getCurrentUrl();
		  return CurrentURL;
	}
	
	/*****************************************************
	 * Return : Current page TITLE
	 * ****************************************************/
	public static String getTitle( ){
		
		 JavascriptExecutor javascript = (JavascriptExecutor) S.driver;
		
		  String pagetitle=(String)javascript.executeScript("return document.title");
		  return pagetitle;
	}
	
	/*****************************************************
	 * Return : Current page Domain
	 * ****************************************************/
	public static String getDomain(){
		
		 JavascriptExecutor javascript = (JavascriptExecutor) S.driver;
		 
		 String Domain=(String)javascript.executeScript("return document.domain");
		 return Domain;
	}
	
	//################################################################################## End Get Page Info

	
	//################################################################################## Start Alert and Prompt
	/*****************************************************
	 * Accept an ALERT and print the alert MESSAGE
	 * ****************************************************/
	public static void alertAccept( )
	{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {   // wait fo alert to load
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // 
		
		  String alert_message = S.driver.switchTo().alert().getText();
		  S.driver.switchTo().alert().accept();
		  System.out.println("Alert Message: " + alert_message);
	}
	
//Warning, this is deprecated
//	public static void alertcredentials() {
//		WebDriverWait wait = new WebDriverWait(S.driver, 20);      
//		Alert alert = wait.until(ExpectedConditions.alertIsPresent());     
//		alert.authenticateUsing(new UserAndPassword("admin", "gbhgbh123**"));
//	}
	
	
	
	/*****************************************************
	 * Cancel an ALERT and print the alert MESSAGE
	 * 
	 * Takes : The X-path of the element to be double clicked
	 * ****************************************************/
	public static void alertCancel( )
	{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {   // wait fo alert to load
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // 
		
		  String alert_message = S.driver.switchTo().alert().getText();
		  S.driver.switchTo().alert().dismiss();
		  System.out.println(alert_message);
	}
	
	/*****************************************************
	 * Accept a Prompt and print its message
	 * 
	 * Takes : String as input to the prompt
	 * ****************************************************/
	public static void promptAccept(String text){
		
		//TODO set text appears not to be working
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		  Alert A3 = S.driver.switchTo().alert();
		  String Alert3 = A3.getText();
		  System.out.println(Alert3);
		  //To type text In text box of prompt pop up.
		  A3.sendKeys(text);

		  A3.accept();  
	}
	
	/*****************************************************
	 * Cancel a Prompt and print its message  (Dismiss the prompt)
	 * ****************************************************/
	public static void promptCancel(){
		
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	  Alert A3 = S.driver.switchTo().alert();
	  String Alert3 = A3.getText();
	  System.out.println(Alert3);
	
	  A3.dismiss();  
	}
	//################################################################################## End Alert and Prompt
	
	//################################################################################## Start Click
	/*****************************************************
	 * Click an element
	 * Takes : X-path of the element to click
	 * ****************************************************/
	public static void click(String xpath){  // click
		S.driver.findElement(By.xpath(xpath)).click(); 
	}
	
	/*****************************************************
	 * Click an element
	 * Takes : X-path of the element to click
	 * ****************************************************/
	public static void clickCss(String css){  // click
		S.driver.findElement(By.cssSelector(css)).click(); 
	}
	
	/*****************************************************
	 * Click an element
	 * Takes : LinkText of the element to click
	 * ****************************************************/
	public static void clickByLinkText(String linkText){  // click
		
		S.driver.findElement(By.linkText(linkText)).click(); 
	}
	
	/*****************************************************
	 * Click an element
	 * Takes : NAME attribute of the element to click
	 * ****************************************************/
	public static void clickByName(String name){  // click
		S.driver.findElement(By.name(name)).click(); 
	}
	
	/*****************************************************
	 * Double click an element
	 * 
	 * Takes : The X-path of the element to be double clicked
	 * ****************************************************/
	public static void doubleClick(String xpath){
		
		  WebElement ele = S.driver.findElement(By.xpath(xpath));
		  
		  //To generate double click action
		  Actions action = new Actions(S.driver);
		  action.doubleClick(ele);
		  action.perform();
	}
	

	
	
	/*****************************************************
	 * Hover the mouse over an element and then clicks an element (Presumably the second element shows On-Hover)
	 * Takes: Hover element CSS and Click element X-path
	 * 
	 * Note: When testing please do not hover the actual mouse over the bowser, because it may confuse the hover-action 
	 * ****************************************************/
	public static void hoverClickCss(String parent, String child) {
		H.info("HoverClicking");
		// Locating the (Parent element)
		WebElement mainMenu = S.driver.findElement(By.cssSelector(parent));
		//Instantiating Actions class
		Actions actions = new Actions(S.driver);
		//Hovering on main menu
		actions.moveToElement(mainMenu);
		// Locating the element from Sub Menu
		WebElement subMenu = S.driver.findElement(By.cssSelector(child));
		//To mouseover on sub menu
		actions.moveToElement(subMenu);
		//build()- used to compile all the actions into a single step 
		actions.click().build().perform();
	}
	
	public static void hoverCss(String css) {
		H.info("Hover");
		// Locating the (Parent element)
		WebElement mainMenu = S.driver.findElement(By.cssSelector(css));
		Actions actions = new Actions(S.driver);
		actions.moveToElement(mainMenu);
		actions.moveToElement(mainMenu).build().perform();
	}
	

	//################################################################################## End CLick
	
	//################################################################################## Start Write and Read Text
	/*****************************************************
	 * Return : The text within an element
	 * Takes : X-path to the element
	 * ****************************************************/
	public static String getText( String xpath){ // get text
		return S.driver.findElement(By.xpath(xpath)).getText(); 
	}
	
	/*****************************************************
	 * Return : true if the attribute of an element is found, false otherwise
	 * Takes : CSS to the element, and attribute name
	 * ****************************************************/
	public static boolean isAttributeCss( String css, String attribute){ // get text
		return S.driver.findElement(By.cssSelector(css)).getAttribute(attribute) != null; 
	}
	
	
	/*****************************************************
	 * Return : The text within an element
	 * Takes : CSS to the element
	 * ****************************************************/
	public static String getTextCss( String css){ // get text
		
		String text = S.driver.findElement(By.cssSelector(css)).getText();
		H.pl("<gettext>: " + text);
		return text;
	}
	
	/*****************************************************
	 * Write text into an ELEMENT
	 * Takes : X-path of the element, Text to be sent
	 * ****************************************************/
	public static void sendkeys( String xpath, String text){  //sendKeys
		S.driver.findElement(By.xpath(xpath)).sendKeys(text);
	}
	
	/*****************************************************
	 * Write text into an ELEMENT
	 * Takes : NAME attribute of the element, Text to be sent
	 * ****************************************************/
	public static void sendkeysByName( String name, String text){  //sendKeys
		S.driver.findElement(By.name(name)).sendKeys(text);
	}
	
		
	/*****************************************************
	 * Remove all text from an element (input, text-area,...)
	 * Takes : X-path of the element
	 * ****************************************************/
	public static void clear(String xpath){  //.clear
		S.driver.findElement(By.xpath(xpath)).clear();
	}
	
	/*****************************************************
	 * Remove all text from an element (input, text-area,...)
	 * Takes : X-css of the element
	 * ****************************************************/
	public static void clearCss(String css){  //.clearcss
		S.driver.findElement(By.cssSelector(css)).clear();
	}
	
	/*****************************************************
	 * Remove all text from an element (input, text-area,...) using backspacce
	 * Takes : X-css of the element
	 * ****************************************************/
	public static void CmdAdelCss(String css){  //.clearcss
		S.driver.findElement(By.cssSelector(css)).sendKeys(Keys.COMMAND, "a");
		S.driver.findElement(By.cssSelector(css)).sendKeys(Keys.DELETE);
	}
	
	
	
		/*****************************************************
	 * Remove all text from an element (input, text-area,...)
	 * Takes : Name of the element
	 * ****************************************************/
	public static void clearByName(String name){  //.clear
		S.driver.findElement(By.name(name)).clear();
	}
	
	
	/*****************************************************
	 * Send a single keyboard press to the page
	 * Takes : Keys key
	 * ****************************************************/
	public static void press(Keys key){ 		// press a key once
		Actions myAction = new Actions(S.driver);
		myAction.sendKeys(key).build().perform();
	}
	
	/*****************************************************
	 * Send a string
	 * Takes : string
	 * ****************************************************/
	public static void press(String msj){ 		// press a key once
		Actions myAction = new Actions(S.driver);
		myAction.sendKeys(msj).build().perform();
	}
	
	/*****************************************************
	 * Send a single keyboard press many times to the page
	 * Takes : Keys key, and a NUMBER representing the number of consecutive times to send the keyboard press
	 * ****************************************************/
	public static void press( Keys key, int rep){ // press one key n number of times
		Actions myAction = new Actions(S.driver);
		
		for (int i = 0; i < rep; ++i ){
			myAction.sendKeys(key).build().perform();
		}
	}
	
	public static void robotPaste(String text) {
		StringSelection stringSelection = new StringSelection(text);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, stringSelection);

		S.robot.keyPress(KeyEvent.VK_CONTROL);
		S.robot.keyPress(KeyEvent.VK_V);
		S.robot.delay(100);
		S.robot.keyRelease(KeyEvent.VK_V);
		S.robot.keyRelease(KeyEvent.VK_CONTROL);
		S.robot.delay(100);
	}
	
	public static void robotCopy(String text) {
		StringSelection stringSelection = new StringSelection(text);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, stringSelection);

		S.robot.keyPress(KeyEvent.VK_CONTROL);
		S.robot.keyPress(KeyEvent.VK_C);
		S.robot.delay(100);
		S.robot.keyRelease(KeyEvent.VK_C);
		S.robot.keyRelease(KeyEvent.VK_CONTROL);
		S.robot.delay(100);
	}
	
	public static void robotType (String keys) {
	    for (char c : keys.toCharArray()) {
	        int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
	        if (KeyEvent.CHAR_UNDEFINED == keyCode) {
	            throw new RuntimeException(
	                "Key code not found for character '" + c + "'");
	        }
	        S.robot.keyPress(keyCode);
	        S.robot.delay(100);
	        S.robot.keyRelease(keyCode);
	        S.robot.delay(100);
	    }
		
	}
	
	public static void robotTypeTab () {
        S.robot.keyPress(KeyEvent.VK_TAB);
        S.robot.delay(100);
        S.robot.keyRelease(KeyEvent.VK_TAB);
        S.robot.delay(100);
		
	}
	public static void robotTypeEnter () {
        S.robot.keyPress(KeyEvent.VK_ENTER);
        S.robot.delay(100);
        S.robot.keyRelease(KeyEvent.VK_ENTER);
        S.robot.delay(100);
		
	}
	
	public static void robotTypeDown () {
        S.robot.keyPress(KeyEvent.VK_DOWN);
        S.robot.delay(100);
        S.robot.keyRelease(KeyEvent.VK_DOWN);
        S.robot.delay(100);
		
	}
	
	public static void robotTypeAsterisk () {
		doType(KeyEvent.VK_SHIFT, KeyEvent.VK_8);
		
	}
	
	//robot helper
	
	public static void doType(int keyCode)
	{
	    try
	    {
	    	S.robot.keyPress(keyCode);
	    	S.robot.keyRelease(keyCode);
	    	S.robot.delay(50);
	    }
	    catch(Exception e)
	    {
	        System.out.println("Invalid key code(s) for above character");
	    }
	}
	 
	public static void doType(int keyCode1, int keyCode2)
	{
	    try
	    {
	    	S.robot.keyPress(keyCode1);
	    	S.robot.keyPress(keyCode2);
	    	S.robot.delay(50);
	    	S.robot.keyRelease(keyCode2);
	    	S.robot.keyRelease(keyCode1);
	    	S.robot.delay(50);
	    	
	    }
	    catch(Exception e)
	    {
	        System.out.println("Invalid key code(s) for above character");
	    }
	}
	
	//-=-=-=-=-=-=-=-=-=-=- Console -=-=-=-=-=-=-=-=-=-=-=
	
	/*****************************************************
	 * Just a regular System.out.println(String text)
	 * Takes : The text to be printed to the console
	 * ****************************************************/
	public static void pl(String print){  // System.out.println(arg0);
		System.out.println(print);
	}
	
	/*****************************************************
	 * Just a regular System.out.print(String text)
	 * Takes : The text to be printed to the console no \n at end
	 * ****************************************************/
	public static void p(String print){  // System.out.println(arg0);
		System.out.print(print);
	}
	
	/*****************************************************
	 * To make Newlines in console
	 * ****************************************************/
	public static void pl(){  // System.out.println();
		System.out.println();
	}

	
	
	//################################################################################## End Write and Read Text
	
	//################################################################################## Start Wait, Sleep, ...
	/*****************************************************
	 * Return : true if element is visible and not hidden and can be accessed, otherwise return false
	 * Takes : X-path of the element
	 * ****************************************************/
	public static boolean isPresent( String xpath){
		return (S.driver.findElements(By.xpath(xpath)).size() > 0);
	}
	
	/*****************************************************
	 * Return : true if element is visible and not hidden and can be accessed, otherwise return false
	 * Takes : X-path of the element
	 * ****************************************************/
	public static boolean isPresentCss( String css){
		if (css.length() < 2) { return false; }
		return (S.driver.findElements(By.cssSelector(css)).size() > 0);
	}
	
	
	/*****************************************************
	 * Return : true if element is visible and not hidden and can be accessed, otherwise return false
	 * Also, wait x time for the element to become visible
	 * Takes : X-path of the element
	 * ****************************************************/
	public static boolean isPresentCss( String css, int waitSecs){
		if (css.length() < 2) { return false; }
		for (int i = 0; i < waitSecs; ++ i) {
			sleep(1);
			if (S.driver.findElements(By.cssSelector(css)).size() > 0) {
				return true;
			}
		}
		return false;
	}
	
	public static int isPresentCss( String[] css){
		if (css.length < 1) { return -1; }
		for (int i = 0; i < 30; ++ i) {
			sleep(1);
			for (int j = 0; i < css.length; ++ j) {
				if (isPresentCss(css[j])) {
					return j;
				}
			}
		}
		return -1;
	}
	
	
	/*****************************************************
	 * Return : true if element is visible and not hidden and can be accessed, otherwise return false
	 * Takes : Css of the element
	 * ****************************************************/
	public static int getChildCountCss( String css){
		return S.driver.findElements(By.cssSelector(css)).size();
	}
	
	/*****************************************************
	 * Return : true if element is visible and not hidden and can be accessed, otherwise return false
	 * Takes : Css of the element
	 * ****************************************************/

	
	/*****************************************************
	 * Return : true if element is visible and not hidden and can be accessed, otherwise return false
	 * Takes : X-path of the element
	 * ****************************************************/
	public static int getChildCount( String xpath){
		return S.driver.findElements(By.xpath(xpath)).size();
	}
	
	/*****************************************************
	 * Return : true if element is visible and not hidden and can be accessed, otherwise return false
	 * Takes : X-path of the element
	 * ****************************************************/
	public static String getCssClass( String css){
		return S.driver.findElement(By.cssSelector(css)).getAttribute("class");
	}
	
	
	
	
	/*****************************************************
	 * Wait for an element to load into the page (Before clicking an element you want to be sure it has loaded)
	 * Takes : X-path of the element, Seconds to wait for it to load
	 * 
	 * Note: if it has not loaded after the seconds have passed,
	 * 		And a timeout exception will be thrown
	 * ****************************************************/
	public static void wait( String xpath, int secs){ 
		WebDriverWait wait = new WebDriverWait(S.driver, secs);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	
	
	/*****************************************************
	 * Wait for an element to load into the page (Before clicking an element you want to be sure it has loaded)
	 * Takes : X-path of the element, Seconds to wait for it to load
	 * 
	 * Note: if it has not loaded after the seconds have passed,
	 * 		And a timeout exception will be likely thrown
	 * ****************************************************/
	public static void waitCss( String selector, int secs){ 
		WebDriverWait wait = new WebDriverWait(S.driver, secs);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector)));
	}
	
	/*****************************************************
	 * Wait for an element to load into the page (Before clicking an element you want to be sure it has loaded)
	 * Takes : X-path of the element, Seconds is asumed to be 30
	 * 
	 * Note: if it has not loaded after the seconds have passed,
	 * 		And a timeout exception will be likely thrown
	 * ****************************************************/
	public static void waitCss( String selector){ 
		WebDriverWait wait = new WebDriverWait(S.driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector)));
	}
	
	/*****************************************************
	 * Wait for an element to load into the page (Before clicking an element you want to be sure it has loaded)
	 * Takes : ID of the element, Seconds to wait for it to load
	 * 
	 * Note: if it has not loaded after the seconds have passes, the test will try to continue regardless
	 * 		And a timeout exception will be likely thrown
	 * ****************************************************/
	
	public static void waitID( String ID, int secs){ 
		WebDriverWait wait = new WebDriverWait(S.driver, secs);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ID)));
	}
	
	/*****************************************************
	 * WARNING: this is considered DANGEROUS and must be used with care, Use wait instead
	 * Force the Thread to wait for a certain amount of seconds before proceeding with execution
	 * ****************************************************/
	public static  void sleep(double d) { // Thread.sleep
		try {
			Thread.sleep((int) (d * 1000));
		} catch (InterruptedException e) {
			H.error("El metodo sleep ha fallado");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void check(boolean term, String msj) {
		if (!term) {
			H.pl("<ERROR> " + msj);
		}
	}
	
	public static void warn(String msj) {
			H.pl("<WARNING> " + msj);
	}
	
	public static void error(String msj) {
		H.pl("<ERROR> " + msj);
	}
	
	public static void info(String msj) {
		H.pl("<INFO> " + msj);
	}
	
	public static void location(String msj) {
		H.pl("<LOCATION> " + msj);
	}
	
	//################################################################################## End Wait, Sleep, ...
	
	
	//********************************************************************************************************
	//***************************** Start Assorted ***********************************************************
	
	/*****************************************************
	 * Go to previous page (Like Pressing the back arrow in browser)
	 * ****************************************************/
	public static void goBack( )
	{
		S.driver.navigate().back();
	}
	
	/*****************************************************
	 * Go to next page (Like Pressing the forward arrow in browser)
	 * ****************************************************/
	public static void goForward( )
	{
		S.driver.navigate().forward();
	}
	
	/*****************************************************
	 * Move a SLIDER right
	 * 
	 * Takes : The X-path of the Slider, and the number of moves to be made towards the right
	 * ****************************************************/
	public static void sliderMoveRigth(String xpath, int move){
   WebElement slider = S.driver.findElement(By.xpath(xpath));
   
   //TODO this can be applied to many other elements
   for (int i = 1; i <= move ; i++) {
           slider.sendKeys(Keys.ARROW_RIGHT);
       }
	}

	/*****************************************************
	 * Move a SLIDER left
	 * 
	 * Takes : The X-path of the Slider, and the number of moves to be made towards the left
	 * ****************************************************/
	public static void sliderMoveLeft(String xpath, int move){
	    WebElement slider = S.driver.findElement(By.xpath(xpath));

	    for (int i = 1; i <= move ; i++) {
	        slider.sendKeys(Keys.ARROW_RIGHT);
	    }
	}
	
	public static void pressDown(String css, int move){
	    WebElement slider = S.driver.findElement(By.cssSelector(css));

	    for (int i = 0; i < move ; i++) {
	        slider.sendKeys(Keys.ARROW_DOWN);
	    }
	}
	

	/*****************************************************
	 * Upload a file to a page
	 * Takes : X-path of the web-element, and local-path of the file to be uploaded
	 * ****************************************************/
	public static void uploadFile(String xpath,String filePath){
       WebElement element = S.driver.findElement(By.xpath(xpath));
		element.sendKeys(filePath);
	}
	
	

	
	
	
//	public static String getClassCss(String css){
//	       WebElement element = S.driver.findElement(By.cssSelector(css));
//	       return element.getAttribute("class");
//	}
	
	
	//********************************************************************************************************
	//***************************** End Assorted *************************************************************
	/*****************************************************
	 * Converts text to uppercase
	 * ****************************************************/
	public static String uppercase(String css, String text) {
		return text.toUpperCase();
	}
	
	
	/*****************************************************
	 * Get text from angular input
	 * ****************************************************/
	public static String getTextCssAngAll(String css) {
		String theTextIWant = "";
		List<WebElement> values = S.driver.findElements(By.cssSelector(css));
		for(WebElement el : values)
		{
		  theTextIWant += el.getAttribute("value");
		}
		return theTextIWant;
	}
	
	public static String getTextCssAng(String css ) {
		WebElement value = S.driver.findElement(By.cssSelector(css));
		return value.getAttribute("value");
	}
	
	public static String getAttributeCss(String css, String attribute ) {
		String tmp = S.driver.findElement(By.cssSelector(css)).getAttribute(attribute);
		pl("<getattr>: " + tmp);
		return tmp;
	}
	
	
	
	//********************************************************************************************************
	//***************************** End Assorted *************************************************************
	

	
	
	
	
	
	
}//class end




