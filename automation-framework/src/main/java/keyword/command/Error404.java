package keyword.command;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Error404 {
	public static String[] httpCode (String[] stepDetails, WebDriver driver, String[] result) throws IOException {
		// TODO Auto-generated method stub
		try {
		String url1=driver.findElement(By.xpath(stepDetails[2])).getAttribute("href");
	//	System.out.println(url1);
			URL url = new URL(url1);
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			int code = connection.getResponseCode();

	//		System.out.println(code);
			if(code==404)
			{
				result[0]="Fail";
	}
			
		}
		catch(Exception e)
		{
			result [0] = "Fail";
			result [1] = stepDetails[1] + " - Doesn't support by Framework";
			
		}
		return result;}
}