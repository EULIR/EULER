import java.math.BigInteger;

public class Project114 {
	public static BigInteger combination(BigInteger m, BigInteger n) {
		BigInteger ans = BigInteger.ONE;
		BigInteger b = BigInteger.ONE;
		if (m.compareTo(n.subtract(m)) > 0)
			m = n.subtract(m);
		for (BigInteger i = BigInteger.ONE; i.compareTo(m) <= 0; i = i.add(BigInteger.valueOf(1))) {
			ans = ans.multiply(n.subtract(m).add(i));
			b = b.multiply(i);
			if (ans.mod(b).compareTo(BigInteger.ZERO) == 0) {
				ans = ans.divide(b);
				b = BigInteger.ONE;
			}
		}
		return ans.divide(b);
	}

	public static void main(String[] args) {

	}
}
