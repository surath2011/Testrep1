package keyword.command;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SwitchToConsoleFrame {

	public String[] switchToDynamicFrame (String[] stepDetails, WebDriver driver, String[] result)
	{
		if("xpath".equalsIgnoreCase(stepDetails[1]))
		{
			try 
			{
				driver.switchTo().frame(driver.findElement(By.xpath(stepDetails[2])));
			} 
			catch (Exception e)
			{
				System.out.println("2nd attempt at clicking ticket number");
				try
				{
					driver.findElement(By.xpath("//td[2]/div/a")).click();
					driver.switchTo().frame(driver.findElement(By.xpath(stepDetails[2])));
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
					result [0] = "Fail";
					result [1] = "Frame not found";
					result [3] = "Ticket/CR tab didn't open as there was no response to click on ticket number.";
				}
			}
		} 
		else 
		{
			result [0] = "Fail";
			result [1] = stepDetails[1] + " - Not supported by Framework";
		}
		return result;
	}
}