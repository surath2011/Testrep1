package datasheet.handeler;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

import execution.steps.ExecutionSteps;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;


public class ReadTestCase 
{

	public static WebDriver driver = null;

	public void readTestCaseSteps(File testCaseFile, File result) throws BiffException, IOException, RowsExceededException, WriteException
	{

		int countNumberOfSheets, initialTestCaseRowNumber, lastRowNumber, lastColumnNumber, testCaseCount = 0,i=0,j = 0;
		String testCaseID = null, testCaseName = null, keyword;
		ExecutionSteps executionSteps = new ExecutionSteps();
		String[] stepDetails = new String[4];
		String[] resultDetails = new String[4];
		PublishResult publishResult = new PublishResult();
		WritableWorkbook resultWorkbook;
		WritableSheet resultSheet = null;

		resultWorkbook = Workbook.createWorkbook(result);
		Workbook testCaseWorkbook = Workbook.getWorkbook(testCaseFile);
		countNumberOfSheets = testCaseWorkbook.getNumberOfSheets();
		String[] sheetNames = testCaseWorkbook.getSheetNames();
		try
		{
//			for(i = 0; i < 1; i++)
			for(i = 0; i < countNumberOfSheets; i++)
			{
//				driver = new FirefoxDriver();
//				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//				driver.manage().window().maximize();
				System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
				driver=new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				
				
				String winHandleBefore = driver.getWindowHandle();

				testCaseCount = 1;
				Sheet currentSheet = testCaseWorkbook.getSheet(i);
				resultSheet = resultWorkbook.createSheet(sheetNames[i], i);
				initialTestCaseRowNumber = currentSheet.findCell("TestCase").getRow() + 1;
				lastRowNumber = currentSheet.findCell("End").getRow();
				lastColumnNumber = currentSheet.getColumns();

				for(; initialTestCaseRowNumber < lastRowNumber; initialTestCaseRowNumber = initialTestCaseRowNumber + 5)
				{
					testCaseID = currentSheet.getCell(0, initialTestCaseRowNumber).getContents();
					testCaseName = currentSheet.getCell(1, initialTestCaseRowNumber).getContents();

					for(j = 2; j < lastColumnNumber; j++)
					{
						keyword = currentSheet.getCell(j, initialTestCaseRowNumber+1).getContents().trim();

						if (keyword.length() != 0)
						{
							stepDetails [0] = keyword;
							stepDetails [1] = currentSheet.getCell(j, initialTestCaseRowNumber+2).getContents().trim();
							stepDetails [2] = currentSheet.getCell(j, initialTestCaseRowNumber+3).getContents().trim();
							stepDetails [3] = currentSheet.getCell(j, initialTestCaseRowNumber+4).getContents().trim();
//							stepDetails [4] = currentSheet.getCell(j, initialTestCaseRowNumber+4).getContents().trim();

							try
							{
								resultDetails = executionSteps.executeTestSteps(stepDetails, driver, winHandleBefore);
								publishResult.publishResultInExcel(resultSheet, result, testCaseID, testCaseName, resultDetails, testCaseCount, j+1);
							}
							catch(Exception e)
							{
								e.printStackTrace();
								resultDetails[0] = "Fail";
								publishResult.publishResultInExcel(resultSheet, result, testCaseID, testCaseName, resultDetails, testCaseCount, j+1);
								break;
							}
							finally
							{
								if ("Fail".equalsIgnoreCase(resultDetails[0]))
								{
									break;
								}
							}
						} 
						else 
						{
							break;
						}
					}
					testCaseCount++;
				}
				//			driver.quit();
			driver.close();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			publishResult.publishResultInExcel(resultSheet, result, testCaseID, testCaseName, resultDetails, testCaseCount, j+1);
		}
		finally
		{
			testCaseWorkbook.close();
			resultWorkbook.write();
			resultWorkbook.close();
		}
	}
}
