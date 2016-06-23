package feynman.com.br;

import java.util.Scanner;

public class Samer08f {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		while (true) {
			
			int number = scanner.nextInt();
			
			if (number != 0){
			int result = number * (number + 1) * ((2 * number) + 1) / 6;
			System.out.println(result);
			}else{ break;}
			
		}
		scanner.close();
	}
}