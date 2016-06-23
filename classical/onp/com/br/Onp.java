package onp.com.br;

import java.util.Scanner;
import java.util.Stack;

public class Onp {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String string = new String();
		int t = scanner.nextInt();

		// t [the number of expressions <= 100]
		while (t > 0 && t <= 100) {

			// detects strings of input
			string = scanner.next();
			// opens a stack
			Stack stack = new Stack();
			// string
			String rnp = new String();
			// returns the number of the length of the string
			int length = string.length();
			// character variable (to keep the characters)
			char c;
			//loop to verify the string and respective symbols
			for (int k = 0; k < length; k++) {
				c = string.charAt(k);
				switch (c) {
				case '(':
					break;

				case '+':
					stack.push(c);
					break;

				case '-':
					stack.push(c);
					break;

				case '*':
					stack.push(c);
					break;

				case '/':
					stack.push(c);
					break;

				case '^':
					stack.push(c);
					break;

				case ')':
					rnp = rnp + stack.pop();
					break;

				default:
					rnp = rnp + c;
					break;
				}
			}
			System.out.println(rnp);
			t--;
		}
		scanner.close();
	}
}
