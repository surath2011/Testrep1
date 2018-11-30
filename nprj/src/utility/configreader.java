package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;



public class configreader {
	Properties pro;
	public configreader(){
		
		try {
			File src= new File("./configuration/Config.property");
			FileInputStream fis = new FileInputStream(src);
			pro= new Properties();
			pro.load(fis);
		} catch (Exception e) {
			
			System.out.println("Exception is"+ e.getMessage());
		}
	}
	public String getchromepath(){
		String path= pro.getProperty("ChromeDriver");
		return path;
	}
	public String geturl(){
		String u= pro.getProperty("URL");
		return u;
	}
	public String getexel(){
		String e= pro.getProperty("Excelpath");
		return e;
	}
	public String getsheet(){
		String g= pro.getProperty("exsheet");
		return g;
	}
}

