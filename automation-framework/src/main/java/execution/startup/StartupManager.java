package execution.startup;

import java.io.File;
import java.io.IOException;

import datasheet.handeler.ReadTestCase;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class StartupManager 
{
	public static String[] globalInfo = {"","","",""};
	
	public static void main(String[] args) throws BiffException, IOException, RowsExceededException, WriteException, InterruptedException 
	{

		File testCaseFile, result;
		
		testCaseFile = new File("C:\\ss\\Cos_datasheet_Surath.xls");
		
		
//		C:\Users\surath\Documents
		result = new File("C:\\ss\\Test_Result.xls");

		ReadTestCase readTestCase = new ReadTestCase();
		readTestCase.readTestCaseSteps(testCaseFile, result);

		System.out.println("Execution Finish");
	}
}
