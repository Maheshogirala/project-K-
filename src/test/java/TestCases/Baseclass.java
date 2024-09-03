package TestCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Baseclass {
    public static WebDriver dr;
    @BeforeSuite
	public void url() {
		dr= new ChromeDriver();
		dr.get("https://store.kalgudi.com/");
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
    @AfterSuite
	public void logout() {
		dr.close();
	}
	
	
    public String screenshot(String testname) throws IOException {
    	// Create time stamp
    	String timestamp= new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
    	// implement the take screen shot method
    	TakesScreenshot ts = (TakesScreenshot)dr;
    	// take the screen shot and save in source file
    	File source = ts.getScreenshotAs(OutputType.FILE);
    	// create the destination where you want to save screen shot
    	String destination = System.getProperty("user.dir")+"/ScreenShots/"+timestamp+testname+"k1.png";
    	// move the source file into destination file
    	try {
    	FileUtils.copyFile(source, new File(destination));
    	}catch(Exception e) {
    		e.getMessage();
    	}
    	return destination;
    	
    }
    
	
	
}
