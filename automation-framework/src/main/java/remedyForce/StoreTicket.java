package remedyForce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import execution.startup.StartupManager;

public class StoreTicket {
	public String[] store (String[] stepDetails, WebDriver driver, String[] result)
	{

		if ("xpath".equalsIgnoreCase(stepDetails[1]))
		{
			String storedText = driver.findElement(By.xpath(stepDetails[2])).getText();
			result [2] = stepDetails[0] + storedText;
			System.out.println(stepDetails[0] + storedText);
			String substring = storedText.substring(Math.max(storedText.length() - 8, 0));

			if ("1".equalsIgnoreCase(stepDetails[3]))
			{
				StartupManager.globalInfo [0] = substring;
			}

			else if("2".equalsIgnoreCase(stepDetails[3]))
			{
				StartupManager.globalInfo [1] = substring;
			}
		} 
		else if ("id".equalsIgnoreCase(stepDetails[1]))
		{
			String storedText = driver.findElement(By.id(stepDetails[2])).getText();
			result [2] = stepDetails[0] + storedText;
			System.out.println(stepDetails[0] + storedText);
			String substring = storedText.substring(Math.max(storedText.length() - 8, 0));

			if ("1".equalsIgnoreCase(stepDetails[3]))
			{
				StartupManager.globalInfo [0] = substring;
			}
			else if("2".equalsIgnoreCase(stepDetails[3]))
			{
				StartupManager.globalInfo [1] = substring;
			}
		} 
		else 
		{
			result [0] = "Fail";
			result [1] = stepDetails[1] + " - Doesn't support by Framework";
		}

		return result;

	}
}
