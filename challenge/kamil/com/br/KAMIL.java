package kamil.com.br;

import java.util.*;

class Main {
	public static void main(String[] a) {
		Scanner t = new Scanner(System.in);
		for (int x = 0; x < 10; x++) {
			String s = t.next();
			int r = 1;
			for (char c : s.toCharArray()) {
				if (c == 'T' || c == 'D' || c == 'L' || c == 'F') {
					r *= 2;
				}
			}
			System.out.println(r);
		}
		t.close();
	}
}