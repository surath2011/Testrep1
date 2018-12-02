package datasheet.handeler;

import java.io.File;
import java.io.IOException;

import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class PublishResult {


	public void publishResultInExcel(WritableSheet resultSheet, File result, String testCaseID, String testCaseName, String[] resultDetails, int testCaseCount, int currentColumnNumber) throws IOException, RowsExceededException, WriteException
	{
		WritableFont font = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
		WritableCellFormat cellFormatHeader = new WritableCellFormat(font);
		cellFormatHeader.setBorder(Border.ALL, BorderLineStyle.THIN);
		cellFormatHeader.setAlignment(Alignment.CENTRE);
		cellFormatHeader.setBackground(Colour.GRAY_25);

		WritableCellFormat cellFormat = new WritableCellFormat();
		cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
		cellFormat.setVerticalAlignment(VerticalAlignment.CENTRE);

		if (testCaseCount == 1 && currentColumnNumber == 3)
		{
			Label labelHeadingTCNo = new Label(0, testCaseCount-1, "TC No.", cellFormatHeader);
			Label labelHeadingTCDescription = new Label(1, testCaseCount-1, "Description", cellFormatHeader);
			Label labelHeadingTCStatus = new Label(2, testCaseCount-1, "Status", cellFormatHeader);
			Label labelHeadingReason = new Label(3, testCaseCount-1, "Reason", cellFormatHeader);
			Label labelHeadingInfo = new Label(4, testCaseCount-1, "Other Info.", cellFormatHeader);
			Label labelHeadingMessage = new Label(5, testCaseCount-1, "Message", cellFormatHeader);
			resultSheet.addCell(labelHeadingTCNo);
			resultSheet.addCell(labelHeadingTCDescription);
			resultSheet.addCell(labelHeadingTCStatus);
			resultSheet.addCell(labelHeadingReason);
			resultSheet.addCell(labelHeadingInfo);
			resultSheet.addCell(labelHeadingMessage);
		}

		Label labelTestCaseID = new Label(0, testCaseCount, testCaseID, cellFormat);
		Label labelTestCaseName = new Label(1, testCaseCount, testCaseName, cellFormat);
		Label resultLabel = new Label(2, testCaseCount, resultDetails[0], cellFormat);
		resultSheet.addCell(labelTestCaseID);
		resultSheet.addCell(labelTestCaseName);
		resultSheet.addCell(resultLabel);

		if ("Fail".equalsIgnoreCase(resultDetails[0]))
		{
			ColumnByAlphabet c = new ColumnByAlphabet();
			String column = c.getExcelColumnName(currentColumnNumber);
			Label reason = new Label(3, testCaseCount, resultDetails[1] + " at column - " + column, cellFormat);
			resultSheet.addCell(reason);
		}
		else
		{
			Label reason = new Label(3, testCaseCount, resultDetails[1], cellFormat);
			resultSheet.addCell(reason);
		}

		if(resultDetails[2].length() != 0)
		{
			Label otherInfo = new Label(4, testCaseCount, resultDetails[2], cellFormat);
			resultSheet.addCell(otherInfo);
		}

		if(resultDetails[3].length() != 0)
		{
			Label message = new Label(5, testCaseCount, resultDetails[3], cellFormat);
			resultSheet.addCell(message);
		}
	}

}

