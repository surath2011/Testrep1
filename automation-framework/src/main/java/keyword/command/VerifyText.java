package keyword.command;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VerifyText {
	
	public String[] verifySearchText(String[] stepDetails, WebDriver driver, String[] result){
		
//		String found;
//		String[] result = new String[2];
//		result [0] = "Pass";
//		result [1] = "";
		
		
		if ("id".equalsIgnoreCase(stepDetails[1])){
			if (!stepDetails[3].equalsIgnoreCase(driver.findElement(By.id(stepDetails[2])).getText())){
				result [0] = "Fail";
				result [1] = stepDetails[3] + " - not found";
			}
		} else if ("name".equalsIgnoreCase(stepDetails[1])){
			if (!stepDetails[3].equalsIgnoreCase(driver.findElement(By.name(stepDetails[2])).getText())){
				result [0] = "Fail";
				result [1] = stepDetails[3] + " - not found";
			}
		} else if ("cssSelector".equalsIgnoreCase(stepDetails[1])){
			if (!stepDetails[3].equalsIgnoreCase(driver.findElement(By.cssSelector(stepDetails[2])).getText()) && 
					!(driver.findElement(By.cssSelector(stepDetails[2])).getText()).contains(stepDetails[3])){
				result [0] = "Fail";
				result [1] = stepDetails[3] + " - not found";
			}
		} else if ("xpath".equalsIgnoreCase(stepDetails[1])){
			if (!stepDetails[3].equalsIgnoreCase(driver.findElement(By.xpath(stepDetails[2])).getText()) && 
					!(driver.findElement(By.xpath(stepDetails[2])).getText()).contains(stepDetails[3])){
				result [0] = "Fail";
				result [1] = stepDetails[3] + " - not found";
			}
		} else if ("linkText".equalsIgnoreCase(stepDetails[1])){
			if (!stepDetails[3].equalsIgnoreCase(driver.findElement(By.linkText(stepDetails[2])).getText())){
				result [0] = "Fail";
				result [1] = stepDetails[3] + " - not found";
			}
		} else {
			result [0] = "Fail";
			result [1] = stepDetails[1] + " - Doesn't support by Framework";
		}
		
		return result;
		
	}

}
