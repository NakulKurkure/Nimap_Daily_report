package com.javapractice;

import java.util.Scanner;

//Addition of Factors
public class perfectno {

	public static void main(String [] args)
	{
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter number");
		int num=sc.nextInt();//6
		
		for(int i=1;i<num;i++)
		{
			if(i%2==0)
			{
				System.out.println("Even number Are"+i);
			}
		}
	}
}
