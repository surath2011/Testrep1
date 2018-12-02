package datasheet.handeler;

import java.util.ArrayList;
import java.util.List;

public class ReadStartUpFile {
	
	public List<String> test (){
		
		List<String> startup = new ArrayList<String>();
		
		startup.add("element 1");
		System.out.print("\t" + startup);
		String element0 = startup.get(0);
		
		return startup;
		
		
	}

}
