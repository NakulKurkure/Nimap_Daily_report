package com;

public class FindDuplicateNumber {

	public static void main(String[] args) {
	
		
		int arr[]= {11,22,33,44,55,11};
		int temp;
		
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr.length;j++)
			{
				if(arr[i]<arr[j])
				{
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
					
				}
			}
		}
		
		System.out.println("The Asending Number of array is :-\n");
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
			
		System.out.println("The Duplicate Number of array is :-\n");
		
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]==arr[j])
				{
					System.out.print(arr[i]);
				}
			}
		}
		
		
	}

	
	
}
