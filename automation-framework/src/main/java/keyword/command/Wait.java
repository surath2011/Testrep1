package keyword.command;

import org.openqa.selenium.WebDriver;

public class Wait {
	 public String[] waitForPageLoad(String[] stepDetails, WebDriver driver, String[] result){
	  
	  
	 
	  


	if (stepDetails[3].length() != 0){
	 int t=Integer.parseInt(stepDetails[3]);

	try {
	   Thread.sleep(t);
	  } 
	  
	  catch (InterruptedException e) {
	   result [0] = "Fail";
	   
	//   e.printStackTrace();
	  }
	  }
	else{
	 //result [0] = "Fail";
	  // result [1] = "Frame name is missing"; 
	 // }
	 
	 try {
	  Thread.sleep(20000);
	 } 
	 
	 catch (InterruptedException e) {
	  result [0] = "Fail";
	  
	//  e.printStackTrace();
	 }

	 
	 
	 
	} 
	  return result;
	 

	}
	}