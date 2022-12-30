package com.javapractice.program;

public class ArrayProgram {

	public static void main(String[] args) {

//		index 2 to 6
//		find max value
		int arr[] = { 1, 10, 4, 2, 6, 9, 0 };

		for (int i = 0; i < arr.length - 1; i++) {

			if (i >= 2 && i <= 6) {
				if (arr[i] < arr[i + 1]) {
					arr[0] = arr[i + 1];
				}
			}

		}
		System.out.println(arr[0]);

	}

}