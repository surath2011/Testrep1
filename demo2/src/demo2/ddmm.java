package demo2;

public class ddmm {
	public static void main (String[] args)
	{
		char k='A';
		for(int i=1; i<=3; i++)
			{
				for(int j=1;j<=i;j++)
					{
					if(i==2)
					{
					k='B';
					}
					else if(i==3)
					{
					k='C';
					}
					System.out.print(k+" ");
					}
					System.out.println(" ");
			}
		
	}
}

