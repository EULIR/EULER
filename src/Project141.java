public class Project141 {
	public static void main(String[] args) {
		long ans = 0;
		long max = 1000000000000L;
		for (long i = 2; i < 10000; i++)
			for (long j = 1; j < i; j++) {
				if (i * i * i * j + j * j >= max)
					break;
				if (Library.gcd(i, j) > 1)
					continue;
				for (long k = 1; ; k++) {
					long m = k * k * i * i * i * j + k * j * j;
					if (m >= max) break;
					if (Library.isSquare(m))
						ans += m;
				}
			}

		System.out.println(ans);
	}
}
