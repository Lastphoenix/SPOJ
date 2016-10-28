package helpingigor.com.br;

/*http://www.spoj.com/problems/IGOR/
*/	
import java.io.*;
import java.util.*;

public class IGOR {

	private static char proton = '+';
	private static char electron = '-';

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(br.readLine());

		for (int i = 1; i <= tests; i++) {

			String[] input = br.readLine().split(" ");
			int length = Integer.parseInt(input[0]) - 1;
			int queries = Integer.parseInt(input[1]);
			String simulariumChain = br.readLine();
			System.out.println("Experiment #" + i + ":");
			int x = (int) Math.pow(2, Integer.parseInt(input[0])) - 1;

			for (int j = 0; j < queries; j++) {

				int ki = Integer.parseInt(br.readLine());
				chainTransformation(x, ki, simulariumChain, length);

			}
		}
	}

	private static void chainTransformation(int twoPow, int ki, String s, int length) {

		List<char[]> list = new ArrayList<char[]>();
		StringBuilder stb = new StringBuilder();
		int temp = ki;
		int y = 1;
		list.add(s.toCharArray());
		
		if (ki == 0) {
			System.out.println(s);
		} else {

			while(ki-- > 0) {

				char[] ans = new char[length + 1];
				
				if (y <= twoPow - 1) {
					
					char[] c = Arrays.copyOf(list.get(y - 1), length + 1);
				
					if (c[0] == proton) {
					
						c[length] = firstRule(c[length]);
						ans = moveArray(c);
						ans[length] = firstRule(ans[length]);
						list.add(ans);
					
					} else {

						ans = moveArray(c);
						ans[length] = firstRule(ans[length]);
						list.add(ans);
					}
				} else {
					temp = temp % twoPow;
					break;
				}
				y++;
			}

			stb.append(list.get(temp));
			System.out.println(stb);
		}
	}

	private static char firstRule(char c) {

		if (c == proton) {
			c = electron;

		} else {
			c = proton;
		}
		return c;
	}
	
	private static char[] moveArray(char[] c) {

		char temp = c[0];
		char[] newCharArray = new char[c.length];
		
		System.arraycopy(c, 1, newCharArray, 0, c.length - 1);
		newCharArray[c.length - 1] = temp;

		return newCharArray;
	}
}