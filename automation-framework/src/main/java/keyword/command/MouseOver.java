package keyword.command;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseOver {
	
	public static String[] perform (String[] stepDetails, String[] result, WebDriver driver) {
		
		try {
			WebElement element = driver.findElement(By.xpath(stepDetails[2]));		 
		    Actions action = new Actions(driver);
		    action.moveToElement(element).build().perform();
		} catch  (Exception e) {
			result [0] = "Fail";
			result [1] = stepDetails[1] + " - Not able to perform MouseOver";
			result [2] = e.toString();
		}
		return result;
	}

}
