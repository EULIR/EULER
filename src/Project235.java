public class Project235 {
	public static void main(String[] args) {
		double target = -6.0E11;
		double ans = 1.002;
		double change = 0.001;
		while (change > 1E-15) {
			double s = 0;
			for (int k = 1; k <= 5000; k++)
				s += Math.pow(ans, k - 1) * (900 - 3 * k);
			if (s > target)
				ans += change;
			else {
				ans -= change;
				change /= 10;
			}
		}
		System.out.println(ans);
	}
}
