public class Project218 {
	public static void main(String[] args) {
		long max = 100000000;
		long ans = 0;
		for (long i = 1; i <= 10000; i++)
			for (long j = 1; j < i && (i * i + j * j) <= max; j++) {
				long m = i * i - j * j;
				long n = 2 * j * i;
				if ((m + n) % 2 == 1 && Library.gcd(m, n) == 1 && !(m * n % 4 == 0 &&
						((m * m - n * n) % 7 == 0 || (m * n) % 7 == 0) &&
						((m * m - n * n) % 3 == 0 || (m * n) % 3 == 0)))
					ans++;
			}
		System.out.println(ans);
	}
}