package nprj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
public class hih1 {


    public static void main(String[] args) {
        // declaration and instantiation of objects/variables
	//WebDriver driver ;
	//System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
	//driver = new FirefoxDriver();
    	System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
        String baseUrl = "file:///C:/09.03.17/D/HIH/hideinhills.in/index.html";
        String expectedTitle = "CONTACT US";
        String actualTitle = "";
        
        // launch Fire fox and direct it to the Base URL
        driver.manage().window().maximize();
        driver.get(baseUrl);

		driver.findElement(By.linkText("Contact Us")).click();
        // get the actual value of the title
		actualTitle = driver.getTitle();
		
        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)){
        	System.out.println("Test Passed!");
        } else {
        	System.out.println("Test Failed");
        }

        //close Fire fox
        driver.close();

        // exit the program explicitly
        System.exit(0);
    }

}

