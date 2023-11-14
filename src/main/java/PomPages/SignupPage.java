package PomPages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.UtilityClass1;

public class SignupPage extends UtilityClass1 {
	
	WebDriver driver;
	
	@FindBy(xpath="//img[@alt='neostox Logo']")
	private WebElement neostoxLogo;
	
	@FindBy(xpath = "//input[@id='MainContent_signinsignup_txt_mobilenumber']")
	private WebElement entermobilenumber;
	
	@FindBy(css = "#lnk_signup1")
	private WebElement signUpbtn;
	
	@FindBy(xpath ="//input[@id='txt_otp']")
	private WebElement enterpassword ;
	
	@FindBy(xpath ="//a[@id='lnk_submitotp']")
	private WebElement submit ;
	
	
	
	public SignupPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
           	this.driver = driver;
	  }
	
	public boolean neostoxlogo() {
		UtilityClass1.waitTillElementPresent(driver,By.xpath("//img[@alt='neostox Logo']"));
		return neostoxLogo.isDisplayed();
	}


	public void enternumber() throws IOException {
		driver.switchTo().frame(1);
		UtilityClass1.waitTillElementPresent(driver,By.xpath("//input[@id='MainContent_signinsignup_txt_mobilenumber']"));
		String mobileNumber = getDataFromConfigFile("mobailnumber");
	    
	    // Check if mobileNumber is not null and not empty before sending it
	    if (mobileNumber != null && !mobileNumber.isEmpty()) {
	        entermobilenumber.sendKeys(mobileNumber);
	    } else {
	        // Handle the case where mobileNumber is null or empty
	        // You can log an error or take other appropriate actions
	    }

	}
	public void clicksinup() {
		signUpbtn.click();
	}
	public void enterpassword() throws IOException  {
		UtilityClass1.waitTillElementPresent(driver,By.xpath("//input[@id='txt_otp']"));
		String password = getDataFromConfigFile("password");
	  
	    if (password != null && !password.isEmpty()) {
	        entermobilenumber.sendKeys(password);
	    } else {
	       
	      }
	   }
	
	
	 public void submit() {
		 driver.switchTo().frame(1);
		 UtilityClass1.waitTillElementPresent(driver,By.xpath("//a[@id='lnk_submitotp']"));
	    	submit.click();
		}
}
