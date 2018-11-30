package repos;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utility.configreader;

public class testselchr {
	@Test
	public void testchrome(){
		configreader c= new configreader();
		System.setProperty("webdriver.chrome.driver", c.getchromepath());
		WebDriver driver= new ChromeDriver();
		driver.get(c.geturl());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.quit();
	}

}
