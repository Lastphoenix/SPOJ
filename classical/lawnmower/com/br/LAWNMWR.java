package lawnmower.com.br;

import java.util.*;

/* Problem Lawn Mower 10080 --> http://www.spoj.com/problems/LAWNMWR/
 * 
 */

public class LAWNMWR {

	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(System.in);
		int t = 1000000000;

		while (t > 0) {

			int nx = scanner.nextInt();
			int ny = scanner.nextInt();

			if (nx == 0 && ny == 0) {
				scanner.close();
				return;
			}

			double w = scanner.nextDouble();
			scanner.nextLine();

			double x[] = pointsToArray(scanner);
			double y[] = pointsToArray(scanner);

			Arrays.sort(x);
			Arrays.sort(y);

			boolean a = goodJob(x, w, 75);
			boolean b = goodJob(y, w, 100);

			if ((a == true) && (b == true)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
			t--;
		}
	}

	private static boolean goodJob(double[] a, double w, double max) {

		boolean valid = (a[0] <= w/2) && ((max - a[a.length - 1]) <= w/2);
		
		for (int i = 0; i < a.length - 1 && valid; i++) {
				if (a[i+1] - a[i] > w) {
					valid = false;
			}
		}
		return valid;
	}

	private static double[] pointsToArray(Scanner scanner) {

		String[] arr = scanner.nextLine().split(" ");
		double[] array = new double[arr.length];

		for (int i = 0; i < arr.length; i++) {
			array[i] = Double.parseDouble(arr[i]);
		}

		return array;
	}
}