package tetra.com.br;

import java.io.*;

public class TETRA {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(reader.readLine());

		while (tests > 0 ) {
			
			int[] x = pointsToArray(reader);
			double radius = 0;
			double a = Math.sqrt(6);
			double first = x[0];
			
			if (regularTetrahedron(x, first) == true){
				radius = (a*(first/12)); 
	    		if (radius == 0){
	    			System.out.println("0.0000");
	    		}else{
	    		System.out.println(String.format("%.4f", radius));
	    		}
			}
			if (regularTetrahedron(x, first) == false){
				
				if (calculateIrregularTetrahedron(x) == 0){
					System.out.println("0.0000");
				}else{
				System.out.println(String.format("%.4f", calculateIrregularTetrahedron(x)));
				}
			}
			tests--;
		}
	}
	
    private static double calculateIrregularTetrahedron(int[] g) {
    	
    	double W = g[0];
    	double V = g[1];
    	double u = g[2];
    	double U = g[3];
    	double v = g[4];
    	double w = g[5];
    	double X = (w - U + v)*(U + v + w);
    	double x = (U - v + w)*(v - w + U);
    	double Y = (u - V + w)*(V + w + u);
    	double y = (V - w + u)*(w - u + V);
    	double Z = (v - W + u)*(W + u + v);
    	double z = (W - u + v)*(u - v + W);
    	double semiperimeter1 = (U + V + W)/2;
    	double semiperimeter2 = (u + v + W)/2;
    	double semiperimeter3 = (v + w + U)/2;
    	double semiperimeter4 = (u + w + V)/2;
    	double faceArea1 = Math.sqrt(semiperimeter1*(semiperimeter1-U)*(semiperimeter1-V)*(semiperimeter1-W));
    	double faceArea2 = Math.sqrt(semiperimeter2*(semiperimeter2-u)*(semiperimeter2-v)*(semiperimeter2-W));
    	double faceArea3 = Math.sqrt(semiperimeter3*(semiperimeter3-v)*(semiperimeter3-w)*(semiperimeter3-U));
    	double faceArea4 = Math.sqrt(semiperimeter4*(semiperimeter4-u)*(semiperimeter4-w)*(semiperimeter4-V));
    	double faceAreaTotal = faceArea1 + faceArea2 + faceArea3 + faceArea4;
    	double a = Math.sqrt(x*Y*Z);
    	double b = Math.sqrt(y*Z*X);
    	double c = Math.sqrt(z*X*Y);
    	double d = Math.sqrt(x*y*z);
    	double e = 192*u*v*w;
    	double f = Math.sqrt((-a + b + c + d)*(a - b + c + d)*(a + b - c + d)*(a + b + c - d));
       	double volume = f/e; 	
       	double radius = 3*volume/faceAreaTotal;
        return radius;
	}

	private static boolean regularTetrahedron(int[] x, double first) {
		
    	for(int i = 1; i < 6; i++)
    	{
    	  if (x[i] != first){
    		  return false;
    	  }
    	}
    	return true;
 	}

	private static int[] pointsToArray(BufferedReader in)throws IOException {
        String[] arr = in.readLine().split(" ");
        int[] array = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            array[i] = Integer.parseInt(arr[i]);
        return array;
    }
}