package remedyForce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import execution.startup.StartupManager;

public class SearchCR {
public String[] crSearch (String[] stepDetails, WebDriver driver, String[] result){
		
		
	    String runTimeData = StartupManager.globalInfo[1];
	    
		System.out.println(StartupManager.globalInfo[1]);
		// type + click with globalInfo
		
		if ("id".equalsIgnoreCase(stepDetails[1])){
			driver.findElement(By.id(stepDetails[2])).clear();
		    driver.findElement(By.id(stepDetails[2])).sendKeys(runTimeData);
		    } else if ("name".equalsIgnoreCase(stepDetails[1])){
			driver.findElement(By.name(stepDetails[2])).clear();
		    driver.findElement(By.name(stepDetails[2])).sendKeys(runTimeData);
		} else if ("cssSelector".equalsIgnoreCase(stepDetails[1])){
			driver.findElement(By.cssSelector(stepDetails[2])).clear();
		    driver.findElement(By.cssSelector(stepDetails[2])).sendKeys(runTimeData);
		} else if ("xpath".equalsIgnoreCase(stepDetails[1])){
			driver.findElement(By.xpath(stepDetails[2])).clear();
		    driver.findElement(By.xpath(stepDetails[2])).sendKeys(runTimeData);
		} else {
			result [0] = "Fail";
			result [1] = stepDetails[1] + " - Doesn't support by Framework";
		}
		
		return result;
	}

}
