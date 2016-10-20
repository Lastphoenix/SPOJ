package addrev.com.br;

import java.util.Scanner;

public class Addrev {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int tests = scanner.nextInt();
		
		
		while (tests > 0){
			
			int number1 = scanner.nextInt();
			int number2 = scanner.nextInt();

			//Reversing the number
			int reverseNumber1 = reverse(number1);
			int reverseNumber2 = reverse(number2);
			
			//Sum reverse number
			int sumreverse = reverseNumber1 + reverseNumber2;
			
			//Reverse the sum
			int sum = reverse(sumreverse);
			
			//Printing
			System.out.println(sum);
			tests--;
		}
		scanner.close();
	}
	private static int reverse(int n){
		int reverse = 0;
		
		while( n != 0 )
	      {
	          reverse = reverse * 10;
	          reverse = reverse + n%10;
	          n = n/10;
	      }
		return reverse;
	}
}
