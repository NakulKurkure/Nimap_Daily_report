package com;

import java.util.Arrays;

public class AnagramString {

	public static void main(String[] args) {
		
		String s="Madam";
		
		String s1="mMada";
		char[] c=s.toCharArray();
		char[] c1=s1.toCharArray();
		
		System.out.println(c);
		System.out.println(c1);
		
		Arrays.sort(c1);
		Arrays.sort(c);
		

		for(int i=0;i<c.length;i++)
		{
			System.out.println(c[i]);
		}
		
		for(int i=0;i<c.length;i++)
		{
			if(c[i]==c1[i])
			{
				System.out.println("The String is Ananagram..");
			}
			
		}
		
			System.out.println("The String Not is Ananagram..");	
	}
}
