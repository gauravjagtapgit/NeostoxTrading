package Test;

import static org.testng.Assert.assertNotNull;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Base.BaseClass;
import PomPages.SignupPage;
import Utility.UtilityClass1;


public class SinupPageTest extends BaseClass {
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	
	SignupPage sign;
	SoftAssert softAssert = new SoftAssert();
	public SinupPageTest() {
		super();
	}
	@BeforeMethod
	//@Parameters("chrome")
	public void setup(@Optional("chrome")String browser) throws IOException {
		driver =  BaseClass.getdriver(browser);
	 htmlReporter=new ExtentHtmlReporter("ExtentReporter.html");
	 reports = new ExtentReports();
	 reports.attachReporter(htmlReporter);
	 reports.createTest("SinupPageTest");
		
		
		sign = new SignupPage(driver);
	}
	@Test(priority = 1)
	public void verifyLogo() {
		boolean flag =sign.neostoxlogo();
		softAssert.assertTrue(flag);
		softAssert.assertAll();
		 Reporter.log("verifyLogo test case is pass",true);
		}
	
	@Test(priority = 2)
	public void verifyenterfiled() throws IOException {
	    try {
	        sign.enternumber();
	        sign.clicksinup();
	        // Assertions and verifications go here
	        softAssert.assertTrue(true);
	        softAssert.assertAll();
	        Reporter.log("verifyenterfiled test case is pass", true);
	    } catch (Exception e) {
	        // Handle exceptions
	        Reporter.log("verifyenterfiled test case failed: " + e.getMessage(), true);
	        softAssert.fail("verifyenterfiled test case failed: " + e.getMessage());
	    }
	}
	
	@Test(priority = 3)
	public void verifypassword() throws IOException  {
		sign.enterpassword();
	     sign.submit();
	     Assert.assertTrue(true);
        Reporter.log("verifypassword test case is pass",true);
    }
	
	
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		
		if(result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName() +" is Passed");
		}
		
		
		
		else if(result.getStatus() == ITestResult.FAILURE)
		{
			String path = UtilityClass1.getScreenShotPath(driver, result.getName());
			
			test.log(Status.FAIL, result.getName() +" is Failed", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
		
		else if(result.getStatus() == ITestResult.SKIP){
			
			test.log(Status.FAIL, result.getName() +" is Skipped");
		}
	}
	
	@AfterClass
	public void afterClass() {
		
		reports.flush();
	
	}
	
//	@AfterMethod
//	public void teardown() {
//	    if (driver != null) {
//	        driver.quit();
//	    }
//  }
}
