package strhh.com.br;

import java.util.Scanner;

/*Given a sequence of 2*k characters, please print every second character from the first half of the sequence. Start printing with the first character.
Input

In the first line of input your are given the positive integer t (1<=t<=100) - the number of test cases. In the each of the next t lines, you are given a sequence of 2*k (1<=k<=100) characters.
Output

For each of the test cases please please print every second character from the first half of a given sequence (the first character should appear).
Example

Input:
4
your 
progress 
is 
noticeable

Output:
y
po
i
ntc*/

public class Strhh {

	public static void main(String[] args) throws java.lang.Exception {

		Scanner scanner = new Scanner(System.in);
		int numberOfTests = scanner.nextInt();
		
		for(int i = 0; i < numberOfTests; i++){
			
			String string = scanner.next();
			int lengthOfTheString = string.length();
			char[] carr = string.toCharArray();
			
			for (int j = 0; j < lengthOfTheString/2;j++){
				if ( j % 2 == 0 || j == 0){
					System.out.print(carr[j]);
				}
			}
			System.out.println();
		}
		scanner.close();
	}
}
