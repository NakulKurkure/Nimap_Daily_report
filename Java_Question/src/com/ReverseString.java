package com;

public class ReverseString {

	
	public static void main(String args[])
	{
		//Pallindrome String and Reverse String is Same...	
		
		String a="cook";
	
		System.out.println("The given String is "+a);
		
		for(int i=a.length()-1;i>=0;i--)
		{
			char ch=a.charAt(i);
			
			System.out.println(ch);
		}
		
		
		
	}
}
