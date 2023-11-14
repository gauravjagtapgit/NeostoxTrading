package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class UtilityClass1 {
	
	public static Properties prop;
	public static String getDataFromConfigFile(String key) throws IOException {
		
		FileInputStream file = new FileInputStream("C:\\Users\\ADMIN\\eclipse-workspace\\gauav\\NeostoxTrading\\configration\\properties");
		
	       prop =new Properties();
	       
	       prop.load(file);
	       
	       return prop.getProperty(key);
		
	}
	
	public static void waitTillElementPresent(WebDriver driver, By element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	public static void waitTillVisablityLocated(WebDriver driver, WebElement element) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    wait.until(ExpectedConditions.visibilityOf(element));
	    Reporter.log("waitTillElementPresent method is pass", true);
	}
	 
	
	
	public static String getScreenShotPath(WebDriver driver, String methodName) throws IOException {
		
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String path = methodName +".png";
		
		File dest = new File(path);
		
		FileHandler.copy(source, dest);
		
		return path;
		
	}
	

}
