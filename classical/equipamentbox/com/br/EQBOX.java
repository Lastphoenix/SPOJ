package equipamentbox.com.br;

import java.io.*;

public class EQBOX {

	static String escape = "Escape is possible.";
	static String notEscape = "Box cannot be dropped.";
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter print = new PrintWriter(new BufferedOutputStream(System.out));

		int tests = Integer.parseInt(reader.readLine());
		
		while(tests-- > 0) {
		
			int[] points = pointsToArray(reader);
			solve(points, print);
		}
		print.flush();
	}
	
	private static int[] pointsToArray(BufferedReader in) throws Exception {
		
		String[] arr = in.readLine().split(" ");
		int[] array = new int[arr.length];
		
		for (int i = 0; i < arr.length; i++)
			array[i] = Integer.parseInt(arr[i]);
		
		return array;
	}
	
	private static void solve (int[] points, PrintWriter print){
		
		int a = points[0];
		int b = points[1];
		int x = points[2];
		int y = points[3];
		int temp;
		
		if (a>b){		
			temp=a;
			a=b;
			b=temp;
		}
		if(x>y){		
			temp=x;
			x=y;
			y=temp;
		}
		
		double d_b=(double)b;
		double d_x=(double)x;
		double d_y=(double)y;
		
		double temp1;
		temp1 = (2.0*d_x*d_y*d_b + (d_y*d_y - d_x*d_x)*(Math.sqrt(d_x*d_x + d_y*d_y - d_b*d_b)));
		temp1 = temp1 / (d_x*d_x + d_y*d_y);
		
	if ((a-temp1)>0.0000001 || (a>x && b>y))
       print.println(escape);
    else
       print.println(notEscape);
	}
}