public class Project510 {
	public static void main(String[] args) {
		long n = 1000000000;
		long ns = (long) Math.sqrt(n);
		long ans = 0;
		int m = 1;
		while (m + 1 <= ns / m) m++;
		tag:
		for (long i = 1; i < m; i++) {
			long h2 = i * i,
					nsh = ns / i;
			for (long j = 1; j <= i; j++)
				if (Library.gcd(j, i) == 1) {
					long g = j + i;
					if (g > nsh) continue tag;
					long g2 = g * g,
							ng = n / h2 / g2,
							f2 = j * j,
							a = (f2 + h2) * g2 + f2 * h2;
					ans += a * ng * (ng + 1) / 2;
				}
		}
		System.out.println(ans);
	}
}