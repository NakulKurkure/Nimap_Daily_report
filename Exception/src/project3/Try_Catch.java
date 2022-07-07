package project3;

public class Try_Catch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a=1000;
		int b=0;
		
		try
		{
			System.out.println(a/b);
			
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println(e);
		}
		
		catch(ArithmeticException e)
		{
			System.out.println(e);
		}
		finally {
			
			System.out.println("Program End....");
			
		}
		
		
	
		
	}

}
