
interface car
{
	void music();
	public static void s1()
	{
		System.out.println("In Static Method....");
	}
}

class audi implements car
{

	@Override
	public void music() {
		// TODO Auto-generated method stub
		System.out.println("In Music Method....");
	}
	
}
public class Inter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		audi a=new audi();
		a.music();
		car.s1();
		
	}

	

}
