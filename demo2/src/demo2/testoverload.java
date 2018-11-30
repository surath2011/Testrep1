package demo2;

public class testoverload {
	private void dspl(){
		System.out.println("GM");
	}
	public void dspl(int i){
		System.out.println("UFT");
	}
	public static void main(String[] args) {
		testoverload t= new testoverload();
		t.dspl();
		t.dspl(4);

	}

}
