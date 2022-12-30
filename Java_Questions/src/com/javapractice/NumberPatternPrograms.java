package com.javapractice;

class number {
	public void num1(int a, int b) {
		int c = a + b;
	}
}

public class NumberPatternPrograms {

	public static void main(String[] args) {

//		for(int i=0;i<5;i++)
//		{
//			for(int j=0;j<i;j++)
//			{
//				System.out.print(i);
//			}
//			System.out.println();
//		}

//		for(int i=1;i<=5;i++)
//		{
//
//			for(int j=i;j>=1;j--)
//			{
//				System.out.print(j);
//			}
//			System.out.println();
//		}

//		for (int i = 0; i < 5; i++) {
//			for (int j = 0; j < 5; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}

		int arr[] = { 11, 22, 33, 0, 0, 0 };
		int temp = 0;
		for (int i = 0; i < arr.length; i++) {

			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;

				}
			}

		}

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

}