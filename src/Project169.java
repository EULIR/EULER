import java.math.BigInteger;

public class Project169 {
	private static long[] arr;

	public static void main(String[] args) {
		arr = new long[Integer.MAX_VALUE / 17];
		arr[0] = arr[1] = 1;
		for (int i = 2; i < arr.length; i++) {
			if (i % 2 == 0)
				arr[i] = arr[i / 2] + arr[(i - 2) / 2];
			else arr[i] = arr[(i - 1) / 2];
		}
		System.out.println(f(new BigInteger("10000000000000000000000000")));
	}

	public static Long f(BigInteger big) {
		if (big.compareTo(BigInteger.valueOf(Integer.MAX_VALUE / 17)) < 0)
			return arr[Integer.parseInt(big.toString())];
		//System.out.println(big.toString());
		if (big.equals(BigInteger.ZERO) || big.equals(BigInteger.ONE))
			return 1L;
		if (big.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
			BigInteger a = big.divide(BigInteger.valueOf(2));
			BigInteger b = (big.subtract(BigInteger.valueOf(2))).divide(BigInteger.valueOf(2));
			return f(a) + f(b);
		}
		return f((big.subtract(BigInteger.ONE)).divide(BigInteger.valueOf(2)));
	}
}
