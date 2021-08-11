package challengetest;

import helper.Helper;

/***
 * Purpose: Specials page
 * @author harki
 *
 */
public class Specials {
	public static String base = "#center_column > ul > li:nth-child(";
	public static String discount = ") > div > div.right-block > div.content_price > span.price-percent-reduction";
	
	/***
	 *  make sure all items in discounted page have a discount
	 */
	public static void onlySpecials() {
		Helper.waitCss(Footer.foot_info_child + 1 + ") > a");
		Helper.clickCss(Footer.foot_info_child + 1 + ") > a");
		Helper.waitCss(Sections.section_title_2);
		// for each item in specials section
		for ( int i = 1; Helper.isPresentCss(base + i + ")", 10); ++ i) {
			// make sure each item is discounted
			Helper.asserts(Helper.isPresentCss(base + i + discount, 3), "Discount not found for dicounted item " + i);
		}
		Helper.info("All items are discounted");	
		HomeMerch.goHome();
	}

}
