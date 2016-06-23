package nsteps.com.br;

import java.util.Scanner;

public class Nsteps {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int tests = scanner.nextInt();

		while (tests > 0) {

			int x = scanner.nextInt();
			int y = scanner.nextInt();

			if (x == y || x - y == 2) {

				if (x == 1 && y == 1) {
					System.out.println(x);
					break;
				}
				if (x % 2 == 0) {
					System.out.println(x + y);
				} else {
					System.out.println(x + y - 1);
				}
			} else {
				System.out.println("No Number");
			}
			tests--;
		}
		scanner.close();
	}
}
