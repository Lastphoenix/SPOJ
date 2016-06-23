package cpttrn1.com.br;

import java.util.Scanner;

/*
Input:
3
3 1
4 4
2 5

Output:
*
.
*

*.*.
.*.*
*.*.
.*.*

*.*.*
.*.*.*/

public class CPTTRN1 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int tests = scanner.nextInt();

		for (int i = 0; i < tests; i++) {

			int lines = scanner.nextInt();
			int columns = scanner.nextInt();

			for (int j = 0; j < lines; j++) {
				String matrix = "";
				for (int k = 0; k < columns; k++) {
					if (j % 2 == 0) {
						if (k % 2 == 0) {
							matrix += "*";
						} else {
							matrix += ".";
						}
					} else {
						if (k % 2 == 0) {
							matrix += ".";
						} else {
							matrix += "*";
						}
					}
				}
				System.out.println(matrix);
			}
			System.out.println("\n");
		}
		scanner.close();
	}
}