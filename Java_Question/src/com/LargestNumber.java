package com;

public class LargestNumber {

	public static void main(String[] args) {
		
		int arr[]= {11,22,33,44,55};
		//22>11
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]>arr[0])
			{
				arr[0]=arr[i];
			}
		}
		System.out.println("The Largest Number is"+arr[0]);
		
	}

}
