package keyword.command;

import org.openqa.selenium.WebDriver;

public class SwitchBackFromWindow {

	public String[] switchToDefaultWindow (String[] stepDetails, WebDriver driver, String[] result, String winHandleBefore)
	{
		
		driver.switchTo().window(winHandleBefore);
//		Throws:NoSuchWindowException - If the window cannot be found

		return result;
	}
	
}
