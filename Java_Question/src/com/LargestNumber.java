package com;

public class LargestNumber {

	public static void main(String[] args) {
		
		int arr[]= {11,33,22,44,55,55};
		//22>11
		int temp;
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]<arr[j])
				{
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
			
		}
		
		
		
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
	
		
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]==arr[j])
				{
					if(true)
					{
						System.out.println("Delete the elements"+arr[i]);
					}
				}
			}
		}
		System.out.println("The Largest Number is"+arr[1]);
		
	}

}
