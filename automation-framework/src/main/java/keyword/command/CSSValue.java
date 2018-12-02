package keyword.command;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import execution.startup.StartupManager;

public class CSSValue {

public static String[] verify (String[] stepDetails, WebDriver driver, String[] result) {
		
		if ("xpath".equalsIgnoreCase(stepDetails[1])){
			String[] tempString = stepDetails[2].split(":");
			String cssValue = driver.findElement(By.xpath(tempString[0].trim())).getCssValue(tempString[1].trim());
		System.out.println(cssValue);
			if(!(stepDetails[3]).equalsIgnoreCase(cssValue)) {
				result[0]="Fail";
				result[1]="The resultant color is not the required color";
				
			}
			
		
		} else if ("id".equalsIgnoreCase(stepDetails[1])){
			String[] tempString = stepDetails[2].split(":");
			String cssValue = driver.findElement(By.xpath(tempString[0].trim())).getCssValue(tempString[1].trim());
	//		System.out.println(cssValue);
			if(cssValue.contains(stepDetails[3])) {
//				result[0]="Pass";
				
			}
	
		} else {
			result [0] = "Fail";
			result [1] = stepDetails[1] + " - Doesn't support by Framework";
		}
		
		return result;
	
	}


}
