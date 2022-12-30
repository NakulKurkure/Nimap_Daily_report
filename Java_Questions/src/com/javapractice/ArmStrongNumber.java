package com.javapractice;

import java.util.Scanner;

public class ArmStrongNumber {

	public static void main(String args[])
	{
	
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number:-\n");
		int num=sc.nextInt();//153
		int temp=num;
		int rem,sum=0;
		//153
		//15
		while(num>0)
		{
			//153%10=3
			//5
			//1
			rem=num%10;
			
			//3*3*3=27
			//125
			//1=153
			sum=sum+(rem*rem*rem);
			
			//153/10
			//15/10
			//1/10
			
			num=num/10;
			
		}
		System.out.println("The Sum is "+sum);
		if(temp==sum)
		{
			System.out.println("The Number is ArmStrong number"+sum);
		}
		else
		{
			System.out.println("The Number is Not ArmStrong number"+sum);
		}
		
	}
	
}




