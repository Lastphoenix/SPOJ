package julka.com.br;

import java.math.BigInteger;
import java.util.Scanner;

public class Julka {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int tests = 10;
		
		while (tests > 0) {
			
			BigInteger applesTogether = scanner.nextBigInteger();
			BigInteger difference = scanner.nextBigInteger();
			BigInteger half = new BigInteger("2");
			
			BigInteger twoX = applesTogether.add(difference);
			BigInteger x = twoX.divide(half);
			BigInteger y = x.subtract(difference);

			System.out.println(x);
			System.out.println(y);

			tests--;
		}
		scanner.close();
	}
}
