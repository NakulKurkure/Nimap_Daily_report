package com.javapractice;

public class PallindromeString {
	
	public static void main(String[] args) {
		
		String s="radar";
		String revString="";
		
		for(int i=s.length()-1;i>=0;i--)
		{
			revString=revString+s.charAt(i);
		}
		System.out.println("String is "+s);
		System.out.println("Reverse String is "+revString);
		
		if(s.equals(revString))
		{
			System.out.println("String Is Pallindrome..");
		}
		else
		{
			System.out.println("String Is Not Pallindrome..");
		}
		
	}

}
