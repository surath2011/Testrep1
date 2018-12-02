package keyword.command;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class after {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=null;
		System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.cadence.com/");
		
		Thread.sleep(10000);
		
		WebElement element = driver.findElement(By.xpath("//*[@id='cdn-nxtgn-dd']/a[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",element);

//String script = "return window.getComputedStyle(document.querySelector('#cdn-nxtgn-footer #footer-nexgen-submenu.footer-media .container ul.primary-nav-standard li a'),'::after').getPropertyValue('content')";

String script = "return window.getComputedStyle($x(\"//*[@id='cdn-nxtgn-dd']/a[1]\")[0],'::after').getPropertyValue('content')";

JavascriptExecutor js = (JavascriptExecutor)driver;
String content = (String) js.executeScript(script);
System.out.println(content);

	}

}
