package pagemodel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class logintest {
	@Test(groups={"login"})
	public void logintestcase() {
	System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("file:///C:/09.03.17/Jenkins/fram.html");
	loginpage lp= new loginpage(driver);
	lp.typeuser("surath");
	lp.typepass("12345");
	lp.clickgo();
	System.out.println(driver.getTitle());
	driver.quit();
	}
	@Test(groups="broken")
	public void display(){
		System.out.println("this is broken");
	}
}
