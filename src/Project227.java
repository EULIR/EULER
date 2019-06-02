public class Project227 {
	static public void main(String[] args) {
		int size = 100;
		int MAX = 100000;
		double[] prob = new double[size];
		prob[size / 2] = 1.0;
		double ans = 0.0;
		for (long i = 1; i <= MAX; i++) {
			prob = prob(prob, size);
			prob = prob(prob, size);
			ans += i * prob[0];
			prob[0] = 0.0;
		}
		System.out.println(ans);
	}

	static private double[] prob(double[] prob, int size) {
		double[] next = new double[size];
		for (int i = 0; i < size; ++i) {
			double v = prob[i];
			next[mod(i + 1, size)] += v / 6;
			next[mod(i - 1, size)] += v / 6;
			next[i] += 2 * v / 3;
		}
		return next;
	}

	static private int mod(int a, int b) {
		if (a >= 0) return a % b;
		else return (a + b) % b;
	}
}