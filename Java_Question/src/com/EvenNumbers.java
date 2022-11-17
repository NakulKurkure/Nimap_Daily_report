package com;

public class EvenNumbers {

	public static void main(String[] args) {
		
		int arr[]= {11,22,33,44,55};
		
		System.out.println("The Even Numbers are:-\n");
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]%2==0)
			{
				System.out.println(arr[i]);
			}
		}
		
	}

}
