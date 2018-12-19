import java.math.BigInteger;

public class Project119 {
	public static BigInteger digitalSum(BigInteger num) {
		BigInteger sum = BigInteger.ZERO;
		while (num.compareTo(new BigInteger(String.valueOf(10))) >= 0) {
			sum = sum.add(num.mod(BigInteger.valueOf(10)));
			num = num.divide(BigInteger.valueOf(10));
		}
		sum = sum.add(num);
		return sum;
	}

	public static boolean isPower(BigInteger power, BigInteger base) {
		boolean result;
		if (power.compareTo(BigInteger.ZERO) <= 0 || !power.mod(base).equals(BigInteger.ZERO))
			return false;
		if (power.divide(base).compareTo(BigInteger.ONE) > 0)
			result = isPower(power.divide(base), base);
		else result = power.mod(base).equals(BigInteger.ZERO);
		return result;
	}

	public static void main(String[] args) {
		BigInteger n = new BigInteger(String.valueOf(10));
		int i = 0;
		while (i < 30) {
			n = n.add(BigInteger.ONE);
			BigInteger digitSum = digitalSum(n);
			try {
				if (isPower(n, digitSum)) {
					i++;
					//System.out.println(n);
					//System.out.println(digitSum);
					//System.out.println(i);
					//System.out.println();
				}
			} catch (StackOverflowError ignored) {
			}
		}
		System.out.println(n);
	}
}
