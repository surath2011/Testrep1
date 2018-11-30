package dem3;


class alpp
{
	alpp()
	{
		this(10);
		System.out.println("Hiiii");
	}
	alpp(int i)
	{
		this("Surath");
		System.out.println(i);
	}
	alpp(String s)
	{
		System.out.println(s);
	}
	void disp()
	{
		System.out.println("ok!");
	}
	
}
public class alps {
	
	public static void main(String[] args) {
		alpp al=new alpp();
		al.disp();
	}
}