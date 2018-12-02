package keyword.command;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import execution.startup.StartupManager;

public class Type {

	public String[] input (String[] stepDetails, WebDriver driver, String[] result)
	{
		StartupManager.globalInfo[2] = stepDetails[3];
		
		if ("id".equalsIgnoreCase(stepDetails[1])){
			driver.findElement(By.id(stepDetails[2])).clear();
		    driver.findElement(By.id(stepDetails[2])).sendKeys(stepDetails[3]);
		} else if ("name".equalsIgnoreCase(stepDetails[1])){
			driver.findElement(By.name(stepDetails[2])).clear();
		    driver.findElement(By.name(stepDetails[2])).sendKeys(stepDetails[3]);
		} else if ("cssSelector".equalsIgnoreCase(stepDetails[1])){
			driver.findElement(By.cssSelector(stepDetails[2])).clear();
		    driver.findElement(By.cssSelector(stepDetails[2])).sendKeys(stepDetails[3]);
		} else if ("xpath".equalsIgnoreCase(stepDetails[1])){
			driver.findElement(By.xpath(stepDetails[2])).clear();
		    driver.findElement(By.xpath(stepDetails[2])).sendKeys(stepDetails[3]);
		} else {
			result [0] = "Fail";
			result [1] = stepDetails[1] + " - Doesn't support by Framework";
		}
		
		return result;
	}

}
