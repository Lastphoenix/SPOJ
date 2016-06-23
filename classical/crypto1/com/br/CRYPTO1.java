package crypto1.com.br;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.*;

public class CRYPTO1 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		long input = scanner.nextLong();
		long mod = 4000000007L;

		long attack = calculateDateOfAttack(input, mod);
		Date dateOfAttack = new Date(attack * 1000);

		SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss yyyy");
		System.out.println(dateFormat.format(dateOfAttack));
		scanner.close();
	}

	private static long calculateDateOfAttack(long input, long mod) {

		BigInteger exp = new BigInteger("1000000002");
		BigInteger bigInput = BigInteger.valueOf(input);
		BigInteger bigMod = BigInteger.valueOf(mod);
		BigInteger sub =  bigInput.modPow(exp, bigMod);
		BigInteger result = bigMod.subtract(sub);
		long x = result.longValue();
		return x;

	}
}