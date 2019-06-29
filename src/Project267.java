import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.stream.IntStream;

public class Project267 {
	private static double[] arr1 = new double[1001];
	private static double[] arr2 = new double[1001];

	public static void main(String[] args) {
		BigInteger[][] C = new BigInteger[2][1001];
		int index = 1;
		for (int i = 0; i <= 1000; i++) {
			index = 1 - index;
			C[index][0] = C[index][i] = BigInteger.ONE;
			for (int j = 1; j < i; j++)
				C[index][j] = C[1 - index][j].add(C[1 - index][j - 1]);
		}
		double a = 0;
		double b = 1;
		for (int i = 0; i < 200; i++) {
			double c = (2 * a + b) / 3;
			double d = (a + 2 * b) / 3;
			if (func(c, C[index]).compareTo(func(d, C[index])) < 0)
				a = c;
			else b = d;
		}
		BigDecimal n = new BigDecimal(func(b, C[index]));
		BigDecimal d = new BigDecimal(BigInteger.ONE.shiftLeft(1000));
		System.out.println(n.divide(d, 12, RoundingMode.HALF_UP));
	}


	private static BigInteger func(double f, BigInteger[] C) {
		double p = 1 - f;
		double q = 1 + 2 * f;
		arr1[0] = arr2[1000] = 1;
		IntStream.rangeClosed(1, 1000).forEach(i -> {
			arr1[i] = arr1[i - 1] * p;
			arr2[1000 - i] = arr2[1001 - i] * q;
		});
		BigInteger ret = BigInteger.ZERO;
		for (int i = 0; i <= 1000; i++)
			if (arr1[i] * arr2[i] >= 1e9)
				ret = ret.add(C[i]);
		return ret;
	}
}
