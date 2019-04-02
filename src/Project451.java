import java.util.stream.IntStream;

public class Project451 {
	public static long fun(int n, int[] fac) {
		if (fac[n] == n)
			return 1;
		for (long i = n - fac[n]; i > (n >> 1) - 1; i -= fac[n]) {
			long a = i * i, b = 2 * i;
			if (i + 2 != n && ((a + b) % n == 0))
				return i + 1;
			if ((a - b) % n == 0)
				return i - 1;
		}
		return 1;
	}

	public static void main(String[] args) {
		final int size = 20000000;
		int[] factor = IntStream.range(0, size + 1).toArray();
		for (int i = 2; i < factor.length; i++) {
			if (factor[i] == i) {
				int j = 2 * i;
				while (j < factor.length) {
					factor[j] = i;
					j += i;
				}
			}
		}
		long ans = IntStream.rangeClosed(3, size).mapToLong(i -> fun(i, factor)).sum();
		System.out.println(ans);
	}
}
