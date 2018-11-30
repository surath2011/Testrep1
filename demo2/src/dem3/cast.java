package dem3;

class software
{
	void runs()
	{
		System.out.println("Works on desktop");
	}
	void comp()
	{
		System.out.println("Windows 7 or upper");
	}
}
class apkapp extends software
{
	void runs()
	{
		System.out.println("Works on Android");
	}
	void androidv()
	{
		System.out.println("4 and upper");
	}
}
public class cast {
public static void main(String[] args) {
	software s= new apkapp();
	s.runs();
	software ss= new apkapp();//downcasting using upcasting
	apkapp p=(apkapp)ss;
	p.androidv();
	p.comp();
}
}
