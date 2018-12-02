package keyword.command;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectBox {

	public String[] selectBy(String[] stepDetails, WebDriver driver, String[] result){
		
		FindElement element = new FindElement();
		boolean selectElement = element.verifyElementPresnt(stepDetails, driver);
		
		if (selectElement){
			Select select = null;
			
			if ("name".equalsIgnoreCase(stepDetails[1])) {
				select = new Select(driver.findElement(By.name(stepDetails[2])));
				try {
					select.selectByValue(stepDetails[3]);
				} catch (NoSuchElementException e){
					result [0] = "Fail";
					result [1] = "Element not found - " + stepDetails[1] + " = " + stepDetails[2];
				}
			} else if ("cssSelector".equalsIgnoreCase(stepDetails[1])){
				select = new Select(driver.findElement(By.cssSelector(stepDetails[2])));
				try {
					select.selectByValue(stepDetails[3]);
				} catch (NoSuchElementException e){
					result [0] = "Fail";
					result [1] = "Element not found - " + stepDetails[1] + " = " + stepDetails[2];
				}
			
			} else if ("id".equalsIgnoreCase(stepDetails[1])) {
				select = new Select(driver.findElement(By.id(stepDetails[2])));
				try {
					select.selectByValue(stepDetails[3]);
				} catch (NoSuchElementException e){
					result [0] = "Fail";
					result [1] = "Element not found - " + stepDetails[1] + " = " + stepDetails[2];
				}
			}else {
				result [0] = "Fail";
				result [1] = stepDetails[1] + "Doesn't support by Selenium";
			}
			
		} else {
			result [0] = "Fail";
			result [1] = "Element not found - " + stepDetails[1] + " = " + stepDetails[2];
		}
		
		return result;
	}
}
