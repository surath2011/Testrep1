package pagemodel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class loginpage {
	WebDriver driver;
	public loginpage(WebDriver driver){
		this.driver=driver;
	}
	By username= By.name("uname");
	By password= By.name("pass");
	By btn= By.id("btt");
	
	public void typeuser(String unn){
		driver.findElement(username).sendKeys(unn);
	}
	public void typepass(String pss){
		driver.findElement(password).sendKeys(pss);
	}
	public void clickgo(){
		driver.findElement(btn).click();;
	}
}
