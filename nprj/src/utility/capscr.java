package utility;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class capscr {
	
	public static void cappic(WebDriver driver, String scrname){
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("./screenshots/"+scrname+".png"));
		} catch (Exception e) {
			e.getMessage();
		}
		System.out.println("CAPTURED");
	}
}
