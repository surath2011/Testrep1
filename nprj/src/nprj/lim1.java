package nprj;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class lim1 {


    public static void main(String[] args) {
        // declaration and instantiation of objects/variables
	WebDriver driver ;
	System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
	driver = new FirefoxDriver();
        String baseUrl = "file:///C:/09.03.17/E/Limtex/only_design/about.php";
        String expectedTitle = "HOME PAGE";
        String actualTitle = "";
        //driver.findElement(By.linkText("UPLOAD")).click();
        // launch Fire fox and direct it to the Base URL
driver.get(baseUrl);

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
