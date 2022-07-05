package project1;

interface m1
{
	void m1();
	void m2();
}


class c1 implements m1
{

	@Override
	public void m1() {
		// TODO Auto-generated method stub
		System.out.println("In m1 method");
	}

	@Override
	public void m2() {
		// TODO Auto-generated method stub
		System.out.println("In m2 method");
	}
	
}
public class interface1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		c1 c=new c1();
		c.m1();
		c.m2();
		
	}

}
