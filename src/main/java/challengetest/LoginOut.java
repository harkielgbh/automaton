package challengetest;

import helper.Helper;

/***
 * Purpose: Login and logout
 * @author harki
 *
 */
public class LoginOut {
	// TODO: find a way to hide credentials
	static final String USERNAME = "piningunin@gmail.com";
	static final String PASSWORD = "h3110moto";
	static final String login_btn = "#header > div.nav > div > div > nav > div.header_user_info";
	static final String email_in = "#email";
	static final String password_in = "#passwd";
	static final String sign_in_btn = "#SubmitLogin > span";
	static final String login_error_message = "#center_column > div.alert.alert-danger > ol > li";
	/***
	 * Login basic valid credentials
	 */
	static public void login() {
		Helper.location("Login");
		Helper.waitCss(login_btn);
		Helper.clickCss(login_btn);
		login(USERNAME,PASSWORD);
	}
	
	/***
	 * Login custom credentials
	 */
	static public void login(String user, String pass) {
		Helper.location("Login");
		Helper.waitCss(login_btn);
		Helper.clickCss(login_btn);
		
		Helper.waitCss(email_in);
		Helper.sendKeysbyCSS(email_in, user);
		Helper.sendKeysbyCSS(password_in, pass);
		Helper.clickCss(sign_in_btn);
	}
	

	/*
	 *  list of invalid credentials along with expected error message
	 */
	static String [][] invalid_credentials = {
		{"pinin","ij","Invalid email address."}
		,{"pin",PASSWORD,"Invalid email address."}
		,{USERNAME,"52","Invalid password."}
		,{USERNAME,"545454ffrfrf","Authentication failed."}
	};
	/***
	 * login with invalid credentials and make sure expected error messages displayed
	 */
	static public void loginInvalid() {
		Helper.location("Login invalid");
		// click login
		Helper.waitCss(login_btn);
		Helper.clickCss(login_btn);
		Helper.waitCss(email_in);
		
		// for each credentials on array
		for (int i = 0; i < invalid_credentials.length; ++ i) {
			// enter user and password
			Helper.sendKeysbyCSS(email_in, invalid_credentials[i][0]);
			Helper.sendKeysbyCSS(password_in, invalid_credentials[i][1]);
			// click login
			Helper.clickCss(sign_in_btn);
			Helper.waitCss(login_error_message);
			// make sure error message is correct when invalid credentials used
			Helper.asserts(Helper.getTextCss(login_error_message), invalid_credentials[i][2]);
			Helper.clearCss(email_in);
			Helper.clearCss(password_in);
		}
	}
	
	/***
	 * logout
	 */
	static String logout = "#header > div.nav > div > div > nav > div:nth-child(2) > a";
	static public void logout() {
		Helper.location("Logout");
		// logout
		Helper.isPresentCss(logout, 5);
		Helper.clickCss(logout);
		Helper.waitCss(login_btn);
		// make sure user was logged out
		Helper.asserts(Helper.getTextCss(login_btn).equals("Sign in"));
	}
}
