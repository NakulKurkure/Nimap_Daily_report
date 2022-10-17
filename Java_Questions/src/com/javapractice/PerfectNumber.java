package com.javapractice;

import java.util.Scanner;

public class PerfectNumber {

	public static void main(String[] args) {
	
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Number u want \n");
		int num=sc.nextInt();//5
		int sum=0;

		for(int i=0;i<=num;i++)
		{
			if(num%i==0)
			{
				sum=sum+i;
				System.out.println("The Sum is"+sum);
			}
		}
		
		if(sum==num)
		{
			System.out.println("The Number is Perfect Number");
		}else
		{
			System.out.println("The Number is Not Perfect Number");
		}
		
	}

}
