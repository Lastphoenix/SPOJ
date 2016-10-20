package factorial2.com.br;

import java.math.BigInteger;
import java.util.Scanner;

public class Fctrl2 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int tests = scanner.nextInt();
		
		while (tests > 0) {
			
			int factorial = scanner.nextInt();
			BigInteger result = new BigInteger("1");
			
				for (int i = 1; i <= factorial; i++){
					result = result.multiply(BigInteger.valueOf(i));
					}
			System.out.println(result);	
			tests--;
		}
		scanner.close();
	}
}
