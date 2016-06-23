package sequence.com.br;

import java.io.*;

public class CMPLS {
	
    public static void main(String[] args) {
        try{
        
        //input a txt file (Better to see the test and the result)
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        //Numbers of the lines
        int T = Integer.parseInt(input.readLine());
        CMPLS solver = new CMPLS();
        for (int i = 0; i < T; i++) {
            int[] sc = IOUtils.readLinearIntArray(input);
            //Creates an array with the sequence
            int[] seq = new int[sc[0]];
            seq = IOUtils.readLinearIntArray(input);
            //sc[1] is the numbers of the numbers to find 
            solver.solve(sc[0],sc[1],seq);
            System.out.println();
        }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void solve(int S,int C,int[] seq){

    	//cria uma array bi dimensional sequence.length and sequence + numbers to find
        int[][] dp = new int[S][S+C];
        int index = 0;
        boolean skip = true;
        int rowAbv = S;

        for (int i = 0; i < S ; i++) {
            dp[0][i] = seq[i];
        }
        for (int i = 1; i < S; i++) {
            skip = true;
            for (int j = 0; j < rowAbv-1; j++) {
                dp[i][j] = dp[i-1][j+1] - dp[i-1][j];
                //If not the Pmin returns false
                if(j != 0 && dp[i][j] != dp[i][j-1]){
                    skip = false;
                }
            }
            rowAbv--;
            if(skip){
                index = i;
                break;
            }
        }
        for (int j = rowAbv; j < rowAbv+C ; j++) {
            dp[index][j] = dp[index][j-1];
        }

        rowAbv++;
        for (int i = index-1; i >= 0 ; i--) {
            for (int j = rowAbv; j < rowAbv+C ; j++) {
                dp[i][j] = dp[i][j-1] + dp[i+1][j-1];
            }
            rowAbv++;
        }
        for (int i = S; i < S+C ; i++) {
            System.out.print(dp[0][i] + " ");
        }
    }

    //Throw the values to the array
    static class IOUtils{
        public static int[] readLinearIntArray(BufferedReader in)throws IOException {
            String[] arr = in.readLine().split(" ");
            int[] array = new int[arr.length];
            for (int i = 0; i < arr.length; i++)
                array[i] = Integer.parseInt(arr[i]);
            return array;
        }
    }
}
