public class Project363 {
	public static void main(String[] args) {
		int d = 3000000;
		double low = 0;
		double high = 1;
		while (high - low > 0.00000000001) {
			double v = (high + low) / 2;
			double S = 0;
			for (int i = 0; i < d; i++) {
				double cur = (double) i / d;
				double nex = (double) (i + 1) / d;
				S += x(cur, v) * y(nex, v) - x(nex, v) * y(cur, v);
			}
			if (S > Math.PI / 2) high = v;
			else low = v;
		}
		double l = 0;
		d = 30000000;
		for (int i = 0; i < d; i++) {
			double cur = (double) i / d;
			double nex = (double) (i + 1) / d;
			l += distance(x(cur, low), y(cur, low), x(nex, low), y(nex, low));
		}
		System.out.println(100 * (l - Math.PI / 2) / Math.PI * 2);
	}

	public static double x(double t, double v) {
		return (1 - t) * (1 - t) * (1 - t) + 3 * (1 - t) * (1 - t) * t + 3 * (1 - t) * t * t * v;
	}

	public static double y(double t, double v) {
		return t * t * t + 3 * t * t * (1 - t) + 3 * t * (1 - t) * (1 - t) * v;
	}

	public static double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}
}
