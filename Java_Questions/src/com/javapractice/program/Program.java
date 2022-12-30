package com.javapractice.program;

import java.util.Arrays;

public class Program {

	public static void main(String[] args) {
		// Duplicate Elements are Removed...
		int arr[] = { 1, 2, 3, 4, 5, 1, 4 };

		Arrays.sort(arr);
		for (int i = 0; i <= arr.length - 1; i++) {
			System.out.println(arr[i]);
		}

		System.out.println("------------------");

		for (int i = 0; i < arr.length - 1; i++) {

			if (arr[i] == arr[i + 1]) {

				continue;
			} else {
				System.out.println(arr[i]);
			}
		}
	}
}