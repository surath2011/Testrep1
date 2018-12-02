package keyword.command;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JavascriptClick {
public static String[] Click (String[] stepDetails, WebDriver driver, String[] result) {
	try {	
		if ("xpath".equalsIgnoreCase(stepDetails[1]))
			{JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(stepDetails[2])));}
		
		
			
				
			
	
		 else {
			result [0] = "Fail";
			result [1] = stepDetails[1] + " - Doesn't support by Framework";
		}
	}
	
	catch(Exception e)
	{
		e.getMessage();
	}
	
	
		return result;
	
	}

}
