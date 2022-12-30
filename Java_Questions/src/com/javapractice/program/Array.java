package com.javapractice.program;

public class Array {

	public static void main(String[] args) {

		int arr[] = { 1, 10, 4, 2, 6, 9, 0 };
		int max = arr[0];
		for (int i = 0; i <= arr.length - 1; i++) {

			if (i >= 1 && i <= 5) {

				if (arr[i] > max) {

					max = arr[i];
				}

			}
		}
		System.out.println(max);

	}

}
