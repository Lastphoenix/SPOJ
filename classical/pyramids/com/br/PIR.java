package pyramids.com.br;

import java.io.*;

public class PIR {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(reader.readLine());

		while (tests > 0) {

			int[] x = pointsToArray(reader);
			System.out.println(String.format("%.4f", calculateVolume(x)));

			tests--;
		}
	}

	private static double calculateVolume(int[] g) {

		double W = g[0];
		double V = g[1];
		double u = g[2];
		double U = g[3];
		double v = g[4];
		double w = g[5];
		double X = (w - U + v) * (U + v + w);
		double x = (U - v + w) * (v - w + U);
		double Y = (u - V + w) * (V + w + u);
		double y = (V - w + u) * (w - u + V);
		double Z = (v - W + u) * (W + u + v);
		double z = (W - u + v) * (u - v + W);
		double a = Math.sqrt(x * Y * Z);
		double b = Math.sqrt(y * Z * X);
		double c = Math.sqrt(z * X * Y);
		double d = Math.sqrt(x * y * z);
		double e = 192 * u * v * w;
		double f = Math.sqrt((-a + b + c + d) * (a - b + c + d) * (a + b - c + d) * (a + b + c - d));
		double volume = f / e;
		return volume;
	}

	private static int[] pointsToArray(BufferedReader in) throws IOException {
		String[] arr = in.readLine().split(" ");
		int[] array = new int[arr.length];
		for (int i = 0; i < arr.length; i++)
			array[i] = Integer.parseInt(arr[i]);
		return array;
	}
}
