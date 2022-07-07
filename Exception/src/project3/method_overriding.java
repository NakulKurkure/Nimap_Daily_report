package project3;

class m
{
	void m1()
	{
		System.out.println("In M1 method...");
	}
	
}

class m2 extends m
{
	void m1()
	{
		System.out.println("In m1 overrided method...");
	}
}

public class method_overriding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		m2 m=new m2();
		m.m1();
	}

}
