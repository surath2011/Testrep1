package execution.steps;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import keyword.command.AcceptAlert;
import keyword.command.Attribute;
import keyword.command.CSSValue;
import keyword.command.Click;
import keyword.command.DynFrame;
import keyword.command.Error404;
import keyword.command.FindElement;
import keyword.command.JavascriptClick;
import keyword.command.MouseOver;
import keyword.command.OpenUrl;
import keyword.command.RunExe;
import keyword.command.ScrollView;
import keyword.command.SelectBox;
import keyword.command.StoreText;
import keyword.command.SwitchBackFromFrame;
import keyword.command.SwitchToConsoleFrame;
import keyword.command.SwitchToFrame;
import keyword.command.SwitchWindow;
import keyword.command.Type;
import keyword.command.VerifyImage;

import keyword.command.VerifyText;
import keyword.command.VerifyTitle;

import keyword.command.Wait;
import keyword.command.Webdriverwait;
import remedyForce.Date;
import remedyForce.EndDate;
import remedyForce.SearchCR;
import remedyForce.SearchTicket;
import remedyForce.StoreTicket;

public class ExecutionSteps 
{

	public String[] executeTestSteps(String[] stepDetails, WebDriver driver, String winHandleBefore) throws IOException 
	{

		FindElement element = new FindElement();
		Webdriverwait wdwait = new Webdriverwait();
		VerifyText verifyText = new VerifyText();
		String[] result = new String[4];
		result [0] = "Pass";
		result [1] = "";
		result [2] = "";
		result [3] = "";


		if ("OpenUrl".equalsIgnoreCase(stepDetails[0])) 
		{
			OpenUrl opu = new OpenUrl();
			opu.openURL(stepDetails, driver);
			
		} else if ("VerifyImage".equalsIgnoreCase(stepDetails[0])) {
			result = VerifyImage.perform(stepDetails, result);
		} else if ("MouseOver".equalsIgnoreCase(stepDetails[0])) {
			result = MouseOver.perform(stepDetails, result, driver);
		} else if ("Error404".equalsIgnoreCase(stepDetails[0])) {
			result = Error404.httpCode(stepDetails, driver, result);
		} else if ("JavascriptClick".equalsIgnoreCase(stepDetails[0])) {
			result = JavascriptClick.Click(stepDetails, driver, result);
		} 
		
		
		else if ("Type".equalsIgnoreCase(stepDetails[0])) 
		{
			boolean elementFound = element.verifyElementPresnt(stepDetails, driver);

			if (elementFound)
			{
				Type type = new Type();
				result = type.input(stepDetails, driver, result);
			} 
			else 
			{
				result [0] = "Fail";
				result [1] = "Element not found - " + stepDetails[1] + " = " + stepDetails[2];
			}

		} 
		else if ("Click".equalsIgnoreCase(stepDetails[0])) 
		{

			boolean elementFound = element.verifyElementPresnt(stepDetails, driver);

			if (elementFound)
			{
				Click click = new Click();
				result = click.operationClick(stepDetails, driver, result);
			} 
			else 
			{
				result [0] = "Fail";
				result [1] = "Element not found - " + stepDetails[1] + " = " + stepDetails[2];
			}

		} 
		else if ("VerifyText".equalsIgnoreCase(stepDetails[0])) 
		{

			boolean elementFound = element.verifyElementPresnt(stepDetails, driver);

			if (elementFound)
			{

				result = verifyText.verifySearchText(stepDetails, driver, result);

			} 
			else 
			{
				result [0] = "Fail";
				result [1] = "Element not found. " + stepDetails[1] + " = " + stepDetails[2];
			}

		} 
		else if ("VerifyElement".equalsIgnoreCase(stepDetails[0]))
		{

			boolean elementFound = element.verifyElementPresnt(stepDetails, driver);

			if (elementFound)
			{

				result [0] = "Pass";
				result [1] = "";

			} 
			else 
			{
				result [0] = "Fail";
				result [1] = "Element not found. " + stepDetails[1] + " = " + stepDetails[2];
			}

		}  
		
		else if ("Select".equalsIgnoreCase(stepDetails[0])) 
		{

			SelectBox selectBox = new SelectBox();
			result = selectBox.selectBy(stepDetails, driver, result);

		} 
		else if ("SwitchToFrame".equalsIgnoreCase(stepDetails[0])) 
		{

			SwitchToFrame switchToFrame = new SwitchToFrame();
			result = switchToFrame.switchToAnotherFrame(stepDetails, driver, result);

		}
		else if ("SwitchBackFromFrame".equalsIgnoreCase(stepDetails[0])) 
		{

			SwitchBackFromFrame switchBackFromFrame = new SwitchBackFromFrame();
			result = switchBackFromFrame.switchToDefaultFrame(stepDetails, driver, result);

		} 
		else if ("SwitchWindow".equalsIgnoreCase(stepDetails[0]))
		{

			SwitchWindow switchWindow = new SwitchWindow();
			result = switchWindow.switchToNewWindow(stepDetails, driver, result);

		} 
		else if ("SwitchToDefaultWindow".equalsIgnoreCase(stepDetails[0])) 
		{

			driver.switchTo().window(winHandleBefore);
			//			Throws:NoSuchWindowException - If the window cannot be found
		} 
		else if ("DynFrame".equalsIgnoreCase(stepDetails[0])) 
		{

			DynFrame DynamicFrame = new DynFrame();
			result = DynamicFrame.switchToAnotherDynFrame(stepDetails, driver, result);

		} 
		else if ("StoreText".equalsIgnoreCase(stepDetails[0])) 
		{

			boolean elementFound = element.verifyElementPresnt(stepDetails, driver);

			if (elementFound)
			{
				StoreText storetext = new StoreText();
				result = storetext.store(stepDetails, driver, result);
			} 
			else 
			{
				result [0] = "Fail";
				result [1] = "Element not found - " + stepDetails[1] + " = " + stepDetails[2];
			}	

		} 
		else if ("VerifyCSSValue".equalsIgnoreCase(stepDetails[0])) 
		{
			result=CSSValue.verify(stepDetails, driver, result);
//			boolean elementFound = element.verifyElementPresnt(stepDetails, driver);
//
//		if(elementFound)
//		{
//				result = CSSValue.verify(stepDetails, driver, result);
//			} 
//		else 
//		{
//				result [0] = "Fail";
//				result [1] = "Element not found - " + stepDetails[1] + " = " + stepDetails[2];
//			}	

		} 
		else if ("VerifyAttribute".equalsIgnoreCase(stepDetails[0])) 
		{
			result=Attribute .getValue(stepDetails, driver, result);
		}
		
		else if ("CloseWindow".equalsIgnoreCase(stepDetails[0]))
			
		{
			driver.close();
		}
		else if ("ConsoleFrame".equalsIgnoreCase(stepDetails[0])) 
		{

			SwitchToConsoleFrame ConsoleFrame = new SwitchToConsoleFrame();
			result = ConsoleFrame.switchToDynamicFrame(stepDetails, driver, result);


		} 
		else if ("SearchTicket".equalsIgnoreCase(stepDetails[0]))
		{

			boolean elementFound = element.verifyElementPresnt(stepDetails, driver);
			if (elementFound)
			{
				SearchTicket searchTicket = new SearchTicket();
				result = searchTicket.ticketSearch(stepDetails, driver, result);
			}
			else
			{
				result [0] = "Fail";
				result [1] = "Element not found - " + stepDetails[1] + " = " + stepDetails[2];
			}

		}
		else if ("StoreTicket".equalsIgnoreCase(stepDetails[0]))
		{

			boolean elementFound = element.verifyElementPresnt(stepDetails, driver);
			if (elementFound) 
			{
				StoreTicket store = new StoreTicket();
				result = store.store(stepDetails, driver, result);
			}
			else 
			{
				result [0] = "Fail";
				result [1] = "Element not found - " + stepDetails[1] + " = " + stepDetails[2];
			}
		}
		else if ("SearchCR".equalsIgnoreCase(stepDetails[0])) 
		{

			boolean elementFound = element.verifyElementPresnt(stepDetails, driver);
			if (elementFound)
			{
				SearchCR crSearch = new SearchCR();
				result = crSearch.crSearch(stepDetails, driver, result);
			} 
			else
			{
				result [0] = "Fail";
				result [1] = "Element not found - " + stepDetails[1] + " = " + stepDetails[2];
			}

		}	
		else if ("typeStoreText".equalsIgnoreCase(stepDetails[0]))
		{

			boolean elementFound = element.verifyElementPresnt(stepDetails, driver);
			if (elementFound) 
			{
				SearchTicket searchTicket = new SearchTicket();
				result = searchTicket.ticketSearch(stepDetails, driver, result);
			}
			else 
			{
				result [0] = "Fail";
				result [1] = "Element not found - " + stepDetails[1] + " = " + stepDetails[2];
			}
		}
		else if ("Wait".equalsIgnoreCase(stepDetails[0]))
		{

			Wait wait = new Wait();
			result = wait.waitForPageLoad(stepDetails, driver, result);

		}
		else if ("AcceptAlert".equalsIgnoreCase(stepDetails[0]))
		{

			AcceptAlert alert = new AcceptAlert();
			result = alert.acceptAlert(stepDetails, driver, result);
		}	
		else if ("BindDate".equalsIgnoreCase(stepDetails[0])) 
		{
			Date date = new Date();
			result = date.Date_Time(stepDetails, driver, result);

		}
		else if ("BindEndDate".equalsIgnoreCase(stepDetails[0])) 
		{
			EndDate date = new EndDate();
			result = date.End_Date_Time(stepDetails, driver, result);
		}
		else if("Webdriverwait".equalsIgnoreCase(stepDetails[0]))
		{
			String[] elementFound = wdwait.waitForElement(stepDetails, driver);

			if("true".equalsIgnoreCase(elementFound[0]))
			{
				result [0] = "Pass";
				result [1] = "";
			}
			else
			{
				result [0] = "Fail";
				result [1] = "Element not found - " + stepDetails[1] + " = " + stepDetails[2];
				result [3] = elementFound[1];
			}
		}
		else if("scrollView".equalsIgnoreCase(stepDetails[0]))
		{
			boolean elementFound = element.verifyElementPresnt(stepDetails, driver);
			
			if(elementFound)
			{
				ScrollView scrview = new ScrollView();
				result = scrview.scrollElementintoView(stepDetails, driver, result);
			}
			else
			{
				result [0] = "Fail";
				result [1] = "Element not found - " + stepDetails[1] + " = " + stepDetails[2];
			}
		}
		else if("verifyTitle".equalsIgnoreCase(stepDetails[0]))
		{
			VerifyTitle verifyTitle = new VerifyTitle();
			result = verifyTitle.verifyPageTitle(stepDetails, driver, result);
			
		}
		else if("runExe".equalsIgnoreCase(stepDetails[0]))
		{
			RunExe re = new RunExe();
			re.runExeFile();
		}
		else 
		{
			result [0] = "Fail";
			result [1] = "Keyword " + stepDetails[0] + " not supported";
		}
		return result;
	}
}

