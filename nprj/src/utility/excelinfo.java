package utility;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelinfo {
	
		public static int lastrowno(String fpath,String sheetname){
			int lastrowno= 0;
			try {
				
				File f= new File(fpath);
				FileInputStream src= new FileInputStream(f);;
				XSSFWorkbook b= new XSSFWorkbook(src);
				XSSFSheet sheet1= b.getSheet(sheetname);
				lastrowno= sheet1.getLastRowNum();
				b.close();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lastrowno;
			
		}
		public static int lastcellno(String fpath,String sheetname,int rowindex){
			int lascellno= 0;
			try {
				
				File f= new File(fpath);
				FileInputStream src= new FileInputStream(f);;
				Workbook wb= WorkbookFactory.create(src);
				Sheet st= wb.getSheet(sheetname);
				Row r= st.getRow(rowindex);
				lascellno= r.getLastCellNum();
				wb.close();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lascellno;
			
		}
		public static Sheet getdata(String fpath,String sheetname){
			Sheet st=null;
			try {
				
				File f= new File(fpath);
				FileInputStream src= new FileInputStream(f);;
				Workbook wb= WorkbookFactory.create(src);
				st= wb.getSheet(sheetname);
				wb.close();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return st;
			
		}
		
	

}
