package keyword.command;

import org.openqa.selenium.WebDriver;

public class CloseWindow {
	
	public String[] closeCurrentWindow(WebDriver driver, String[] result){
		
		driver.close();
//		Exception
		return result;
	}

}
