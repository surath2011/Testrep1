package capscreen;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import utility.capscr;
//@Listeners(capscreen.TestNGListerner.class)
public class fbscreen {
	WebDriver driver;
	@Test(groups="login")
	public void capfb(){
		System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("file:///C:/09.03.17/Jenkins/fram.html");
		capscr.cappic(driver, "started");
		driver.findElement(By.xpath("//input[@name='unamee']")).sendKeys("ABCDEF");
		
	}
	@AfterMethod
	public void teardown(ITestResult result){
		if(ITestResult.FAILURE==result.getStatus()){
			capscr.cappic(driver, result.getName());
		}
		driver.quit();
	}

}
