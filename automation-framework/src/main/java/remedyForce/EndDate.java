package remedyForce;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EndDate {
	public String[] End_Date_Time (String[] stepDetails, WebDriver driver, String[] result){ 
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
	     //get current date time with Calendar()
	     Calendar cal = Calendar.getInstance();
	     //System.out.println(dateFormat.format(cal.getTime()));
	     cal.add(Calendar.HOUR, 12);
	     cal.add(Calendar.MINUTE, 55);
	     System.out.println(dateFormat.format(cal.getTime()));
	     String date_time = (dateFormat.format(cal.getTime()));
	     
	     if ("id".equalsIgnoreCase(stepDetails[1])){
				driver.findElement(By.id(stepDetails[2])).clear();
			    driver.findElement(By.id(stepDetails[2])).sendKeys(date_time);
			    
	     } else {
				result [0] = "Fail";
				result [1] = stepDetails[1] + " - Doesn't support by Framework";
	     } 
	     return result;

	}
}
