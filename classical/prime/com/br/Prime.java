package prime.com.br;

import java.util.Scanner;

public class Prime {

	public static void main(String[] args) throws java.lang.Exception {

		Scanner sc = new Scanner(System.in);

		int c = sc.nextInt();
		int count = 0;
		
		while (sc.hasNext()) {

			if (count <= c) {

				int a = sc.nextInt();
				int b = sc.nextInt();
				
				for (int i = a; i <= b; i++) {
			           if (primeNumber(i)) {
			               System.out.println(i);
			           }
				}
				count++;
			}
			  else {
				sc.close();
			}
		}
	}
	
	public static boolean primeNumber(int n) {
		if (n <= 1) {
			return false;
		}
		for (int j = 2; j <= Math.sqrt(n); j++) {
			if (n % j == 0) {
				return false;
			}
		}
		return true;
	}
}
