package com.javapractice;

public class MissingElement {

	public static void main(String[] args) {
		
		int a[]= {10,11,12,13,15};
		int sum=0;
		
		int expectedNoOfElements;
		for(int i=0;i<a.length;i++)
		{
			System.out.println(a[i]);
		}
		
		for(int i=0;i<a.length;i++)
		{
			sum=sum+a[i];
		}
		System.out.println("Sum is a[i]="+sum);
	
		expectedNoOfElements=a.length+1;
		
		System.out.println(expectedNoOfElements);
		
		int total_sum=expectedNoOfElements*(expectedNoOfElements+1)/2;
		System.out.println("expectedNoOfElements sum is "+total_sum);
		
		int sum1=total_sum-sum;
		System.out.println(sum1);
		
		
		
		
		
		
	}

}
