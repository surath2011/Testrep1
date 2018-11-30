package dem3;

class car
{
	
}
class hyundai extends car
{
	void hd()
	{
		System.out.println("i am Hyundai");
	}
}
class honda extends car
{
	void hdd()
	{
		System.out.println("i am Honda");
	}
}
class disp
{
	void convert(car c)
	{
		if(c instanceof hyundai)
		{
			hyundai h=(hyundai)c;
			System.out.println("Car converted to Hyundai");
			h.hd();
		}
		else if(c instanceof honda)
		{
			honda d=(honda)c;
			System.out.println("Car converted to Honda");
			d.hdd();
		}
	}
}
public class qsp {
public static void main(String[] args) {
	disp l= new disp();
	l.convert(new honda());
}
}
