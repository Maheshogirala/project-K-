package TestCases;




import java.io.IOException;

import org.testng.annotations.Test;

import PageObjects.Login;


public class TC1_Login extends Baseclass{
	
	@Test(priority=1)
	public void TC_Login() throws InterruptedException, IOException {
		Login lp= new Login(dr);
		
		lp.loginbutton();
		lp.Entermobilenumber("");
		lp.getotp();
		screenshot("TC_Login");
		
	}
	

}
