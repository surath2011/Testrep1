package demo2;

public class demo2 {
	public static void main (String[] args)
	{
		
		for(int i=1; i<=3; i++)
			{
				if(i!=3)
				{
				for(int j=1;j<=5;j++)
					{
					System.out.print(j%2+" ");
					
					}
					System.out.println(" ");
				for(int k=1;k<=5;k++)
					{
					System.out.print((k+1)%2+" ");
					
					}
					System.out.println(" ");
				}
				else
				for(int j=1;j<=5;j++)
					{
					System.out.print(j%2+" ");
					
					}
			}
	}
}
