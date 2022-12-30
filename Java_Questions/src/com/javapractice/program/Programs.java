package com.javapractice.program;

public class Programs {

	public static void main(String[] args) {
//Duplicate Characters By Count
		String str = "ShekharSumann";

		for (int i = 0; i <= str.length() - 1; i++) {

			for (int j = i + 1; j <= str.length() - 1; j++) {
				int count = 1;

				if (str.charAt(i) == str.charAt(j)) {
					count = count + 1;
					System.out.println(str.charAt(i) + "Count" + count);
				}

			}
		}

	}

}
