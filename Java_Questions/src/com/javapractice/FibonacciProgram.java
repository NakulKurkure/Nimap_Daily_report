package com.javapractice;

public class FibonacciProgram {

	public static void main(String[] args) {

		//WAP to print Fibonacci series without recursion
		int a=0,b=1,c;
		
		for(int i=0;i<10;i++)
			{
			System.out.println(a);//a=0,1,1,2
			c=a+b;//c=1,2,3,5
			a=b;//a=1,1,2,3
			b=c;//b=1,2,3,5				
			}
		}
}