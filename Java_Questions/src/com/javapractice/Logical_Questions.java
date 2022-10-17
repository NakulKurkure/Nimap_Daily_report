package com.javapractice;

public class Logical_Questions {

	public static void main(String[] args) {
		
		//Duplicate Character in String 
		String s= "Nikhil";
		
		int count=0;
		int i=0;
		int j=0;
		for(i=0;i<s.length();i++)
		{	
			for( j=i+1;j<s.length();j++)
			{
				if(s.charAt(i)==s.charAt(j))
				{
					System.out.println("Duplicate Char is:-"+ s.charAt(i)+ "\nCount is:-"+ count++);
//					System.out.println("Duplicate char");
				}
				
			}
			
		}
		
		
		
		
//		Even and Odd Number
//		Scanner sc=new Scanner(System.in);
//		System.out.println("Enter the number What do you want:-");
//		int num=sc.nextInt();
	
//		for(int i=0;i<=num;i++)
//		{
//			
//			if(i%2==0)
//			{
//				System.out.println("The even numbers are "+i);
//			}
//			else
//			{
//				System.out.println("The Odd numbers are"+i);
//			}
//		}
		
		
		
		
		
		
	}
}
