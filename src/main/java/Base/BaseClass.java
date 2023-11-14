package Base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utility.UtilityClass1;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass  {
	
	public static WebDriver driver;
	
	public static WebDriver getdriver(String browser) throws IOException {
		 
		String browsername=UtilityClass1.getDataFromConfigFile("browser");
		
		if(driver==null) {
			if(browsername.equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				System.setProperty("webdriver chrome driver","C:\\Users\\ADMIN\\eclipse-workspace\\gauav\\driver\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			
			else if(browsername.equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			  }
		  }
		  driver.get(UtilityClass1.getDataFromConfigFile("url"));
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		  
		return driver;
	 }

}
