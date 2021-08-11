package challengetest;


import helper.Helper;
/***
 * Purpose: this class represents nav-bar and its sub-menus
 * @author harki
 *
 */
public class Sections {
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
	static final String section_btn   = "#block_top_menu > ul > li:nth-child("; //1) > a
	static final String section_title = "#center_column > h1 > span.cat-name";
	static final String section_title_2 = "#center_column > h1";
	static final String section_title_3 = "#center_column > div > h1";
	
	// list of labels for NavBar buttons
	static final String[] navbar_butons = {
		"WOMEN"
		,"DRESSES"
		,"T-SHIRTS"
	};
	 
	/****
	 * Read text from each navbar section button, then compare text to page title of section
	 * */
	static public void visitSections() { 
		Helper.location("visitEachSection()");
		Helper.waitCss(section_btn + "1) > a");
		// foreach section
		for (int i = 1; Helper.isPresentCss(section_btn + i + ") > a"); ++ i ) {
			// validate button label
			Helper.asserts(Helper.getTextCss(section_btn + i + ") > a"),navbar_butons[i-1]);
			Helper.clickCss(section_btn + i + ") > a");
			Helper.waitCss(section_title);
			// validate button redirects to correct page
			Helper.asserts(Helper.getTextCss(section_title).trim(), navbar_butons[i-1]);
		}
	}

	/*
	 *  list of sub sections for women tops
	 *  each entry contains > {button text, expected page title}
	 */
	static String women_tops[][] = {
			{"TOPS",""}
			,{"T-shirts","T-SHIRTS "}
			,{"Blouses","BLOUSES "}
	};
	/*
	 *  list of sub sections for women tops
	 *  each entry contains > {button text, expected page title}
	 */
	static String women_dresses[][] = {
			{"DRESSES",""}
			,{"Casual Dresses","CASUAL DRESSES "}
			,{"Evening Dresses","EVENING DRESSES "}
			,{"Summer Dresses","SUMMER DRESSES "}
	};
	static String top = "#block_top_menu > ul > li:nth-child(1) > ul > li:nth-child(1) > a";
	static String tops = "#block_top_menu > ul > li:nth-child(1) > ul > li:nth-child(1) > ul > li:nth-child("; //1) > a";
	
	static String dress = "#block_top_menu > ul > li:nth-child(1) > ul > li:nth-child(2) > a";
	static String dresses = "#block_top_menu > ul > li:nth-child(1) > ul > li:nth-child(2) > ul > li:nth-child("; //2) > a"
	
	
	static String dresses_sub = "#block_top_menu > ul > li:nth-child(2) > ul > li:nth-child("; //1) > a";
	
	/****
	 * click on each footer subsections and validate it redirects to the correct page
	 * */
	static public void visitSubSections() {
		// validate subsections buttons text
		Helper.waitCss(section_btn + "1) > a");
		Helper.hoverCss(section_btn + "1) > a");
		Helper.asserts(Helper.getTextCss(top), women_tops[0][0]);
		Helper.asserts(Helper.getTextCss(dress), women_dresses[0][0]);
		
		// for each sub-item on women tops
		for (int i = 1; i < women_tops.length; ++ i) {
			// make sure each button has the right text
			Helper.hoverCss(section_btn + "1) > a");
			Helper.asserts(Helper.getTextCss(tops + i + ") > a"), women_tops[i][0]);
			Helper.clickCss(tops + i + ") > a");
			Helper.waitCss(section_title);
			// and make sure each button redirects to correct page
			Helper.asserts(Helper.getTextCss(section_title), women_tops[i][1]);
		}
		
		// for each sub-item on women dresses
		Helper.waitCss(section_btn + "1) > a");
		for (int i = 1; i < women_dresses.length; ++ i) {
			// make sure each button has the right text
			Helper.hoverCss(section_btn + "1) > a");
			Helper.asserts(Helper.getTextCss(dresses + i + ") > a"), women_dresses[i][0]);
			Helper.clickCss(dresses + i + ") > a");
			Helper.waitCss(section_title);
			// and make sure each button redirects to correct page
			Helper.asserts(Helper.getTextCss(section_title), women_dresses[i][1]);
		}
		// for each sub-item on women dresses
		Helper.waitCss(section_btn + "2) > a");
		for (int i = 1; i < women_dresses.length; ++ i) {
			// make sure each button has the right text
			Helper.hoverCss(section_btn + "2) > a");
			Helper.waitCss(dresses_sub + i + ") > a");
			Helper.asserts(Helper.getTextCss(dresses_sub + i + ") > a"), women_dresses[i][1].trim()); // note upper side 
			Helper.clickCss(dresses_sub + i + ") > a");
			Helper.waitCss(section_title);
			// and make sure each button redirects to correct page
			Helper.asserts(Helper.getTextCss(section_title), women_dresses[i][1]);
		}
		
	} 

}
