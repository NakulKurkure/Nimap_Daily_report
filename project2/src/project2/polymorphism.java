package project2;

class m1
{
	//polymorphism
	//1.function overloading
	void s1()
	{
		int a=10;
		int b=20;
		
		int c=a+b;
		System.out.println("The Addition is "+c);
	}
	//function overriding 
	void s2(int a,int b)
	{
		int d=a*b;
		System.out.println("the Mutiplication is "+d);
	}
	
	
	
}
public class polymorphism {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		m1 m=new m1();
		m.s1();
		m.s2(4, 7);
		
	}

}
