package divsum.com.br;

import java.util.Scanner;

public class Divsum {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		int[] divisors = new int[500000];

		for (int i = 1; i < 500000; i++)
			for (int j = 2; j * i < 500000; j++)
				divisors[j * i] += i;
		while (tests > 0) {
			int number = sc.nextInt();
			System.out.println(divisors[number]);
			--tests;
		}
		sc.close();
	}
}
