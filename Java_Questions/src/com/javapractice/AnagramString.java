package com.javapractice;

import java.util.Arrays;

public class AnagramString {

	public static void main(String args[])
	{
		
		String s="listenes";
		String s1="silentes";
		
		char c[]=s.toCharArray();
		char c1[]=s1.toCharArray();
		
		if(c.length!=c1.length)
		{
			System.out.println("Not Anagram String");
			
		}
		
		else
		{
			
			Arrays.sort(c);
			Arrays.sort(c1);
			
			System.out.println("Sorted Elements are c :-\n");
			System.out.println(c);
			
			System.out.println("Sorted Elements are c :-\n");
			System.out.println(c1);
			
			for(int i=0;i<c.length;i++)
			{
				if(c[i]!=c1[i])
				{
					System.out.println("String is Not Anagram... ");
				}
				
			}
			
			System.out.println("String is Anagram..");
			
		}
		
	}
}
