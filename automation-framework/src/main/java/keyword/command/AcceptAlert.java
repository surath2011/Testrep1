package keyword.command;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;

public class AcceptAlert {
	public String[] acceptAlert(String[] stepDetails, WebDriver driver, String[] result){
		
		try{
			 Alert alert = driver.switchTo().alert();
			 alert.accept();
		}
		catch (NoAlertPresentException f){
			 System.out.println("No popup found");
//			 f.printStackTrace();
		 }
		
		return result;
	}

		
}