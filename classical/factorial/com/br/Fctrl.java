package factorial.com.br;

import java.util.Scanner;

public class Fctrl {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int tests = scanner.nextInt();

		while (tests > 0) {

			long factorial = scanner.nextLong();

			trailingZeros(factorial);
			tests--;
		}
		scanner.close();
	}

	private static void trailingZeros(long num) {

		long count=0;
		double term=0;
		int i=0;
		while((term=num/Math.pow(5, ++i))>=1)
		{
			count+=term;
		}
		System.out.println(count);
	}
}
