package keyword.command;

import org.openqa.selenium.WebDriver;

public class SwitchWindow {
	
	public String[] switchToNewWindow(String[] stepDetails, WebDriver driver, String[] result)
	{
		
		for(String winHandle : driver.getWindowHandles())
		{
		    driver.switchTo().window(winHandle);
//		    NoSuchWindowException - If the window cannot be found
		}
		
		return result;
	}

}
