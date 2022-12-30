package com.javapractice.program;

public class ArrayPrograms {

	public static void main(String[] args) {
		// Large Number in Array
		int arr[] = { 11, 22, 33, 44, 55 };

		for (int i = 0; i < arr.length - 1; i++) {

			if (arr[i] > arr[i + 1]) {
				arr[0] = arr[i];
			}
		}

		System.out.println(arr[0]);

	}

}
