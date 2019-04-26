import java.math.BigInteger;

public class Project192 {
	public static void main(String[] args) {
		int N = 100000;
		BigInteger ret = BigInteger.ZERO;
		int ubound = 1;
		for (int i = 2; i <= N; i++) {
			while (ubound * ubound < i)
				ubound++;
			if (ubound * ubound == i)
				continue;
			BigFraction upper = new BigFraction(ubound, 1);
			BigFraction lower = new BigFraction(ubound - 1, 1);
			BigFraction med = upper.freshSum(lower);
			while (med.inbound()) {
				if (med.compareSqr(i) == -1) {
					lower = med;
					med = upper.freshSum(lower);
				} else {
					upper = med;
					med = upper.freshSum(lower);
				}
			}
			med = upper.median(lower);
			ret = med.compareSqr(i) == -1 ? ret.add(upper.denominator) : ret.add(lower.denominator);
		}
		System.out.println(ret);
	}

}

class BigFraction {
	static final BigInteger MAX = BigInteger.valueOf(1000000000000L);

	BigInteger numerator;
	BigInteger denominator;

	BigFraction(long p, long q) {
		numerator = BigInteger.valueOf(p);
		denominator = BigInteger.valueOf(q);
	}

	BigFraction(BigInteger num, BigInteger denom) {
		this.numerator = num;
		this.denominator = denom;
	}

	BigFraction freshSum(BigFraction o) {
		return new BigFraction(numerator.add(o.numerator), denominator.add(o.denominator));
	}

	BigFraction median(BigFraction o) {
		return new BigFraction(numerator.multiply(o.denominator).add(o.numerator.multiply(denominator)), denominator.multiply(o.denominator).multiply(BigInteger.valueOf(2)));
	}

	public int compareSqr(int x) {
		return numerator.pow(2).compareTo(BigInteger.valueOf(x).multiply(denominator.pow(2)));
	}

	public boolean inbound() {
		return denominator.compareTo(MAX) <= 0;
	}

	@Override
	public String toString() {
		return numerator + "/" + denominator;
	}
}
