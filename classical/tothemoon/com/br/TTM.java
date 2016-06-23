package tothemoon.com.br;

import java.io.*;
import java.util.*;

/*http://www.spoj.com/problems/TTM/
Problem 11470*/

public class TTM {

	private static NavigableMap<Integer, long[]> map = new TreeMap<Integer, long[]>();
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int tmp = 0;
		String[] s = br.readLine().split(" ");
		int size = Integer.parseInt(s[0]);
		int op = Integer.parseInt(s[1]);
		String[] num = br.readLine().split(" ");
		long[] z = stl(num);
		map.put(tmp, z);
		
		while (op > 0) {

			String[] st = br.readLine().split(" ");
			String c = st[0];
			
			if (c.equals("C")) {
				
				int l = Integer.parseInt(st[1]);
				int r = Integer.parseInt(st[2]);
				long d = Long.parseLong(st[3]);
				long[] a = Arrays.copyOf(map.get(tmp), size);
					for (int i = l - 1; i < r; i++){
						a[i] += d;}
				tmp++;
				map.put(tmp, a);
				
			} if (c.equals("Q")) {
				
				int l = Integer.parseInt(st[1]);
				int r = Integer.parseInt(st[2]);
				out.println(sum(map.get(tmp), l, r));
				
			} if (c.equals("H")) {
				
				int l = Integer.parseInt(st[1]);
				int r = Integer.parseInt(st[2]);
				int t = Integer.parseInt(st[3]);
				out.println(sum(map.get(t), l, r));
				
			} if (c.equals("B")) {tmp = Integer.parseInt(st[1]);}
			op--;
			out.flush();
		}
	}
	
    private static long sum(long[] a, int l, int r){
		
    	long sum = 0;
    		for (int i = l - 1; i < r; i++){
    			sum += a[i];
    			}
 		return sum;
	}

	private static long[] stl(String[] b){
    	
        long[] a = new long[b.length];
        	for (int i = 0; i < b.length; i++) {
        		a[i] = Long.parseLong(b[i]);
        		}
        return a;
    }
}