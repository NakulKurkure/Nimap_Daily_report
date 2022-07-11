package project3;

class base1
{
	
	void d1()
	{
		System.out.println("in d1 method..");
	}
	
}
class derived1 extends base
{
	void d1()
	{
		System.out.println("in d1 method..");
	}
	void d2()
	{
		System.out.println("in d2 method..");
	}
}

public class downcasting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		base1 b=new base1();
//		b.d1();
		
//		derived1 d=(derived1)b;
//		d.s1();
		
	}

}
