package keyword.command;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Attribute {
public static String[] getValue (String[] stepDetails, WebDriver driver, String[] result) {
	try {
		if ("xpath".equalsIgnoreCase(stepDetails[1])){
			String[] tempString = stepDetails[2].split(":");
			String value = driver.findElement(By.xpath(tempString[0])).getAttribute(tempString[1]);
			//System.out.println(value);
			if(!(stepDetails[3]).contains(value)) {
				result[0]="Fail";
				result[1]="The desired attribute is not present";
			}
			
		
		} else if ("id".equalsIgnoreCase(stepDetails[1])){
			String[] tempString = stepDetails[2].split(":");
			String value = driver.findElement(By.xpath(tempString[0].trim())).getCssValue(tempString[1].trim());
		//	System.out.println(value);
			if(!(stepDetails[3]).contains(value)) {
				result[0]="Fail";
				result[1]="The desired attribute is not present";
			}
	
		} else {
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
