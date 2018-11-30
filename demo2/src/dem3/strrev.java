package dem3;

public class strrev {
	public static void main(String[] args) {
		String a= "fedcba";
		int [] n = {99,78,43,2,8,1,15,11,0,5};
		int y= n.length;
		char[] a1  = a.toCharArray();
		for(int i=a1.length-1;i>=0;i--){
			System.out.print(a1[i]);
		}
		System.out.println();
		for(int j=0;j<y;j++){
			for(int z=1;z<y-j;z++){
			if(n[z-1]>n[z]){
				int temp=n[z-1];
				n[z-1]=n[z];
				n[z]=temp;
			}
						
		}
	}
		for(int h=0;h<y;h++){
			System.out.print(n[h]+"--");
		};

}
}
