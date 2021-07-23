package challengetest;

import helper.H;

public class Specials {
	public static String base = "#center_column > ul > li:nth-child(";
	public static String discount = ") > div > div.right-block > div.content_price > span.price-percent-reduction";
	
	public static void onlySpecials() { // make sure all items in discounted page have a discount
		H.waitCss(Footer.foot_info_child + 1 + ") > a");
		H.clickCss(Footer.foot_info_child + 1 + ") > a");
		H.waitCss(Sections.section_title_2);
		
		for ( int i = 1; H.isPresentCss(base + i + ")", 10); ++ i) {
			H.ass(H.isPresentCss(base + i + discount, 3), "Discount not found for dicounted item " + i);
		}
		H.info("All items are discounted");	
		HomeMerch.goHome();
	}

}
