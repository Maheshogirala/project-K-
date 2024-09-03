package TestCases;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import PageObjects.Login;


public class TC2_OTPV extends Baseclass {
	
	public WebDriver dr;
	@Test(priority=2)
	public void enterotp() {
		Login lp=new Login(dr);
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter otp");
		String otp = sc.nextLine();
		
		lp.Enter_otp(otp);
		lp.finallogin();
		
	}

}
