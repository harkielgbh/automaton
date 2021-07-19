package challengetest;

import helper.H;

public class Footer {
	//categories
	static String contactus_btn = "#contact-link";
	
	static String foot_categories 	= "#footer > div > section.blockcategories_footer.footer-block.col-xs-12.col-sm-2 > h4";
	static String foot_women 		= "#footer > div > section.blockcategories_footer.footer-block.col-xs-12.col-sm-2 > div > div > ul > li > a";

	static String foot_info 		= "#block_various_links_footer > h4";
	static String foot_info_child 	= "#block_various_links_footer > ul > li:nth-child("; //1) > a";

	static String foot_account 	= "#footer > div > section:nth-child(7) > h4 > a";
	static String foot_account_child 	= "#footer > div > section:nth-child(7) > div > ul > li:nth-child("; //1) > a";
	
	static String [][] footer_categories = {
		{"Categories",""}
		,{"Women", "WOMEN "}
	};
		//===================
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
		//==================
	static String [][] footer_account = {
		{"My account",""}
		,{"My orders","ORDER HISTORY"}
		,{"My credit slips","CREDIT SLIPS"}
		,{"My addresses","MY ADDRESSES"}
		,{"My personal info","YOUR PERSONAL INFORMATION"}
		,{"Sign out","AUTHENTICATION"}
	};
	
	static String logged_out = "AUTHENTICATION";
	
	
	static public void visitEachFooterElement() {
		String tmpS[] = {Sections.section_title_2,Sections.section_title_3 };
		int tmpI = 0;
		
		H.location("visitEachFooterElement");
		LoginOut.logout();
		
		H.waitCss(foot_categories);
		
		//=============================
		H.clickCss(contactus_btn);
		H.waitCss(Sections.section_title_2, 0);
		H.ass(H.getTextCss(contactus_btn), footer_information[5][0]); // contact us
		H.ass(H.getTextCss(Sections.section_title_2), footer_information[5][1]); // contact us
		//========================
		
		H.ass(H.getTextCss(foot_categories),footer_categories[0][0]);
		H.ass(H.getTextCss(foot_women),footer_categories[1][0]);
		
		H.clickCss(foot_women);
		H.ass(H.getTextCss(Sections.section_title), footer_categories[1][1]);
		
		//=======================
		
		H.ass(H.getTextCss(foot_info),footer_information[0][0]);
		for (int i = 1; H.isPresentCss(foot_info_child + i + ") > a"); ++ i) {
			H.ass(H.getTextCss(foot_info_child + i + ") > a"), footer_information[i][0]);
			H.clickCss(foot_info_child + i + ") > a");
			
			tmpI = H.isPresentCss(tmpS);
			if(tmpI == 0) {
				H.ass(H.getTextCss(Sections.section_title_2), footer_information[i][1]);
			} else if(tmpI == 1){
				H.ass(H.getTextCss(Sections.section_title_3), footer_information[i][1]);
			} else {
				H.ass("Selector not found for section title");
			}
		}
		
		//====================
		
		H.ass(H.getTextCss(foot_account), footer_account[0][0]);
		for (int i = 1; H.isPresentCss(foot_account_child + i + ") > a"); ++ i) {
			H.ass(H.getTextCss(foot_account_child + i + ") > a"), footer_account[i][0]);
			H.clickCss(foot_account_child + i + ") > a");
			
			tmpI = H.isPresentCss(tmpS);
			if(tmpI == 0) {
				H.ass(H.getTextCss(Sections.section_title_2), logged_out);
			} else if(tmpI == 1){
				H.ass(H.getTextCss(Sections.section_title_3), logged_out);
			} else {
				H.ass("Selector not found for section title");
			}
		}
		
		LoginOut.login();
		H.waitCss(foot_account);
		H.ass(H.getTextCss(foot_account), footer_account[0][0]);
		for (int i = 1; H.isPresentCss(foot_account_child + i + ") > a"); ++ i) {
			H.ass(H.getTextCss(foot_account_child + i + ") > a"), footer_account[i][0]);
			H.clickCss(foot_account_child + i + ") > a");
			
			tmpI = H.isPresentCss(tmpS);
			if(tmpI == 0) {
				H.ass(H.getTextCss(Sections.section_title_2), footer_account[i][1]);
			} else if(tmpI == 1){
				H.ass(H.getTextCss(Sections.section_title_3), footer_account[i][1]);
			} else {
				H.ass("Selector not found for section title");
			}
		}
		
	}
	
	static String newsletter_in = "#newsletter-input";
	static String newsletter_btn = "#newsletter_block_left > div > form > div > button";
	static String newsletter_alert = "#columns > p";
	
	static String[][] newsletter_email_alert = {
			{"harkiel2@gmail.com", "Newsletter : This email address is already registered." }
			,{"harkiel2+"+H.randomStr(5)+"@gmail.com", "Newsletter : You have successfully subscribed to this newsletter."}
			,{"invalidemail", "Newsletter : Invalid email address."}
	};
	static public void subscribeNewsletter() {
		for(int i = 0; i < newsletter_email_alert.length; ++ i ) {
			H.waitCss(newsletter_in);
			H.sendKeysbyCSS(newsletter_in, newsletter_email_alert[i][0]);
			H.clickCss(newsletter_btn);
			H.waitCss(newsletter_alert);
			H.ass(H.getTextCss(newsletter_alert), newsletter_email_alert[i][1]);
		}
	}
}
