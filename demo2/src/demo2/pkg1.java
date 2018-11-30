package demo2;
import dem3.dem3;
import java.util.Scanner;
public class pkg1 {
	
	dem3 d= new dem3();
	void displayprod()
	{
		d.addprod();
		System.out.println("Please enter no of Product to be added");
		Scanner sc= new Scanner(System.in);
		int num1= sc.nextInt();
		System.out.println("Total "+num1+" product to be added");
		sc.close();
	}
	public static void main(String[] args) {
		pkg1 p= new pkg1();
		p.displayprod();
	}
}

