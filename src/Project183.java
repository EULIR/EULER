public class Project183 {
	public static void main(String[] args) {
		long sum = 0;
		for (int i = 5; i <= 100; i++) {
			//System.out.println(M(i));
			sum += M(i);
		}
		System.out.println(sum);
	}

	public static long M(int n) {
		int k = (int) (n / Math.E);
		double t1 = Math.pow((double) n / k, k);
		int m = k + 1;
		double t2 = Math.pow((double) n / m, m);
		if (t1 > t2) {
			int denominator = k / Library.gcd(n, k);
			while (denominator % 2 == 0)
				denominator /= 2;
			while (denominator % 5 == 0)
				denominator /= 5;
			return denominator == 1 ? -n : n;
		} else {
			int denominator =  m / Library.gcd(n, m);
			while (denominator % 2 == 0)
				denominator /= 2;
			while (denominator % 5 == 0)
				denominator /= 5;
			return denominator == 1 ? -n : n;
		}
	}
}
