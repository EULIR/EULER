public class Project286 {
	public static void main(String[] args) {
		double q = 52;
		double inc = 0.5;
		double eps = 0.00000000000001;
		double p = get(q);
		while (Math.abs(0.02 - p) > eps) {
			double cand = get(q + inc);
			if (cand >= 0.02) {
				p = cand;
				q += inc;
			}
			inc /= 2.0;
		}
		System.out.println(q);
	}

	public static double get(double q) {
		double[] prob = new double[51];
		prob[0] = 1;
		for (int i = 1; i <= 50; i++) {
			double[] nextProb = new double[51];
			double pSuccess = 1 - i / q;
			double pFail = 1 - pSuccess;
			for (int j = 0; j < i; j++) {
				nextProb[j + 1] += prob[j] * pSuccess;
				nextProb[j] += prob[j] * pFail;
			}
			prob = nextProb;
		}
		return prob[20];
	}
}