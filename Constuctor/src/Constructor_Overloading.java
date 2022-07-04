
class constructor
{
	constructor()
	{
		System.out.println("In the Default Constructor....");
	}
	
	constructor(int a,int b)
	{
		int c=a+b;
		System.out.print("The Addition is "+c);
		
	}
}
public class Constructor_Overloading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		constructor c=new constructor();
		constructor c1=new constructor(3,4);
		
		
	}

}
