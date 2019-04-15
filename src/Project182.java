public class Project182 {
	public static void main(String[] args) {
		final long p = 1009;
		final long q = 3643;
		long phi = (p - 1) * (q - 1);
		long min = Long.MAX_VALUE;
		long ans = 0;
		for (long i = 2; i < phi; i++)
			if (Library.gcd(i, phi) == 1) {
				long num = (Library.gcd(i - 1, p - 1) + 1) * (Library.gcd(i - 1, q - 1) + 1);
				if (num < min) {
					ans = 0;
					min = num;
				}
				if (num == min)
					ans += i;
			}
		System.out.println(ans);
	}

}
