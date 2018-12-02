package keyword.command;

import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;

public class SwitchBackFromFrame {

	public String[] switchToDefaultFrame (String[] stepDetails, WebDriver driver, String[] result){

		try 
		{
			driver.switchTo().defaultContent();
		} 
		catch (NoSuchFrameException e) 
		{
			result [0] = "Fail";
			result [1] = "Default frame not found";
		}

		return result;

	}






}
