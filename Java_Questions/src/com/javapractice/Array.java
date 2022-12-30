package com.javapractice;

public class Array {

	public static void main(String[] args) {

		int arr[] = { 5, 545, 7, 9, 109, 0 };
		// 2
		int max = arr[0];

		for (int i = 0; i <= arr.length - 1; i++) {
			// 2>2 //545>2 //7>545 //9>545 //10>545 //2>545
			if (arr[i] > max) {
				// max=545

				max = arr[i];
			}

		}
		System.out.println(max);

	}

}