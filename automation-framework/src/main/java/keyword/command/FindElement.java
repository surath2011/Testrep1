package keyword.command;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FindElement {

	public boolean verifyElementPresnt(String[] stepDetails, WebDriver driver){

		boolean elementFound = true;
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		if ("id".equalsIgnoreCase(stepDetails[1]))
		{
			try {
				driver.findElement(By.id(stepDetails[2]));
			} 
			catch (Exception e) 
			{
				elementFound = false;
				e.printStackTrace();
			}
		} else if ("name".equalsIgnoreCase(stepDetails[1])){
			try {
				driver.findElement(By.name(stepDetails[2]));
			} catch (Exception e) 
			{
				elementFound = false;
				e.printStackTrace();
			}
		} else if ("cssSelector".equalsIgnoreCase(stepDetails[1])){
			try {
				driver.findElement(By.cssSelector(stepDetails[2]));
			} catch (Exception e) 
			{
				elementFound = false;
				e.printStackTrace();
			}
		} else if ("xpath".equalsIgnoreCase(stepDetails[1])){
			try {
				driver.findElement(By.xpath(stepDetails[2]));
			} catch (Exception e) 
			{
				elementFound = false;
				e.printStackTrace();
			}
		} else if ("className".equalsIgnoreCase(stepDetails[1])){
			try {
				driver.findElement(By.className(stepDetails[2]));
			} catch (Exception e) 
			{
				elementFound = false;
				e.printStackTrace();
			}
		} else if ("linkText".equalsIgnoreCase(stepDetails[1])){
			try {
				driver.findElement(By.linkText(stepDetails[2]));
			} catch (Exception e) 
			{
				elementFound = false;
				e.printStackTrace();
			}
		} else if ("partialLinkText".equalsIgnoreCase(stepDetails[1])){
			try {
				driver.findElement(By.partialLinkText(stepDetails[2]));
			} catch (Exception e) 
			{
				elementFound = false;
				e.printStackTrace();
			}
		} else if ("tagName".equalsIgnoreCase(stepDetails[1])){
			try {
				driver.findElement(By.tagName(stepDetails[2]));
			} catch (Exception e) 
			{
				elementFound = false;
				e.printStackTrace();
			}
		} else 
		{
			elementFound = false;
		}

		return elementFound;

	}
	
}
