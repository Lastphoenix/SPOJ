package helpingigor.com.br;

/*http://www.spoj.com/problems/IGOR/
 * 
 * Judge (8) Wrong answer... WHY?? 
*/	
import java.util.*;

public class IGOR {

	private static char proton = '+';
	private static char electron = '-';

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();

		for (int i = 1; i <= tests; i++) {

			int length = sc.nextInt();
			int queries = sc.nextInt();
			int lengthMinusOne = length - 1;
			String simulariumChain = sc.next();
			
			System.out.println("Experiment #" + i + ":");
			int x = (int) Math.pow(2, length) - 1;

			for (int j = 0; j < queries; j++) {

				int ki = sc.nextInt();
				
				if (length == 1) {
					if(ki == 0) {
						System.out.println(simulariumChain);
					} else {
						System.out.println(proton);
					}
				} else {
					chainTransformation(x, ki, simulariumChain, lengthMinusOne);
				}
			}
		}
		sc.close();
	}

	private static void chainTransformation(int twoPow, int ki, String s, int length) {

		List<char[]> list = new ArrayList<char[]>();
		StringBuilder stb = new StringBuilder();
		int temp = ki;
		int mod = 0;
		int y = 1;
		list.add(s.toCharArray());
		
		if (ki == 0) {
			System.out.println(s);
		} else {

			while(ki-- > 0) {

				char[] ans = new char[length + 1];
				
				if (y <= twoPow - 1) {
					
					mod = y;
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
					int r = twoPow + 1;
					mod = temp % r;
					break;
				}
				y++;
			}

			stb.append(list.get(mod));
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