package project2;

//Access modifiers are mainly used for encapsulation.
//Modifiers specify which class can access which other classes or methods or variables.
public class access_modifier {

	
	//1.access same class
	public int a=10;
	protected int b=20;
	int c=30;
	private int f=40;
	
	
	//3.access subclass only public and protected
	public void msg()
	{
		System.out.println("..In public msg..");
	}
	
	protected void msg1()
	{
		System.out.println("..In protected msg1..");
	}
	private void msg3()
	{
		System.out.println("..In protected msg1..");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	access_modifier am=new access_modifier();
	System.out.println(am.a);
	System.out.println(am.b);
	System.out.println(am.c);
	System.out.println(am.f);
		
		
		
	}

}