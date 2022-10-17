package com.javapractice;

public class FindDuplicateElementInArray {

	public static void main(String[] args) {

		//logic 1 
		
		int a[]= {11,22,33,44,55,11,22};
		for(int i=0;i<a.length;i++)
		{
			for(int j=i+1;j<a.length;j++)
			{
				if(a[i]==a[j])
				{
					System.out.println("Duplicate element of array is \n"+a[i]);
				}
			}
		}

	
		
		
		
		
	}

}
