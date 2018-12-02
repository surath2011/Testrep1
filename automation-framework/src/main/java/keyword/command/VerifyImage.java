package keyword.command;

import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class VerifyImage {
	
	public static String[] perform (String[] stepDetails, String[] result) {
		
		Screen s=new Screen();
	    Pattern pattern = new Pattern(stepDetails[3]);
	    Float accuresy;
	     
  		 try {
  			accuresy = Float.parseFloat(stepDetails[1]); 
  			s.wait(pattern.similar((float) accuresy),1);
  		 } catch (Exception e) {
  			result [0] = "Fail";
			result [1] = stepDetails[1] + " - SRC Img doesn't match with Expected Img";
  		 }
  		 
  		return result;
	}

}
