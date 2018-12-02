package keyword.command;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import execution.startup.StartupManager;

public class Webdriverwait {

	WebDriverWait wait;

	public String[] waitForElement(String[] stepDetails, WebDriver driver)
	{

		wait = new WebDriverWait(driver, 120);
		String[] elementFound = new String[2];
		elementFound[0] = "true";
		elementFound[1] = "";

		if ("id".equalsIgnoreCase(stepDetails[1]))
		{
			if("clickable".equalsIgnoreCase(stepDetails[3]))
			{	
				try
				{
					wait.until(ExpectedConditions.elementToBeClickable(By.id(stepDetails[2])));
				} 
				catch (Exception e) 
				{
					elementFound[0] = "false";
					try
					{
						elementFound[1] = driver.findElement(By.xpath("//div[@id='error'][@class='loginError']")).getText();
					}
					catch(Exception ex)
					{}
					
					e.printStackTrace();
					
					driver.navigate().refresh();
					driver.get(driver.getCurrentUrl());
				}
			}
			else if("frame".equalsIgnoreCase(stepDetails[3]))
			{
				try
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id(stepDetails[2])));
				} 
				catch (Exception e) 
				{
					elementFound[0] = "false";
					e.printStackTrace();
				}
			}
			else if("text".equalsIgnoreCase(stepDetails[3].substring(0, 4)))
			{
				try
				{
					wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id(stepDetails[2]), stepDetails[3].substring(4)));
				}
				catch(Exception e)
				{
					elementFound[0] = "false";
					e.printStackTrace();
				}
			}
			else
				elementFound[0] = "false";
		} 
		else if ("name".equalsIgnoreCase(stepDetails[1]))
		{
			if("clickable".equalsIgnoreCase(stepDetails[3]))
			{
				try 
				{
					wait.until(ExpectedConditions.elementToBeClickable(By.name(stepDetails[2])));
				} 
				catch (Exception e) 
				{
					elementFound[0] = "false";
					try
					{
						elementFound[1] = driver.findElement(By.xpath("//div[@id='error'][@class='loginError']")).getText();
					}
					catch(Exception ex)
					{}
					
					e.printStackTrace();
				}
			}
			else if("frame".equalsIgnoreCase(stepDetails[3]))
			{
				try
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.name(stepDetails[2])));
				} 
				catch (Exception e) 
				{
					elementFound[0] = "false";
					e.printStackTrace();
				}
			}
			else if("text".equalsIgnoreCase(stepDetails[3].substring(0, 4)))
			{
				try
				{
					wait.until(ExpectedConditions.textToBePresentInElementLocated(By.name(stepDetails[2]), stepDetails[3].substring(4)));
				}
				catch(Exception e)
				{
					elementFound[0] = "false";
					e.printStackTrace();
				}
			}
			else
				elementFound[0] = "false";
		} 
		else if ("cssSelector".equalsIgnoreCase(stepDetails[1]))
		{
			if("clickable".equalsIgnoreCase(stepDetails[3]))
			{
				try 
				{
					wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(stepDetails[2])));
				}
				catch (Exception e) 
				{
					elementFound[0] = "false";
					try
					{
						elementFound[1] = driver.findElement(By.xpath("//div[@id='error'][@class='loginError']")).getText();
					}
					catch(Exception ex)
					{}
					
					e.printStackTrace();
				}
			}
			else if("frame".equalsIgnoreCase(stepDetails[3]))
			{
				try
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(stepDetails[2])));
				} 
				catch (Exception e) 
				{
					elementFound[0] = "false";
					e.printStackTrace();
				}
			}
			else if("text".equalsIgnoreCase(stepDetails[3].substring(0, 4)))
			{
				try
				{
					wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(stepDetails[2]), stepDetails[3].substring(4)));
				}
				catch(Exception e)
				{
					elementFound[0] = "false";
					e.printStackTrace();
				}
			}
			else
				elementFound[0] = "false";
		} 
		else if ("xpath".equalsIgnoreCase(stepDetails[1]))
		{
			if("clickable".equalsIgnoreCase(stepDetails[3]))
			{
				try 
				{
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(stepDetails[2])));
				} 
				catch (Exception e) 
				{
					
					
					if("//td[2]/div/a".equals(stepDetails[2]))
					{
						System.out.println("2nd Attempt at searching Ticket");
						try
						{
							driver.navigate().refresh();
							wait.until(ExpectedConditions.elementToBeClickable(By.id("SearchField-inputEl")));
							driver.findElement(By.id("SearchField-inputEl")).sendKeys(StartupManager.globalInfo[0]);
							driver.findElement(By.xpath("//div[15]/em/button")).click();
							wait.until(ExpectedConditions.elementToBeClickable(By.xpath(stepDetails[2])));
						}
						catch(Exception ex)
						{
							elementFound[0] = "false";
							elementFound[1] = "No record Found for Ticket or CR";
							ex.printStackTrace();
							System.out.println("No record Found for Ticket or CR");
						}
					}
					
					else if("//a".equals(stepDetails[2]))
					{
						System.out.println("No record Found for Ticket or CR");
						e.printStackTrace();
						elementFound[0] = "false";
						elementFound[1] = "No record Found for Ticket or CR";
					}
					
					else if("//td/a".equals(stepDetails[2]))
					{
						elementFound[0] = "false";
						elementFound[1] = "No record Found for closed Ticket or CR";
						System.out.println("No record Found for closed Ticket or CR");
						e.printStackTrace();
					}	
					else	
					{
						e.printStackTrace();
					}
									
					try
					{
						elementFound[0] = "false";
						elementFound[1] = driver.findElement(By.xpath("//div[@id='error'][@class='loginError']")).getText();
					}
					catch(Exception ex)
					{}
					
				}
			}
			else if("frame".equalsIgnoreCase(stepDetails[3]))
			{
				try
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath(stepDetails[2])));
				} 
				catch (Exception e) 
				{
					elementFound[0] = "false";
					e.printStackTrace();
				}
			}
			else if("text".equalsIgnoreCase(stepDetails[3].substring(0, 4)))
			{
				try
				{
					wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(stepDetails[2]), stepDetails[3].substring(4)));
				}
				catch(Exception e)
				{
					elementFound[0] = "false";
					e.printStackTrace();
				}
			}
			else
				elementFound[0] = "false";
		} 
		else if ("className".equalsIgnoreCase(stepDetails[1]))
		{
			if("clickable".equalsIgnoreCase(stepDetails[3]))
			{
				try 
				{
					wait.until(ExpectedConditions.elementToBeClickable(By.className(stepDetails[2])));
				} 
				catch (Exception e) 
				{
					elementFound[0] = "false";
					try
					{
						elementFound[1] = driver.findElement(By.xpath("//div[@id='error'][@class='loginError']")).getText();
					}
					catch(Exception ex)
					{}
					
					e.printStackTrace();
				}
			}
			else if("frame".equalsIgnoreCase(stepDetails[3]))
			{
				try
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className(stepDetails[2])));
				} 
				catch (Exception e) 
				{
					elementFound[0] = "false";
					e.printStackTrace();
				}
			}
			else if("text".equalsIgnoreCase(stepDetails[3].substring(0, 4)))
			{
				try
				{
					wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className(stepDetails[2]), stepDetails[3].substring(4)));
				}
				catch(Exception e)
				{
					elementFound[0] = "false";
					e.printStackTrace();
				}
			}
			else
				elementFound[0] = "false";
		} 
		else if ("linkText".equalsIgnoreCase(stepDetails[1]))
		{
			if("clickable".equalsIgnoreCase(stepDetails[3]))
			{
				try 
				{
					wait.until(ExpectedConditions.elementToBeClickable(By.linkText(stepDetails[2])));
				} 
				catch (Exception e) 
				{
					elementFound[0] = "false";
					try
					{
						elementFound[1] = driver.findElement(By.xpath("//div[@id='error'][@class='loginError']")).getText();
					}
					catch(Exception ex)
					{}
					
					e.printStackTrace();
				}
			}
			else if("frame".equalsIgnoreCase(stepDetails[3]))
			{
				try
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.linkText(stepDetails[2])));
				} 
				catch (Exception e) 
				{
					elementFound[0] = "false";
					e.printStackTrace();
				}
			}
			else if("text".equalsIgnoreCase(stepDetails[3].substring(0, 4)))
			{
				try
				{
					wait.until(ExpectedConditions.textToBePresentInElementLocated(By.linkText(stepDetails[2]), stepDetails[3].substring(4)));
				}
				catch(Exception e)
				{
					elementFound[0] = "false";
					e.printStackTrace();
				}
			}
			else
				elementFound[0] = "false";
		} 
		else if ("partialLinkText".equalsIgnoreCase(stepDetails[1]))
		{
			if("clickable".equalsIgnoreCase(stepDetails[3]))
			{
				try 
				{
					wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(stepDetails[2])));
				} 
				catch (Exception e) 
				{
					elementFound[0] = "false";
					try
					{
						elementFound[1] = driver.findElement(By.xpath("//div[@id='error'][@class='loginError']")).getText();
					}
					catch(Exception ex)
					{}
					
					e.printStackTrace();
				}
			}
			else if("frame".equalsIgnoreCase(stepDetails[3]))
			{
				try
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.partialLinkText(stepDetails[2])));
				} 
				catch (Exception e) 
				{
					elementFound[0] = "false";
					e.printStackTrace();
				}
			}
			else if("text".equalsIgnoreCase(stepDetails[3].substring(0, 4)))
			{
				try
				{
					wait.until(ExpectedConditions.textToBePresentInElementLocated(By.partialLinkText(stepDetails[2]), stepDetails[3].substring(4)));
				}
				catch(Exception e)
				{
					elementFound[0] = "false";
					e.printStackTrace();
				}
			}
			else
				elementFound[0] = "false";
		} 
		else if ("tagName".equalsIgnoreCase(stepDetails[1]))
		{
			if("clickable".equalsIgnoreCase(stepDetails[3]))
			{
				try 
				{
					wait.until(ExpectedConditions.elementToBeClickable(By.tagName(stepDetails[2])));
				}
				catch (Exception e) 
				{
					elementFound[0] = "false";
					try
					{
						elementFound[1] = driver.findElement(By.xpath("//div[@id='error'][@class='loginError']")).getText();
					}
					catch(Exception ex)
					{}
					
					e.printStackTrace();
				}
			}
			else if("frame".equalsIgnoreCase(stepDetails[3]))
			{
				try
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.tagName(stepDetails[2])));
				} 
				catch (Exception e) 
				{
					elementFound[0] = "false";
					e.printStackTrace();
				}
			}
			else if("text".equalsIgnoreCase(stepDetails[3].substring(0, 4)))
			{
				try
				{
					wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName(stepDetails[2]), stepDetails[3].substring(4)));
				}
				catch(Exception e)
				{
					elementFound[0] = "false";
					e.printStackTrace();
				}
			}
			else
				elementFound[0] = "false";
		}
		else if("window".equalsIgnoreCase(stepDetails[3]))
		{
			try
			{
				wait.until(ExpectedConditions.numberOfWindowsToBe(2));
			} 
			catch (Exception e) 
			{
				elementFound[0] = "false";
				e.printStackTrace();
			}
		}
		else 
		{
			elementFound[0] = "false";
		}

		return elementFound;

	}
}
