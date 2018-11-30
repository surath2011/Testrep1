package repos;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

import org.testng.annotations.Test;

public class test1 {
	//Properties pro;
	
	@Test
	public void geturl() throws Exception{
		File src= new File("./configuration/Config.property");
		FileInputStream fis= new FileInputStream(src);
		Properties pro= new Properties();
		pro.load(fis);
		String u= pro.getProperty("URL");
		String cpath=pro.getProperty("ChromeDriver");
		System.out.println(u);
		System.out.println(cpath);
	}
		
}
