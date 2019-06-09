import java.util.stream.IntStream;

public class Project237 {
	public static void main(String[] args) {
		final long MAX = (long) Math.pow(10, 12);
		final long MOD = 3100000000L;
		final long LIMIT = MAX % MOD;
		final long LONG_MOD = (long) Math.pow(10, 8);
		long[] a = {1, 1, 4, 8, 0};
		for (long n = 5; n <= LIMIT; n++) {
			a[4] = 2 * a[3] + 2 * a[2] - 2 * a[1] + a[0];
			IntStream.range(0, 5).filter(i -> a[i] < 0).forEach(i -> a[i] = LONG_MOD + a[i]);
			a[4] %= LONG_MOD;
			System.arraycopy(a, 1, a, 0, 4);
		}
		System.out.println(a[4]);
	}
}
