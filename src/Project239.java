public class Project239 {
	public static void main(String[] args) {
		int p = 22;
		int n = 97;
		double l = factorial(25) / (factorial(p) * 6);
		double sum = 0;
		long s = 1;
		for (int i = 0; i <= p; i++) {
			sum += (s * binomial(p, i) * factorial(n - i));
			s *= -1;
		}
		l *= sum;
		double ans = l / factorial(100);
		System.out.println(ans);
	}

	static double factorial(int n) {
		if (n <= 1)
			return 1;
		return n * factorial(n - 1);
	}

	static double binomial(int n, int k) {
		return (factorial(n) / factorial(k)) / factorial(n - k);
	}
}
