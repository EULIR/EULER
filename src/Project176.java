import java.util.stream.IntStream;

public class Project176 {
	static int c[];
	static int x[];
	static double log[];
	static long min = Long.MAX_VALUE;
	static double mlg = Math.log(min);

	public static void main(String args[]) {
		int n = args.length == 0 ? 47547 : Integer.parseInt(args[0]);
		int m = 2 * n + 1;
		c = new int[m + 1];
		x = new int[m + 1];
		log = new double[m + 1];
		for (int i = 1; i <= m; i++) log[i] = Math.log(i);
		for (int i = 2; i <= m; i++) {
			if (c[i] == 0) {
				for (int j = i; j <= m; j += i) {
					c[j] = i;
				}
			}
		}
		c[m] = m + 5;
		IntStream.iterate(m - 1, i -> i >= 2, i -> i - 1).forEach(i -> {
			if (c[i] == i) {
				x[i] = i;
			} else {
				x[i] = x[i + 1];
			}
		});
		for (int i = 1; i <= m; i += 2)
			if (m % i == 0) {
				int e = (i - 1) >> 1;
				if (e > 0) e++;
				func(m / i, 1L << e, e * log[2], 3, m / i);
			}
	}

	public static void func(int m, long prod, double lg, int f, int max) {
		if (lg > mlg) return;
		if (m == 1) {
			min = prod;
			mlg = lg;
			System.out.println(min);
		} else for (int i = 3; i <= max; i += 2)
			if (m % i == 0) {
				long p = 1;
				int e = (i - 1) >> 1;
				for (int j = 0; j < e; j++) p *= f;
				func(m / i, prod * p, lg + e * log[f], x[f + 1], i);
			}
	}
}