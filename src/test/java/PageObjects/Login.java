package PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
   public static  WebDriver dr;
	public Login(WebDriver dr) {
		this.dr=dr;
		
		PageFactory.initElements(dr, this);
	}
	@FindBy (xpath="//span[text()='Login']")
	WebElement login;
	
	@FindBy(xpath="(//input[@ placeholder='Mobile numbe'])[1]")
	WebElement mobile;
	
	@FindBy(xpath="//span[text()=' Login with OTP ']")
	WebElement getotp;
	
	@FindBy(xpath="//input[@ id='login-password-input']")
	WebElement enterotp;
	
	@FindBy(xpath="//span[text()='Login']")
	WebElement finallogin;
	
	public void loginbutton() {
		login.click();
	}
	
	public void Entermobilenumber(String mobilenumber) {
		mobile.sendKeys(mobilenumber);
	}
	
	public void getotp() {
		getotp.click();
	}
	
	public void Enter_otp(String eotp) {
		enterotp.sendKeys(eotp);
	}
	
	public void finallogin() {
		finallogin.click();
	}
	
}
