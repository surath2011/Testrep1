package keyword.command;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import execution.startup.StartupManager;

public class SwitchToFrame 
{

	public String[] switchToAnotherFrame(String[] stepDetails, WebDriver driver, String[] result)
	{

		if (stepDetails[2].length() != 0)
		{
			try 
			{
				driver.switchTo().frame(driver.findElement(By.name(stepDetails[2])));
			} 
			catch (Exception e) 
			{
				System.out.println("2nd Search Attempt handling Message Box");
				e.printStackTrace();
				try
				{
					driver.findElement(By.xpath("//*[contains(@id,'messagebox')]//button[.='OK']")).click();
					driver.findElement(By.id("searchText-inputEl")).sendKeys(StartupManager.globalInfo[2]);
					driver.findElement(By.id("searchBtn-btnEl")).click();
					driver.switchTo().frame(driver.findElement(By.name(stepDetails[2])));
				}
				catch(Exception ex)
				{
					System.out.println("2nd Search Attempt");
					ex.printStackTrace();
					try
					{
						driver.findElement(By.id("searchText-inputEl")).sendKeys(StartupManager.globalInfo[2]);
						driver.findElement(By.id("searchBtn-btnEl")).click();
						driver.switchTo().frame(driver.findElement(By.name(stepDetails[2])));
					}
					catch(Exception exp)
					{
						System.out.println("Frame Not Found");
						exp.printStackTrace();
						result [0] = "Fail";
						result [1] = "Frame not found";
					}
				}
			}
		} 
		else 
		{
			result [0] = "Fail";
			result [1] = "Frame name is missing"; 
		}

		return result;

	}

}
