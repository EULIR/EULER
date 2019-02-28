import java.math.BigDecimal;

public class Project183 {
	public static void main(String[] args) {
		long sum = 0;
		for (int i = 5; i <= 10000; i++) {
			//System.out.println(M(i));
			sum += M(i);
		}
		System.out.println(sum);
	}

	public static long M(int n) {
		int k = (int) (n / Math.E);
		BigDecimal t1 = BigDecimal.valueOf((double) n / k).pow(k);
		int m = k + 1;
		BigDecimal t2 = BigDecimal.valueOf((double) n / m).pow(m);
		return t1.compareTo(t2) > 0 ? deno(n, k) : deno(n, m);

	}

	public static int deno(int n, int k) {
		int denominator = k / Library.gcd(n, k);
		while (denominator % 2 == 0)
			denominator /= 2;
		while (denominator % 5 == 0)
			denominator /= 5;
		return denominator == 1 ? -n : n;
	}
}
