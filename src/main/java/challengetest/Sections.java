package challengetest;


import helper.H;

public class Sections {
	
	static final String section_btn   = "#block_top_menu > ul > li:nth-child("; //1) > a
	static final String section_title = "#center_column > h1 > span.cat-name";
	static final String section_title_2 = "#center_column > h1";
	static final String section_title_3 = "#center_column > div > h1";
	
	static final String[] navbar_butons = {
		"WOMEN"
		,"DRESSES"
		,"T-SHIRTS"
	};
	 
	/****
	 * Read text from category button, then compare text to page title of section
	 * */
	static public void visitSections() { // make sure every section is shown
		H.location("visitEachSection()");
		
		H.waitCss(section_btn + "1) > a");
		for (int i = 1; H.isPresentCss(section_btn + i + ") > a"); ++ i ) { // foreach section
			H.ass(H.getTextCss(section_btn + i + ") > a"),navbar_butons[i-1]);
			H.clickCss(section_btn + i + ") > a");
			H.waitCss(section_title);
			H.ass(H.getTextCss(section_title).trim(), navbar_butons[i-1]);
		}
	}
	//==========================================================
	static String women_tops[][] = {
			{"TOPS",""}
			,{"T-shirts","T-SHIRTS "}
			,{"Blouses","BLOUSES "}
	};
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
	
	static public void visitSubSections() { // enter each subsections and validate
		H.waitCss(section_btn + "1) > a");

		H.hoverCss(section_btn + "1) > a");
		H.ass(H.getTextCss(top), women_tops[0][0]);
		H.ass(H.getTextCss(dress), women_dresses[0][0]);
		
		for (int i = 1; i < women_tops.length; ++ i) {
			H.hoverCss(section_btn + "1) > a");
			H.ass(H.getTextCss(tops + i + ") > a"), women_tops[i][0]);
			H.clickCss(tops + i + ") > a");
			H.waitCss(section_title);
			H.ass(H.getTextCss(section_title), women_tops[i][1]);
		}
		
		H.waitCss(section_btn + "1) > a");
		for (int i = 1; i < women_dresses.length; ++ i) {
			H.hoverCss(section_btn + "1) > a");
			H.ass(H.getTextCss(dresses + i + ") > a"), women_dresses[i][0]);
			H.clickCss(dresses + i + ") > a");
			H.waitCss(section_title);
			H.ass(H.getTextCss(section_title), women_dresses[i][1]);
		}

		H.waitCss(section_btn + "2) > a");
		for (int i = 1; i < women_dresses.length; ++ i) {
			H.hoverCss(section_btn + "2) > a");
			H.waitCss(dresses_sub + i + ") > a");
			H.ass(H.getTextCss(dresses_sub + i + ") > a"), women_dresses[i][1].trim()); // note upper side 
			H.clickCss(dresses_sub + i + ") > a");
			H.waitCss(section_title);
			H.ass(H.getTextCss(section_title), women_dresses[i][1]);
		}
		
	} 

}
