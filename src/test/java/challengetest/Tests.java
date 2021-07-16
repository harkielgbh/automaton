package challengetest;

import org.testng.annotations.Test;

public class Tests {
	
	@Test
	public void testLogin() {
		DriverTest.start();
		LoginOut.login();
	}
	
	@Test
	public void testLogout() {
		LoginOut.logout();
	}

}
