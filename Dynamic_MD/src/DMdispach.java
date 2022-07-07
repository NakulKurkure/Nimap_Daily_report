
class parent
{
	 void m1()
	 {
		 System.out.println("in parent class Method.....");
	 }
}

class child extends parent
{
	 void m1()
	 {
		 System.out.println("in child class Method1.....");
	 }
}

public class DMdispach {

	public static void main(String[] args) {
		
		//parent reference but parent object
		parent m=new parent();
		
//		parent reference but child object
		parent p=new child();
		
		m.m1();
		p.m1();
		
	}

}
