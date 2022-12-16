package com;

public class Program {

	public static void main(String[] args) {

		// Genreate Random Value
//		int a = 100;
////
//		Random random = new Random();
////
//		System.out.println(random.nextInt(a));

		// Comare Objects in Java
//		Program p = new Program();
//
//		System.out.println(p);
//
//		Program p1 = new Program();
//		System.out.println(p1);
//
//		System.out.println(p1.hashCode() == p.hashCode());
//		System.out.println(p.hashCode());

		// Widening (s to L) //ASCII Value
//		char ch = 'A';
//
//		int a = ch;
//
//		System.out.println(a);

		//
//		int a = 78;
//		int b = a * a;
//		System.out.println(b);
//
//		int c = (int) Math.sqrt(b);
//		System.out.println(c);
//
//		if (c == a) {
//			System.out.println("This number is Automorphic");
//		} else {
//			System.out.println("This number is NOt Automorphic");
//		}

		//
//		int arr[] = { 11, 22, 33, 44, 55 };
//		int arr2[] = new int[5];
//
//		for (int i = 0; i <= arr.length - 1; i++) {
//			arr2[i] = arr[i];
//		}
//
//		for (int i = 0; i <= arr.length - 1; i++) {
//			System.out.println(arr2[i]);
//		}

		int arr[] = { 11, 22, 22, 33, 33 };
		int count = 1;
		for (int i = 0; i <= arr.length - 1; i++) {
			for (int j = i + 1; j <= arr.length - 1; j++) {
				if (arr[i] == arr[j]) {
					count = count + 1;
					System.out.println(arr[i] + " " + count);
				}
			}

		}

		System.out.println("----------------");
		for (int i = 0; i < arr.length; i++) {

			System.out.println(arr[i] + " ");

		}

	}

}