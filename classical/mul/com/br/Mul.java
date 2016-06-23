package mul.com.br;

import java.math.BigInteger;
import java.util.Scanner;

/*
Input:
5
4 2
123 43
324 342
0 12
9999 12345

Output:
8
5289
110808
0
123437655
*/

public class Mul {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int tests = scanner.nextInt();

		while (tests > 0) {

			BigInteger n1 = scanner.nextBigInteger();
			BigInteger n2 = scanner.nextBigInteger();
			BigInteger result = n1.multiply(n2);

			System.out.println(result);	
			tests--;

		}
		scanner.close();
    }
}
