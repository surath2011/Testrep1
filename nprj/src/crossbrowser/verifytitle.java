package crossbrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class verifytitle {
	WebDriver driver;
	
	@Test
	@Parameters("browser")
	public void verifypagetitle(String browsername){
		if(browsername.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
			driver= new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.get("file:///C:/09.03.17/Jenkins/fram.html");
		System.out.println(driver.getTitle());
		driver.quit();
	}
}
