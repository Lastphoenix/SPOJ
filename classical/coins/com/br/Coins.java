package coins.com.br;

import java.io.*;

public class Coins {

	static long dp[] = new long[1000000];
	public static void main(String args[]) throws IOException
	{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		long n = 1000000;
		long i;
		for(i=1;i<n;i++)
		{
			long r = dp[(int)i/2]+dp[(int) (i/3)]+dp[(int) (i/4)];
			dp[(int) i] = Math.max(i,r);
		}
		
		
		while(true){
			try{
				String s = stdin.readLine();
				n = Long.parseLong(s);
			}
			catch(Exception e)
			{
				break;
			
			}
		
			System.out.println(for_gre(n));

		}
		
	}
	public static long for_gre(long n)
	{
		if(n==0)return 0;
		else if(n<1000000 && dp[(int) n]!=0)return ( dp[(int) n]);
		else return Math.max(n,for_gre(n/2)+for_gre(n/3)+for_gre(n/4));
		
	}
}
