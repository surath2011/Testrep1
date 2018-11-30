package iframedemo;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class demowait {
@Test
public void dwait(){
	System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("file:///C:/09.03.17/Jenkins/waitpage.html");
	driver.findElement(By.id("btn")).click();
	Wait<WebDriver> wait= new FluentWait<WebDriver>(driver)
			.withTimeout(30, TimeUnit.SECONDS)
			.pollingEvery(250, TimeUnit.MILLISECONDS)
			.ignoring(NoSuchElementException.class);
	WebElement elem= wait.until(new Function<WebDriver, WebElement>(){
		public WebElement apply(WebDriver driver){
			WebElement ele=driver.findElement(By.xpath("html/body/p"));
			String value=ele.getAttribute("innerHTML");
			if(value.equalsIgnoreCase("WebDriver")){
				return ele;
			}
			else{
				System.out.println(value);
				return null;
			}
			
		}
	});
	System.out.println(elem.isDisplayed());
	driver.close();

}
}
