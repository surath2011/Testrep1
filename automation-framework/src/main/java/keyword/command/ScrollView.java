package keyword.command;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollView 
{

	public String[] scrollElementintoView(String[] stepDetails, WebDriver driver, String[] result)
	{
		
		WebElement element;
		JavascriptExecutor jex = (JavascriptExecutor) driver;
		
		if ("id".equalsIgnoreCase(stepDetails[1]))
		{
			try 
			{
			    element = driver.findElement(By.id(stepDetails[2]));
			    jex.executeScript("arguments[0].scrollIntoView(true);", element);
			} 
			catch (Exception e) 
			{
			    result[0] = "false";
			    result[1] = e.toString();
			    e.printStackTrace();
			}
		} 
		else if ("name".equalsIgnoreCase(stepDetails[1]))
		{
			try 
			{
		    	element = driver.findElement(By.name(stepDetails[2]));
		    	jex.executeScript("arguments[0].scrollIntoView(true);", element);
		    } 
			catch (Exception e) 
			{
		    	result[0] = "false";
		    	result[1] = e.toString();
		    	e.printStackTrace();
		    }
		} 
		else if ("cssSelector".equalsIgnoreCase(stepDetails[1]))
		{
			try 
			{
		    	element = driver.findElement(By.cssSelector(stepDetails[2]));
		    	jex.executeScript("arguments[0].scrollIntoView(true);", element);
		    } 
			catch (Exception e) {
		    	result[0] = "false";
		    	result[1] = e.toString();
		    	e.printStackTrace();
		    }
		} 
		else if ("xpath".equalsIgnoreCase(stepDetails[1]))
		{
			try {
		    		element = driver.findElement(By.xpath(stepDetails[2]));
		    		jex.executeScript("arguments[0].scrollIntoView(true);", element);
		    	} 
			catch (Exception e) 
			{
		    	result[0] = "false";
		    	result[1] = e.toString();
		    	e.printStackTrace();
		    }
		} 
		else if ("className".equalsIgnoreCase(stepDetails[1]))
		{
			try {
		    		element = driver.findElement(By.className(stepDetails[2]));
		    		jex.executeScript("arguments[0].scrollIntoView(true);", element);
		    } 
			catch (Exception e) 
			{
		    	result[0] = "false";
		    	result[1] = e.toString();
		    	e.printStackTrace();
		    }
		} 
		else if ("linkText".equalsIgnoreCase(stepDetails[1]))
		{
			try {
		    		element = driver.findElement(By.linkText(stepDetails[2]));
		    		jex.executeScript("arguments[0].scrollIntoView(true);", element);
		    } 
			catch (Exception e) 
			{
		    	result[0] = "false";
		    	result[1] = e.toString();
		    	e.printStackTrace();
		    }
		} 
		else if ("partialLinkText".equalsIgnoreCase(stepDetails[1]))
		{
			try {
		    		element = driver.findElement(By.partialLinkText(stepDetails[2]));
		    		jex.executeScript("arguments[0].scrollIntoView(true);", element);
		    } 
			catch (Exception e) 
			{
		    	result[0] = "false";
		    	result[1] = e.toString();
		    	e.printStackTrace();
		    }
		} 
		else if ("tagName".equalsIgnoreCase(stepDetails[1]))
		{
			try {
		    		element = driver.findElement(By.tagName(stepDetails[2]));
		    		jex.executeScript("arguments[0].scrollIntoView(true);", element);
		    } 
			catch (Exception e) 
			{
		    	result[0] = "false";
		    	result[1] = e.toString();
		    	e.printStackTrace();
		    }
		} 
		else 
		{
			result[0] = "false";
	    	result[1] = "";
		}
		
		return result;
		
	}
}
