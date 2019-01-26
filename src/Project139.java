public class Project139 {
	public static void main(String[] args) {
		final long MAX_VALUE = 100000000;
		long ans = 0;
		long lim = (long) Math.sqrt(MAX_VALUE >> 1);
		for (long i = 2; i < lim; i++) {
			for (long j = 1; j < i; j++) {
				if (((j + i) % 2) == 1 && Library.gcd(i, j) == 1) {
					long a = 2 * i * j;
					long b = i * i - j * j;
					long c = i * i + j * j;
					long p = a + b + c;
					if (c % (b - a) == 0)
						ans += MAX_VALUE / p;
				}
			}
		}
		System.out.println(ans);
	}
}
