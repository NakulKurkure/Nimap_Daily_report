package project3;

public class Tightly_Coupled2 {

	//classes and objects are dependent on one another
	private Tightly_Coupled tc;
	
	Tightly_Coupled2()
	{
		tc=new Tightly_Coupled(124.88);
		
	}
	
	void show()
	{
		
		var s=tc.show();
		System.out.print(s);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Tightly_Coupled2 tlc=new Tightly_Coupled2();
		tlc.show();
	}

}
