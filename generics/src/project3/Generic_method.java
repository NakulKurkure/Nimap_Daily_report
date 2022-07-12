package project3;

public class Generic_method {

	int a=10;
	
//	static void arr(int a[])
//	{
//		for(int i=0;i<a.length;i++)
//		{
//			System.out.println(a[i]);
//		}
//	}
	

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		int a[]= {11,22,33,44,55,66};
		
		arr(a);
		
	}

	
	
	private static <T> void arr(int[] a2) 
	{
	
		for(int  s:a2)
		{
			System.out.print(s+"\n");
		}
	
	}

	
}
