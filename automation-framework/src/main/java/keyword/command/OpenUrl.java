package keyword.command;

import org.openqa.selenium.WebDriver;

public class OpenUrl 
{
	public void openURL(String[] stepDetails, WebDriver driver)
	{
		driver.get(stepDetails[3]);
	}

}
