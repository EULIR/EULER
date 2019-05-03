public class Project195 {
	public static void main(String[] args) {
		long MAX = 1053779;
		long max1 = (long) (MAX * 2 / Math.sqrt(3.));
		long max2 = (long) (MAX * 6 / Math.sqrt(3.));
		long ans = 0;
		for (long q = 1; q * q <= max1; q++)
			for (long p = q + 1; q * p <= max1; p++)
				if ((p - q) % 3 != 0 && Library.gcd(p, q) == 1)
					ans += max1 / (p * q);
		for (long q = 1; q * q <= max2; q++)
			for (long p = q + 3; p * q <= max2; p += 3)
				if (Library.gcd(p, q) == 1)
					ans += max2 / (p * q);
		System.out.println(ans);
	}
}
