package trianglecentro.com.br;

import java.io.*;

/*Input

In the first line integer n - the number of test cases (equal to about 1000). The next n lines - 4 floating
point values: the length of side a, and distances from the centroid to sides a, b and c.

Output

n lines consisting of 2 floating point values with 3 digits after the decimal point: the area of the
triangle and the distance from the orthocenter to centroid.

"http://mathforum.org/kb/message.jspa?messageID=3617504"

Example

Input:
2
3.0 0.8660254038 0.8660254038 0.8660254038
657.8256599140 151.6154399062 213.5392629932 139.4878846649

Output:
3.897 0.000
149604.790 150.275
*/

public class TRICENTR {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(reader.readLine());
		
		while (tests > 0){
			
			double area;
			double[] x = pointsToArray(reader);
			if (x[0] == 0 || x[1] == 0){
				area = 0.000;
			}else{
				area = 3*x[0]*x[1]/2;
			}
			System.out.println(String.format("%.3f", area) + " " + String.format("%.3f", calculatedistance(x, area)));
			tests--;
		}
	}
	
	private static double calculatedistance(double[] x, double y) {
		
		double distance;
		double a = x[0];
		double a1 = x[2];
		double a2 = x[3];
		double fraction = (double) 2/3;
		double b = fraction*y/a1;
		double c = fraction*y/a2;
		double first = (9*a*a*b*b*c*c/(16*y*y));
		double second = ((a*a)+(b*b)+(c*c));
		if (first == second || second > first || y == 0){
			distance = 0.000;
		} else {
			distance = fraction * Math.sqrt(first - second);
		}
		return distance;
	}

	private static double[] pointsToArray(BufferedReader in) throws IOException {
		String[] arr = in.readLine().split(" ");
		double[] array = new double[arr.length];
		for (int i = 0; i < arr.length; i++)
			array[i] = Double.parseDouble(arr[i]);
		return array;
	}
}