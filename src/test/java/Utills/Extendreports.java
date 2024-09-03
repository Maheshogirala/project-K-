package Utills;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Testcases.Baseclass;

public class Extendreports implements ITestListener {
   // 1) implement the ITestlistener interface 
   // 2) defined the variables 
	public ExtentSparkReporter sp;
	public ExtentReports reports;
	public ExtentTest test;
	
	//implement the method from itestlistener
	public void onStart(ITestContext context) {
	    // set the path where you want to save the extent reports
		sp= new ExtentSparkReporter(System.getProperty("user.dir")+"/extendreport/"+"E2.html");
		// set the title of document
		sp.config().setDocumentTitle("QA_Test Report");
		// set the report name
		sp.config().setReportName("QA_Regrustion Report");
		// set the theme of the report 
		sp.config().setTheme(Theme.STANDARD);
		
		// using the reports we can set the common values
		// create defind the class
		reports = new ExtentReports();
		// attach the spark reporter into reports
		reports.attachReporter(sp);
		//set the common values system info 
		reports.setSystemInfo("TesterName", "mahesh");
		reports.setSystemInfo("Testsuite", "regrustion");
	  }
	
	
	public void onTestSuccess(ITestResult result) {
	    test= reports.createTest(result.getName());
	    test.log(Status.PASS, "Test is pass");
				
	  }
	
	
	public void onTestFailure(ITestResult result) {
      test= reports.createTest(result.getName());
      test.log(Status.FAIL, "Test is Fail"+result.getName());
      try{
      String imagepath= new Baseclass().screenshot(result.getTestName());
     
      test.addScreenCaptureFromPath(imagepath);
      }catch(Exception e) {
    	  e.getStackTrace();
      }

		
	  }
	
	public void onTestSkipped(ITestResult result) {

        test=reports.createTest(result.getName());
        test.log(Status.SKIP, "test ws skipped");
	  }
	
	 public void onFinish(ITestContext context) {

          reports.flush();
		  }
	
	
	
}
