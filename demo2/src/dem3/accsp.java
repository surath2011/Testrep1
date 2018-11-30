package dem3;

public class accsp {
	public void pblm()
	{
		System.out.println("Public method invoked");
	}
	private void pvtm()
	{
		System.out.println("Private method invoked");
	}
	protected void prctm()
	{
		System.out.println("Protected method invoked");
	}
	void defm()
	{
		System.out.println("Default method invoked");
	}
	public static void main(String[] args) {
		accsp ac= new accsp();
		ac.pblm();
		ac.pvtm();
		ac.prctm();
		ac.defm();
		System.out.println("Now calling from outside of class");
		System.out.println("*********************************");
		C c=new C();
		c.show();
	}
}
class C
{
	accsp sp= new accsp();
	void show()
	{
		sp.pblm();
		sp.prctm();
		sp.defm();
	}
}
