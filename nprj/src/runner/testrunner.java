package runner;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class testrunner {

	public static void main(String[] args) {
		TestNG runner= new TestNG();
		List<String> list= new ArrayList<String>();
		list.add("C:\\surat\\nprj\\test-output\\Failed suite [Suite]\\testng-failed.xml");
		runner.setTestSuites(list);
		runner.run();
	}

}
