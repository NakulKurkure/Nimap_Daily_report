package project1;

public class static_variable_method {

	int a=10;
	int b=20;
	static int c=200; //A static int variable remains in memory while the program is running. 
	
	
	//Static variables belong to the class
	
	
	//shared value/memory
	//Static variables (like global variables) are initialized as 0.
	
	//The static variables are stored in the data segment of the memory.
	//non-static variable are stored in heap memory.
	
	static
	{
		System.out.println("Program Started.....");
	}
	
	void m3()
	{
		System.out.println("The value of a is"+a);
		System.out.println("The value of b is"+b);
		System.out.println("The value of a is"+c);
	}
	
	//Static methods are associated with the class, not objects of the class.
	static void s2()
	{
		System.out.println("The value of a is"+c);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		static_variable_method sm=new static_variable_method();
		sm.m3();
//		s2();
		static_variable_method.s2();
		
		
	}

}
