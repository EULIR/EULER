import java.math.BigInteger;

public class Project121 {
	public static long[] polyMultiply(long[] a, long[] b) {
		long[] newPoly = new long[a.length + b.length - 1];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				newPoly[i + j] += a[i] * b[j];
			}
		}
		return newPoly;
	}

	/*
	 * (x+1)(x+2)(x+3)...(x+15)=
	 * a1*x^15 + a2*x^14 + a3*x^13 + ... + a15*x^1 + a16*x^0
	 * a1+a2+a3+...+a8 = sum
	 * 16!=total
	 * */
	public static void main(String[] args) {
		int n = 15;
		long[] formula = {1L};
		for (int i = 1; i <= n; i++) {
			formula = polyMultiply(formula, new long[]{i, 1});
		}
		long sum = 0;
		for (int i = n / 2 + 1; i < formula.length; i++) {
			sum += formula[i];
		}
		BigInteger total = BigInteger.ONE;
		for (int i = 1; i <= n + 1; i++) {
			total = total.multiply(BigInteger.valueOf(i));
		}
		//long total = IntStream.rangeClosed(1, n + 1).asLongStream().reduce(1, (a, b) -> a * b);
		System.out.println(total.divide(BigInteger.valueOf(sum)));
	}
}
