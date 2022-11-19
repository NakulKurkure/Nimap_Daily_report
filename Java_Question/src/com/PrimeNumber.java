package com;

public class PrimeNumber {

	public static void main(String[] args) {
		
		
		int num=7;
		int count = 0;
		for(int i=1;i<=num;i++)
		{
			if(num%i==0)
			{
				System.out.println(count++);
			}
		}

		if(count==2)
		{
			System.out.println("This is Prime Number..");
		}else
		{
			System.out.println("This is Not Prime Number..");

		}
		
	}

}
