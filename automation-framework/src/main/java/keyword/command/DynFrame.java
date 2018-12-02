package keyword.command;

import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;

public class DynFrame {
	public String[] switchToAnotherDynFrame(String[] stepDetails, WebDriver driver, String[] result){
		if (stepDetails[2].length() != 0){
			try {
				driver.switchTo().frame(1);
			} catch (NoSuchFrameException e) {
				result [0] = "Fail";
				result [1] = "Frame not found";
			}
		} else {
			result [0] = "Fail";
			result [1] = "Frame name is missing";
		}
		return result;

	}

	
	}
