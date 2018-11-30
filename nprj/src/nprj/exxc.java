package nprj;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import utility.configreader;
import utility.excelinfo;

public class exxc {
	public static void main(String[] args) {
		configreader c= new configreader();
		String epath= c.getexel();
		String sname= c.getsheet();
		int lastrno=excelinfo.lastrowno(epath,sname);
		int lastcno=excelinfo.lastcellno(epath, sname, 0);
		
		System.out.println(lastrno+" and "+lastcno+" and "+sname);
		Sheet st=excelinfo.getdata(epath, sname);
		
		for(int i=0;i<=lastrno;i++){
			Row r= st.getRow(i);
			for(int j=0;j<lastcno;j++){
				Cell cl=r.getCell(j);
				String data= cl.toString();
				System.out.print(data+"\t\t");
			}
			System.out.println("");
		}
	}
}
