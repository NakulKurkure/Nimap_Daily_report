package com;

public class EvenNumbers {

	public static void main(String[] args) {
		
		int arr[]= {0,1,4,5,7,9};
		int sum=0;
		
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]%2==0 && i%2==0)
			{
//				0+0=0
				sum=sum+arr[i];
			}
			else
			{
				if(arr[i]%2!=0 && i%2!=0)
				{
					sum=sum+arr[i];
				}
			}
			
		}
		
		System.out.println("Sum"+sum);
	}

}
