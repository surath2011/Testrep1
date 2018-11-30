package dem3;

class alpha
{
	int i=10;
	void show()
	{
		int i= 20;
		System.out.println(i);
		System.out.println(this.i);
	}
}

public class dm {
public static void main(String[] args) {
	alpha a= new alpha();
	a.show();
}
}
