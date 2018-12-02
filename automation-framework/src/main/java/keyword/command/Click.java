package keyword.command;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class Click {

	public String[] operationClick (String[] stepDetails, WebDriver driver, String[] result){
		

		if ("id".equalsIgnoreCase(stepDetails[1])){
			driver.findElement(By.id(stepDetails[2])).click();
		} else if ("name".equalsIgnoreCase(stepDetails[1])){
				driver.findElement(By.name(stepDetails[2])).click();
		} else if ("cssSelector".equalsIgnoreCase(stepDetails[1])){
		    driver.findElement(By.cssSelector(stepDetails[2])).click();
		} else if ("xpath".equalsIgnoreCase(stepDetails[1])){
		    driver.findElement(By.xpath(stepDetails[2])).click();
		} else if ("linkText".equalsIgnoreCase(stepDetails[1])){
		    driver.findElement(By.linkText(stepDetails[2])).click();
		} else {
			result [0] = "Fail";
			result [1] = stepDetails[1] + " - Doesn't support by Framework";
		}
		return result;
	}
}
