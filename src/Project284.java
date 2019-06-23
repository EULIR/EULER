import java.math.BigInteger;

public class Project284 {
	public static void main(String[] args) {
		int L = 10000;
		int len = 1;
		int len2;
		BigInteger seed = new BigInteger("7");
		BigInteger seed2;
		String s = "";
		while (len < L) {
			seed = getNext(seed);
			s = seed.toString(14);
			len = s.length();
		}
		seed2 = bigPow(14, len).subtract(seed).add(BigInteger.ONE);
		String s2 = seed2.toString(14);
		len2 = s2.length();
		if (len2 < L) {
			seed2 = getNext(seed2);
			s2 = seed2.toString(14);
			len2 = s2.length();
		}
		long sum = 1;
		long sumDigs1 = 0;
		long sumDigs2 = 0;
		for (int i = 1; i <= L; i++) {
			int dig1 = Integer.parseInt(s.substring(len - i, len - i + 1), 14);
			int dig2 = Integer.parseInt(s2.substring(len2 - i, len2 - i + 1), 14);
			if (dig1 != 0) sum += sumDigs1 += dig1;
			if (dig2 != 0) sum += sumDigs2 += dig2;
		}
		System.out.println(Long.toString(sum, 14));
	}

	public static BigInteger getNext(BigInteger n) {
		int pow = n.toString(14).length();
		BigInteger next = BigInteger.valueOf(3).multiply(bigPow(n, 2)).subtract(BigInteger.valueOf(2).multiply(bigPow(n, 3)));
		BigInteger mod = bigPow(14, 2 * pow);
		BigInteger k = next.multiply(BigInteger.valueOf(-1)).divide(mod);
		next = next.add(mod.multiply(k)).add(mod);
		return next;
	}

	public static BigInteger bigPow(int a, int b) {
		return bigPow(BigInteger.valueOf(a), b);
	}

	public static BigInteger bigPow(BigInteger a, int b) {
		BigInteger prod = BigInteger.ONE;
		for (int i = 0; i < b; i++)
			prod = prod.multiply(a);
		return prod;
	}
}
