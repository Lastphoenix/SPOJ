package pigbank.com.br;

import java.io.*;
import java.util.*;

class PIGBANK {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    String MIN_AMOUNT = "The minimum amount of money in the piggy-bank is %d.\n";
    String IMPOSSIBLE = "This is impossible.";
    int MAX_VALUE = 2000000000;

    void run() throws Exception {
    	
        int testcases = Integer.parseInt(in.readLine());
        while (testcases-- > 0) {
            solve();
        }
        out.flush();
    }

    void solve() throws Exception {
    	
        StringTokenizer tokenizer = new StringTokenizer(in.readLine());
        int totalWeight = -Integer.parseInt(tokenizer.nextToken()) +
                Integer.parseInt(tokenizer.nextToken());

        int[] minValues = new int[totalWeight+1];
        Arrays.fill(minValues, MAX_VALUE);
        minValues[0] = 0;

        int n = Integer.parseInt(in.readLine());
        
        for (int i = 0; i < n; i++) {
        	
            tokenizer = new StringTokenizer(in.readLine());
            int value = Integer.parseInt(tokenizer.nextToken());
            int weight = Integer.parseInt(tokenizer.nextToken());
            
            for (int j = weight; j <= totalWeight; j++) {
            	
               if (minValues[j-weight]+value < minValues[j])
                    minValues[j] = minValues[j-weight]+value;
                
            }
        }

        if (minValues[totalWeight] < MAX_VALUE)
            out.printf(MIN_AMOUNT, minValues[totalWeight]);
        else
            out.println(IMPOSSIBLE);
    }

    public static void main(String[] args) throws Exception {
        new PIGBANK().run();
    }
}
