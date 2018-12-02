package keyword.command;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import execution.startup.StartupManager;

public class StoreText {
	public String[] store (String[] stepDetails, WebDriver driver, String[] result){
		
//		String[] result = new String[3];
//		result [0] = "Pass";
//		result [1] = "";
//		result [2] = "";
		
		if ("xpath".equalsIgnoreCase(stepDetails[1])){
		String storedText = driver.findElement(By.xpath(stepDetails[2])).getText();
		result [2] = stepDetails[0] + storedText;
		System.out.println(stepDetails[0] + storedText);
		String substring = storedText.substring(Math.max(storedText.length() - 8, 0));
		
			if ("1".equalsIgnoreCase(stepDetails[3])){
				StartupManager.globalInfo [0] = substring;
			}
		
		} else if ("id".equalsIgnoreCase(stepDetails[1])){
			String storedText = driver.findElement(By.id(stepDetails[2])).getText();
			result [2] = stepDetails[0] + storedText;
			System.out.println(stepDetails[0] + storedText);
			String substring = storedText.substring(Math.max(storedText.length() - 8, 0));
			
			if ("1".equalsIgnoreCase(stepDetails[3])){
				StartupManager.globalInfo [0] = substring;
			}
			
		} else {
			result [0] = "Fail";
			result [1] = stepDetails[1] + " - Doesn't support by Framework";
		}
		
		
		return result;
	
	}
}
