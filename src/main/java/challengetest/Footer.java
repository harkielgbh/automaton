package challengetest;

import helper.Helper;
/***
 * Purpose: this class represents the footer
 * @author harki
 *
 */
public class Footer {
	
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
	static String contactus_btn = "#contact-link";
	static String foot_categories 	= "#footer > div > section.blockcategories_footer.footer-block.col-xs-12.col-sm-2 > h4";
	static String foot_women 		= "#footer > div > section.blockcategories_footer.footer-block.col-xs-12.col-sm-2 > div > div > ul > li > a";
	static String foot_info 		= "#block_various_links_footer > h4";
	static String foot_info_child 	= "#block_various_links_footer > ul > li:nth-child("; //1) > a";
	static String foot_account 	= "#footer > div > section:nth-child(7) > h4 > a";
	static String foot_account_child 	= "#footer > div > section:nth-child(7) > div > ul > li:nth-child("; //1) > a";
	
	/*
	 * Each entry in the array contains:
	 * 		1 the label expected on the button to be clicked
	 * 		2 the title expected on the page this button redirects to
	 * Note: the title is not click-able and thus has no page related
	 */
	static String [][] footer_categories = {
		{"Categories",""}
		,{"Women", "WOMEN "}
	};
	
	/*
	 * Each entry in the array contains:
	 * 		1 the label expected on the button to be clicked
	 * 		2 the title expected on the page this button redirects to
	 * Note: the title is not click-able and thus has no page related
	 */
	static String [][] footer_information = {
		{"Information",""}
		,{"Specials","PRICE DROP"}
		,{"New products","NEW PRODUCTS"}
		,{"Best sellers","BEST SELLERS"}
		,{"Our stores","OUR STORE(S)!"}
		,{"Contact us","CUSTOMER SERVICE - CONTACT US"}
		,{"Terms and conditions of use","TERMS AND CONDITIONS OF USE"}
		,{"About us","ABOUT US"}
		,{"Sitemap","SITEMAP"}
	};
	
	/*
	 * Each entry in the array contains:
	 * 		1 the label expected on the button to be clicked
	 * 		2 the title expected on the page this button redirects to
	 * Note: the title is not click-able and thus has no page related
	 */
	static String [][] footer_account = {
		{"My account",""}
		,{"My orders","ORDER HISTORY"}
		,{"My credit slips","CREDIT SLIPS"}
		,{"My addresses","MY ADDRESSES"}
		,{"My personal info","YOUR PERSONAL INFORMATION"}
		,{"Sign out","AUTHENTICATION"}
	};
	
	// some pages show this value as title/label when user is logged out
	static String logged_out = "AUTHENTICATION";
	
	/***
	 * Click each element on footer, then make sure correct page is summoned
	 */
	static public void visitEachFooterElement() {
		// screens titles can have one of 2 selectors, here we place them into an array
		String tmpS[] = {Sections.section_title_2,Sections.section_title_3 };
		// temporarily store the index of the correct selector for the title
		// TODO: REMOVE int tmpI = 0;
		
		Helper.location("visitEachFooterElement");
		// logout
		LoginOut.logout();
		// wait for footer
		Helper.waitCss(foot_categories);
		
		//=============================
		// click contact us
		Helper.clickCss(contactus_btn);
		// wait for page
		Helper.waitCss(Sections.section_title_2, 0);
		// make sure button label and page label are correct
		Helper.asserts(Helper.getTextCss(contactus_btn), footer_information[5][0]); // contact us
		Helper.asserts(Helper.getTextCss(Sections.section_title_2), footer_information[5][1]); // contact us
		//========================
		// assert categories section has the right title
		Helper.asserts(Helper.getTextCss(foot_categories),footer_categories[0][0]);
		// make sure "women" has the right label, then click
		Helper.asserts(Helper.getTextCss(foot_women),footer_categories[1][0]);
		Helper.clickCss(foot_women);
		// make sure women page has the right title
		Helper.asserts(Helper.getTextCss(Sections.section_title), footer_categories[1][1]);
		
		//=======================
		// read section title and compare to expected title
		Helper.asserts(Helper.getTextCss(foot_info),footer_information[0][0]);
		// for each element in info section
		for (int i = 1; Helper.isPresentCss(foot_info_child + i + ") > a"); ++ i) {
			// make sure button has the right label then click
			Helper.asserts(Helper.getTextCss(foot_info_child + i + ") > a"), footer_information[i][0]);
			Helper.clickCss(foot_info_child + i + ") > a");
			
			// get the index for the correct selector for page title, then compare with expected title
			Helper.asserts(Helper.getTextCss(tmpS[Helper.isPresentCss(tmpS)]), footer_information[i][1]);
			
		}
		
		//====================
		// read section title and compare to expected title
		Helper.asserts(Helper.getTextCss(foot_account), footer_account[0][0]);
		// for each element in info section
		for (int i = 1; Helper.isPresentCss(foot_account_child + i + ") > a"); ++ i) {
			// make sure button has the right label then click
			Helper.asserts(Helper.getTextCss(foot_account_child + i + ") > a"), footer_account[i][0]);
			Helper.clickCss(foot_account_child + i + ") > a");
			
			// get the index for the correct selector for page title, then compare with expected title
			Helper.asserts(Helper.getTextCss(tmpS[Helper.isPresentCss(tmpS)]), logged_out);
		}
		
		LoginOut.login();
		Helper.waitCss(foot_account);
		// read section title and compare to expected title
		Helper.asserts(Helper.getTextCss(foot_account), footer_account[0][0]);
		// for each element in info section
		for (int i = 1; Helper.isPresentCss(foot_account_child + i + ") > a"); ++ i) {
			// make sure button has the right label then click
			Helper.asserts(Helper.getTextCss(foot_account_child + i + ") > a"), footer_account[i][0]);
			Helper.clickCss(foot_account_child + i + ") > a");
			
			// get the index for the correct selector for page title, then compare with expected title
			Helper.asserts(Helper.getTextCss(tmpS[Helper.isPresentCss(tmpS)]), footer_account[i][1]);
		}
		
	}
	
	
	static String newsletter_in = "#newsletter-input";
	static String newsletter_btn = "#newsletter_block_left > div > form > div > button";
	static String newsletter_alert = "#columns > p";
	
	/*
	 * Each entry contains an (Email + expected_message) combo
	 * If email is X then expected message should be Y
	 * NOTE: a randomizer is used to generate unlikely to repeat Email
	 */
	static String[][] newsletter_email_alert = {
			{"harkiel2@gmail.com", "Newsletter : This email address is already registered." }
			,{"harkiel2+"+Helper.randomStr(5)+"@gmail.com", "Newsletter : You have successfully subscribed to this newsletter."}
			,{"invalidemail", "Newsletter : Invalid email address."}
	};
	static public void subscribeNewsletter() {
		// for each entry on the array
		for(int i = 0; i < newsletter_email_alert.length; ++ i ) {
			// go to footer and wait newsletter
			Helper.scrollBottom();
			Helper.waitCss(newsletter_in);
			// write email and click send
			Helper.sendKeysbyCSS(newsletter_in, newsletter_email_alert[i][0]);
			Helper.waitCss(newsletter_btn);
			Helper.clickCss(newsletter_btn);
			// wait for message and compare with expected message
			Helper.waitCss(newsletter_alert);
			Helper.asserts(Helper.getTextCss(newsletter_alert), newsletter_email_alert[i][1]);
		}
	}
}
