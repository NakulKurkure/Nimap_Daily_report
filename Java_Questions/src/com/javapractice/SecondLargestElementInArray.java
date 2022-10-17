package com.javapractice;

public class SecondLargestElementInArray {

	public static void main(String[] args) {
		
//		1.Find Second largest element in an array : arr[] = [12, 35, 1, 10, 34, 1]
		
		int a[]= {12,35,1,10,34,1};
		int temp=0;
		//Asending Order
		for(int i=0;i<a.length;i++)
		{
			for(int j=i+1;j<a.length;j++)
			{
				//55>11
				if(a[i]>a[j])
				{
					temp=a[i];//temp=55
					a[i]=a[j];//a[i]=11
					a[j]=temp;//a[j]=55
				}
				
			}
		}
		
		for(int i=0;i<a.length;i++)
		{
			
				System.out.println(""+a[i]);
			
		}
		
		System.out.println("2nd Largest Element is "+a[4]);

	}

}
