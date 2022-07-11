package project3;

class base
{
	void s1()
	{
		
		System.out.println("In base class Method....");
		
	}
}

class derived extends base
{
	@Override
	void s1()
	{
		System.out.println("In derived class Method....");
	}
}
public class Upcasting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//upcasting
		//We use it when we need to develop a code that deals with only the parent class.
		base b=new derived();//derived to base class
		b.s1();
		
		if(b instanceof derived)
		{
			derived d=(derived)b;
			d.s1();
			
			
		}
		
//		downcasting //base to derived
		derived d=(derived)b;
		d.s1();
		
//		
		
	}

}
