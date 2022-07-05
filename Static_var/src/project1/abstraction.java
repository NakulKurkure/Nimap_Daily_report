package project1;

abstract class abs
{
	abs()
	{
		System.out.println("In abs constructor..");
	}
	
	//default Method
	void m2()
	{
		System.out.println("In m2");
	}
	//static method
	static void s1()
	{
		System.out.println("In s1");
	}
abstract void m1();	
}

class abs1 extends abs
{
	
	abs1()
	{
		super();
		System.out.println("In abs1 constructor..");
	}
	
	@Override
	void m1() {
		// TODO Auto-generated method stub
		System.out.println("In m1");
	}
	
	
}

public class abstraction {
public static void main(String[] args) {
		// TODO Auto-generated method stub

	abs1 a1=new abs1();
	a1.m1();
	a1.m2();
	a1.s1();
	
	
	}

}
