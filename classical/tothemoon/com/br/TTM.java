package tothemoon.com.br;

import java.io.*;
import java.util.*;

/*http://www.spoj.com/problems/TTM/
Problem 11470

In java gives TLE...
The AC is in C++, after a long research i found no code in JAVA for this problem!
*/

public class TTM {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] firstLine = br.readLine().split(" ");
		int sizeOfArray = Integer.parseInt(firstLine[0]);
		int queries = Integer.parseInt(firstLine[1]);
		long[] array = new long[sizeOfArray];
		String[] inputArray = br.readLine().split(" ");
		Integer timestamp = 0;
		Map<Integer, long[]> map = new HashMap<Integer, long[]>();

		for (int i = 0; i < sizeOfArray; i++) {
			array[i] = Long.parseLong(inputArray[i]);
		}

		map.put(timestamp, array);

		while (queries-- > 0) {

			String[] queryInfo = br.readLine().split(" ");
			char c = Character.toUpperCase(queryInfo[0].charAt(0));
			long[] x = new long[sizeOfArray];
			long sum = 0;

			switch (c) {
			case 'C':

				int cl = Integer.parseInt(queryInfo[1]);
				int cr = Integer.parseInt(queryInfo[2]);
				int cd = Integer.parseInt(queryInfo[3]);
				x = Arrays.copyOf(map.get(timestamp), sizeOfArray);
				timestamp++;
				
				for (int i = cl - 1; i < cr; i++) {
					x[i] += cd;
				}
				map.put(timestamp, x);
				break;

			case 'Q':
				
				int ql = Integer.parseInt(queryInfo[1]) - 1;
				int qr = Integer.parseInt(queryInfo[2]);
				x = map.get(timestamp);
				sum = Arrays.stream(x, ql, qr).sum();
				System.out.println(sum);
				break;

			case 'H':
				
				int hl = Integer.parseInt(queryInfo[1]) - 1;
				int hr = Integer.parseInt(queryInfo[2]);
				int ht = Integer.parseInt(queryInfo[3]);
				x = map.get(ht);
				sum = Arrays.stream(x, hl, hr).sum();
				System.out.println(sum);
				break;
			
			case 'B':
				
				timestamp = Integer.parseInt(queryInfo[1]);
				break;
			}
		}
	}
}