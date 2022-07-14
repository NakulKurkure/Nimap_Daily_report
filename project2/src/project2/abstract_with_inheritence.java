package project2;

//Abstract with inheritence
abstract class a1
{
	abstract void s1();
	void s2()
	{
		System.out.println("In s2 Method....");
	}
	
}

class a2 extends a1
{

	@Override
	void s1() {
		System.out.println("In s1 Method.....");
		
	}
	
}
public class abstract_with_inheritence {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		a2 a=new a2();
		a.s2();
		a.s1();
	}

}
