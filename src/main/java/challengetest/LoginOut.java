package challengetest;

import helper.H;

public class LoginOut {
	static final String USERNAME = "piningunin@gmail.com";
	static final String PASSWORD = "h3110moto";
	
	static final String login_btn = "#header > div.nav > div > div > nav > div.header_user_info";
	
	static final String email_in = "#email";
	static final String password_in = "#passwd";
	static final String sign_in_btn = "#SubmitLogin > span";
	
	static public void login() {
		H.location("Login");
		login(USERNAME,PASSWORD);
	}
	static public void login(String user, String pass) {
		H.location("Login");
		H.waitCss(login_btn);
		H.clickCss(login_btn);
		
		H.sendKeysbyCSS(email_in, user);
		H.sendKeysbyCSS(password_in, pass);
		H.clickCss(sign_in_btn);
	}
	
	static String login_error_message = "#center_column > div.alert.alert-danger > ol > li";

	static String [][] invalid_credentials = {
		{"pinin","ij","Invalid email address."}
		,{"pin",PASSWORD,"Invalid email address."}
		,{USERNAME,"52","Invalid password."}
		,{USERNAME,"545454ffrfrf","Authentication failed."}
	};
	static public void loginInvalid() {
		H.location("Login invalid");
		H.waitCss(login_btn);
		H.clickCss(login_btn);
		H.waitCss(email_in);
		
		for (int i = 0; i < invalid_credentials.length; ++ i) {
			H.sendKeysbyCSS(email_in, invalid_credentials[i][0]);
			H.sendKeysbyCSS(password_in, invalid_credentials[i][1]);
			H.clickCss(sign_in_btn);
			H.waitCss(login_error_message);
			H.ass(H.getTextCss(login_error_message), invalid_credentials[i][2]);
			H.clearCss(email_in);
			H.clearCss(password_in);
		}
	}
	
	static String logout = "#header > div.nav > div > div > nav > div:nth-child(2) > a";
	static public void logout() {
		H.location("Logout");
		H.isPresentCss(logout, 5);
		H.clickCss(logout);
		H.waitCss(login_btn);
		H.ass(H.getTextCss(login_btn).equals("Sign in"));
	}
}
