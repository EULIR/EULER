public class Project153 {
	public static void main(String[] args) {
		final long MAX1 = 10000L;
		final long MAX2 = 100000000L;
		long ans = 0;
		for (int i = 0; i <= MAX1; i++) {
			//System.out.println(i);
			for (int j = i; j <= MAX1; j++) {
				if (i == 0 && j == 0 || Library.gcd(i, j) != 1) continue;
				for (long k = 1; k <= MAX2; k++) {
					long a = i * k;
					long b = j * k;
					long x = MAX2 / ((a * a + b * b) / k);
					if (x == 0) break;
					if (b == 0) ans += 2 * a * x;
					if (a != b) ans += a == 0 ? b * x : 2 * b * x;

				}
			}
		}
		System.out.println(ans);
	}
}
