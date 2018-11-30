package dem3;

public class myapp extends overide
{
	int i= 20;
	void register()
	{
		System.out.println("username character 6");
		System.out.println(i);
		System.out.println(super.i);
		super.register();
	}
	void login()
	{
		super.register();
		System.out.println("Logged in");
	}
	public static void main(String[] args) {
		myapp m=new myapp();
		m.register();
		m.login();
		System.out.println(m.i);
	}
	
}
class demo
{
	
}
