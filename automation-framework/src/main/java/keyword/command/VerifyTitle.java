package keyword.command;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class VerifyTitle {

	public String[] verifyPageTitle (String[] stepDetails, WebDriver driver, String[] result){
		

		if (driver.getTitle().equalsIgnoreCase(stepDetails[3])){
			
//			System.out.println(driver.getTitle());
//			do nothing
		} else {
			result [0] = "Fail";
			result [1] = stepDetails[3] + " - Title missmatch";
		}
		return result;
	}
}
